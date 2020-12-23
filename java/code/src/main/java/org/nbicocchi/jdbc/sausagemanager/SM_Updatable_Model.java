package org.nbicocchi.jdbc.sausagemanager;

import org.nbicocchi.jdbc.DBManager;
import org.nbicocchi.utils.Sausage;
import org.nbicocchi.utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SM_Updatable_Model {
    ResultSet rs;

    public SM_Updatable_Model() throws SQLException {
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

    public Sausage getSelectedItem() {
        try {
            return new Sausage(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
                    rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSelectedIndex() {
        try {
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void first() {
        try {
            rs.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void last() {
        try {
            rs.last();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void next() {
        try {
            if (!rs.isLast())
                rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void previous() {
        try {
            if (!rs.isFirst())
                rs.previous();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(double length, double diameter, double weight, String quality) {
        try {
            rs.moveToInsertRow();
            rs.updateString("id", java.util.UUID.randomUUID().toString());
            rs.updateDouble("length", length);
            rs.updateDouble("diameter", diameter);
            rs.updateDouble("weight", weight);
            rs.updateString("quality", quality);
            rs.insertRow();
            rs.last();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void remove() {
        try {
            rs.deleteRow();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void setLength(double length) {
        try {
            rs.updateDouble("length", length);
            rs.updateRow();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void setDiameter(double diameter) {
        try {
            rs.updateDouble("diameter", diameter);
            rs.updateRow();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void setWeight(double weight) {
        try {
            rs.updateDouble("weight", weight);
            rs.updateRow();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void setQuality(String quality) {
        try {
            rs.updateString("quality", quality);
            rs.updateRow();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
