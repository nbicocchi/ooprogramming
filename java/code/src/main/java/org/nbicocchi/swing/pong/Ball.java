package org.nbicocchi.swing.pong;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Ball extends AbstractGameObject {
    public Ball(JPanel parent, HashMap<String, GameObject> hgo,
                int w, int h, int x, int y, int speedX, int speedY) {
        this.parent = parent;
        this.hgo = hgo;
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void update() {
        x += speedX;
        y += speedY;

        // left wall
        if (x < 0) {
            speedX = -speedX;
            Player p = ((Player) hgo.get("player_dx"));
            p.setScore(p.getScore() + 1);
        }

        // right wall
        if (x > parent.getWidth() - w) {
            speedX = -speedX;
            Player p = ((Player) hgo.get("player_sx"));
            p.setScore(p.getScore() + 1);
        }

        // horizontal walls
        if (y < 0 || y > parent.getHeight() - w) {
            speedY = -speedY;
        }

        // players
        for (GameObject go : hgo.values()) {
            if (go != this) {
                if (go.getBounds().intersects(getBounds())) {
                    speedX = -speedX;
                }
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, w, h);
    }
}
