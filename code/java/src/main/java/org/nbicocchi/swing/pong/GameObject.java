package org.nbicocchi.swing.pong;

import java.awt.*;

public interface GameObject {
    void update();

    void paint(Graphics g);

    Rectangle getBounds();

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    int getSpeedX();

    int getSpeedY();

    void setSpeedX(int sx);

    void setSpeedY(int sy);
}
