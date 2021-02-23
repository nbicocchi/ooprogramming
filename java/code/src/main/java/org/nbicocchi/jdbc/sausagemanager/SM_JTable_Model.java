package org.nbicocchi.jdbc.sausagemanager;

import org.nbicocchi.jdbc.DBManager;
import org.nbicocchi.utils.Utils;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SM_JTable_Model extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] columnNames = new String[]{"id", "length", "diameter", "weight", "quality"};
    private final Class<?>[] columnClass = new Class<?>[]{String.class, Double.class, Double.class, Double.class,
            String.class};
    private ResultSet rs;

    public SM_JTable_Model() throws SQLException {
        DBManager.setConnection(
                Utils.JDBC_Driver_MySQL,
                Utils.JDBC_URL_MySQL);
        Statement statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        try {
            rs = statement.executeQuery("SELECT * FROM sausage");
            rs.first();
        } catch (SQLException e) {
            statement.executeUpdate("DROP TABLE IF EXISTS sausage");
            statement.executeUpdate("CREATE TABLE sausage (" + "id VARCHAR(50) PRIMARY KEY, " + "length REAL, diameter REAL, " + "weight REAL, " + "quality VARCHAR(50))");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
        }
    }

    public void insertRow(Object[] data) {
        try {
            rs.moveToInsertRow();
            rs.updateString("id", java.util.UUID.randomUUID().toString());
            rs.updateDouble("length", Double.parseDouble((String) data[0]));
            rs.updateDouble("diameter", Double.parseDouble((String) data[1]));
            rs.updateDouble("weight", Double.parseDouble((String) data[2]));
            rs.updateString("quality", (String) data[3]);
            rs.insertRow();
            fireTableRowsInserted(rs.getRow(), rs.getRow());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeRow(int firstRow, int lastRow) {
        try {
            rs.absolute(firstRow);
            for (int i = firstRow; i <= lastRow; i++) {
                rs.deleteRow();
            }
            fireTableRowsDeleted(firstRow, lastRow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex);
            switch (columnIndex) {
                case 0:
                    rs.updateString("id", (String) aValue);
                    rs.updateRow();
                    break;
                case 1:
                    rs.updateDouble("length", (Double) aValue);
                    rs.updateRow();
                    break;
                case 2:
                    rs.updateDouble("diameter", (Double) aValue);
                    rs.updateRow();
                    break;
                case 3:
                    rs.updateDouble("weight", (Double) aValue);
                    rs.updateRow();
                    break;
                case 4:
                    rs.updateString("quality", (String) aValue);
                    rs.updateRow();
                    break;
            }
            rs.updateRow();
            fireTableCellUpdated(rowIndex, columnIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (SQLException e) {
            // do nothing
        }
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            switch (columnIndex) {
                case 0:
                    return rs.getString("id");
                case 1:
                    return rs.getDouble("length");
                case 2:
                    return rs.getDouble("diameter");
                case 3:
                    return rs.getDouble("weight");
                case 4:
                    return rs.getString("quality");
            }
            throw new IllegalStateException("Unhandled column index: " + columnIndex);
        } catch (SQLException e) {
            // do nothing
        }
        return null;
    }
}