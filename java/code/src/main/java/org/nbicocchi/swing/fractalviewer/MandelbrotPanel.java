package org.nbicocchi.swing.fractalviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;

/**
 * This is a fairly simple subclass of jawa.awt.JPanel that can display a part
 * of the Mandelbrot set. The interval bounds and the depth limit can be set at
 * run time to select which part you want to be shown.
 */
public class MandelbrotPanel extends JPanel {
    /**
     * Number of non-black colours in the colour table (the last entry is always
     * black, and is not included in this number).
     */
    public static final int NUM_COLORS = 255;
    private static final long serialVersionUID = 1L;
    /**
     * Colour table for this component (actually the BufferedImage)
     */
    protected IndexColorModel color_table;

    /**
     * Last rendered Image for this component (cached between paint()
     * invocations), initially null
     *
     * @see #paint(Graphics)
     */
    protected BufferedImage image;

    /**
     * Current depth limit for the Mandelbrot iteration
     */
    protected int limit;

    /**
     * Current interval bounds (scaled to the panel size)
     */
    protected double re_min = -2.00, re_max = +0.50,
            im_min = -1.25, im_max = +1.25;

    /**
     * Initialize a new MandelbrotPanel: Create and fill an IndexColorModel with
     * the colour table and add a Mouse(Motion)Listener to the JPanel. The
     * initial interval is [-2, 0.5] x [-1.25, 1.25].
     *
     * @param limit depth limit for iteration
     */
    public MandelbrotPanel(int limit) {
        byte[] red = new byte[NUM_COLORS + 1];    // RGB values
        byte[] green = new byte[NUM_COLORS + 1];
        byte[] blue = new byte[NUM_COLORS + 1];
        MouseHandler handler = new MouseHandler();    // MouseListener

        if (limit < 0)
            throw new IllegalArgumentException("invalid limit");

        this.limit = limit;
        addMouseListener(handler);
        addMouseMotionListener(handler);

        // fill the colour table with silly color gradients
        for (int index = 0; index < NUM_COLORS; ++index) {
            red[index] = (byte) (252 - index % 64 * 4);
            green[index] = (byte) (32 + index % 32 * 6);
            blue[index] = (byte) (64 + index % 64 * 3);
        }

        // add black to the table and create the colour model
        red[NUM_COLORS] = green[NUM_COLORS] = blue[NUM_COLORS] = 0;
        color_table = new IndexColorModel(8, NUM_COLORS + 1, red, green, blue);
    }

    /**
     * Reset the interval of this MandelbrotPanel to the given values.
     *
     * @throws IllegalArgumentException if the interval is empty
     */
    public void setInterval(double re_min, double re_max,
                            double im_min, double im_max) {
        if (re_min >= re_max || im_min >= im_max)
            throw new IllegalArgumentException("invalid interval");

        this.re_min = re_min;
        this.re_max = re_max;
        this.im_min = im_min;
        this.im_max = im_max;
        image = null;                // invalidate image
        repaint();                // schedule repaint
    }

    /**
     * Set a new depth limit (which must be &gt;= 0) for the iteration.
     *
     * @throws IllegalArgumentException if <tt>limit</tt> is negative
     */
    public void setLimit(int limit) {
        if (limit < 0)
            throw new IllegalArgumentException("invalid limit");

        this.limit = limit;
        image = null;                // invalidate image
        repaint();                // schedule repaint
    }

    /**
     * Redraw this component. Recalculates the BufferedImage if needed (the
     * BufferedImage is cached for efficiency reasons) and draws it into the
     * component. This implementation uses a simple 8-bit IndexColorModel and a
     * PackedRaster (the type of raster really doesn't matter here).
     */
    @Override
    public void paint(Graphics graph) {
        int width = getWidth();            // component width
        int height = getHeight();        // component height

        // need to recalculate the image?
        if (image == null || image.getWidth() != width ||
                image.getHeight() != height) {
            double re_size = re_max - re_min;    // interval width
            double im_size = im_max - im_min;    // interval heigth
            byte[] pixels = new byte[width * height];
            DataBufferByte buffer;        // byte array buffer
            WritableRaster raster;        // image raster
            int x, y;                // pixel position

            for (x = 0; x < width; ++x)        // fill byte array
                for (y = 0; y < height; ++y) {
                    int depth = iterate(re_size * x / width + re_min,
                            im_size * y / height + im_min, limit);

                    // compensate for mirrored coordinate system
                    pixels[(height - 1 - y) * width + x] = (byte)
                            (depth > limit ? NUM_COLORS : depth % NUM_COLORS);
                }

            // use the byte array to fill the PackedRaster and create the
            // BufferedImage from the WritableRaster and the ColorModel.
            // (an InterleavedRaster works here as well...)
            buffer = new DataBufferByte(pixels, pixels.length);
            raster = Raster.createPackedRaster(buffer, width, height, 8, null);
            image = new BufferedImage(color_table, raster, false, null);
        }

        graph.drawImage(image, 0, 0, this);    // finally: draw it
    }

    /**
     * Perform the Mandelbrot iteration for a single complex coordinate until
     * the iteration terminates or the given depth limit is reached.
     *
     * @param re_c,im_c current complex coordinate
     * @param limit     depth limit for iteration
     * @return number of iterations performed (0 ... <tt>limit</tt> + 1)
     */
    public static int iterate(double re_c, double im_c, int limit) {
        int depth = 0;                // number of iterations
        double re_z = 0, im_z = 0;        // current value of z
        double re_z_sqr = 0, im_z_sqr = 0;    // squared values

        // iterate until |z| >= 2 or limit exceeded
        while (re_z_sqr + im_z_sqr < 4 && ++depth <= limit) {
            re_z_sqr = re_z * re_z;        // calculate squares
            im_z_sqr = im_z * im_z;

            im_z = 2 * re_z * im_z + im_c;    // perform iteration
            re_z = re_z_sqr - im_z_sqr + re_c;
        }

        return depth;
    }

    /**
     * MouseListener and MouseMotionListener to allow the user to draw a zoom
     * rectangle with the mouse inside the image (which will then be magnified
     * to show only the selected region).
     */
    protected class MouseHandler extends MouseAdapter
            implements MouseMotionListener {
        /**
         * Starting position of mouse drag
         */
        private int start_x, start_y;

        /**
         * Current mouse position (from MouseEvent)
         */
        private int x, y;

        /**
         * A mouse button was clicked -&gt; zoom out if right mouse button
         */
        @Override
        public void mouseClicked(MouseEvent event) {
            if (SwingUtilities.isRightMouseButton(event))
                // (min + max)/2 - 2 (max - min)/2 = 1.5 min - 0.5 max etc.
                setInterval(1.5 * re_min - 0.5 * re_max,
                        1.5 * re_max - 0.5 * re_min,
                        1.5 * im_min - 0.5 * im_max,
                        1.5 * im_max - 0.5 * im_min);
        }

        /**
         * A mouse button was pressed -&gt; start rectangle
         */
        @Override
        public void mousePressed(MouseEvent event) {
            Graphics graph = getGraphics();    // graphics context

            start_x = x = event.getX();    // store position
            start_y = y = event.getY();
            graph.setXORMode(Color.white);    // use XOR-mode (for erase)
            graph.drawRect(start_x, start_y, x - start_x, y - start_y);
            graph.dispose();        // dispose graphics
        }

        /**
         * A mouse button was released -&gt; finish rectangle
         */
        @Override
        public void mouseReleased(MouseEvent event) {
            Graphics graph = getGraphics();    // graphics context

            graph.setXORMode(Color.white);    // use XOR-mode (for erase)
            graph.drawRect(start_x, start_y, x - start_x, y - start_y);
            x = event.getX();        // store position
            y = event.getY();
            graph.dispose();        // dispose graphics

            if (x > start_x && y > start_y)    // valid interval?
            {
                double re_size = re_max - re_min;
                double im_size = im_max - im_min;
                int width = getWidth();    // component width
                int height = getHeight();    // component height

                // compensate for mirrored coordinate system
                start_y = height - 1 - start_y;
                y = height - 1 - y;

                setInterval(re_size * start_x / width + re_min,
                        re_size * x / width + re_min,
                        im_size * y / height + im_min,
                        im_size * start_y / height + im_min);
            }

        }

        /**
         * The mouse has moved while a mouse button was pressed.
         */
        @Override
        public void mouseDragged(MouseEvent event) {
            Graphics graph = getGraphics();    // graphics context

            graph.setXORMode(Color.white);    // use XOR-mode (for erase)
            graph.drawRect(start_x, start_y, x - start_x, y - start_y);
            x = event.getX();        // store position
            y = event.getY();
            graph.drawRect(start_x, start_y, x - start_x, y - start_y);
            graph.dispose();        // dispose graphics

        }

        @Override
        public void mouseMoved(MouseEvent event) {
        }    // ignore
    }
}
