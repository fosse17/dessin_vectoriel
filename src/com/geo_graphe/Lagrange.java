package com.geo_graphe;

import java.awt.*;

/**
 * Created by Stephane on 03/01/15.
 */
public class Lagrange extends Forme2D implements forme {

    int xmin, xmax;

    Lagrange(Pt[] pts, int n, int id) {
        super(pts, n, id);
        get_min_max();
    }


    public int interpole(int desireX) {
        float desiredY = 0;
        for (int j = 0; j < this.num_point; ++j) {
            float weight = 1;
            for (int i = 0; i < this.num_point; ++i) {
                if (i != j) {
                    float xi = (float) this.P[i].getX();
                    float xj = (float) this.P[j].getX();
                    weight *= (desireX - xi) / (xj - xi);
                }
            }
            float yj = (float) this.P[j].getY();
            desiredY += weight * yj;
        }
        return (int) desiredY;
    }

    public void add(Pt A) {
        this.P[num_point] = A;
        this.num_point++;
    }

    private void get_min_max() {
        int my_min = Integer.MAX_VALUE;
        int my_max = 0;
        for (int i = 0; i < this.num_point; ++i) {
            if (P[i].getX() < my_min) my_min = P[i].getX();
            if (P[i].getX() > my_max) my_max = P[i].getX();
        }
        this.xmin = my_min;
        this.xmax = my_max;
    }

    @Override
    public int get_id() {
        return this.id;
    }

    @Override
    public void set_id(int i) {
        this.id = i;
    }

    @Override
    public void update(int x, int y, int id) {
        for (int i = 0; i < this.num_point; ++i) {
            if (P[i].get_id() == id) P[i].set_coord(x, y);
        }


    }

    @Override
    public Color get_couleur() {
        return this.couleur;
    }

    @Override
    public void set_couleur(Color c) {
        this.couleur = c;
    }

    @Override
    public boolean is_movable() {
        return true;
    }

    @Override
    public void set_movable(Boolean c) {

    }

    @Override
    public void draw(Graphics g) {
        get_min_max();
        for (int i = xmin; i < xmax; i++)
            g.drawLine(i, interpole(i), i + 1, interpole(i + 1));
    }

    @Override
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
