package com.geo_graphe;

import java.awt.*;

/**
 * Created by Stephane on 28/12/14.
 */
public class Polygone extends Forme2D implements forme {

    Polygon p;
    int num_pts;
    Color couleur = new Color(123, 123, 12, 50);
    int tranparence = 50;
    int tranparence_over = 70;
    boolean deformable;

    Polygone(Pt[] pts, int n, int id) {
        super(pts, pts.length, id);
        this.num_pts = n;
        p = new Polygon();
        for (int i = 0; i < this.num_pts; i++) {
            p.addPoint(this.P[i].getX(), this.P[i].getY());
        }
        this.deformable = true;
    }

    public boolean get_deformable() {
        return this.deformable;
    }

    public void set_deformable(boolean def) {
        this.deformable = def;
    }

    public boolean isNear(int x, int y) {
        if (p.contains(x, y)) {
            couleur = new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), this.tranparence_over);
            return true;
        } else {
            couleur = new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), this.tranparence);
            return false;
        }
    }

    public void add(Pt A) {

        this.P[num_pts] = A;
        this.num_pts++;
        p.addPoint(A.getX(), A.getY());
    }

    public void minus() {
        this.num_pts--;
        p = new Polygon();
        for (int i = 0; i < this.num_pts; i++) {
            p.addPoint(P[i].getX(), P[i].getY());
        }
    }

    public void updatelast(int x, int y) {
        this.P[num_pts - 1].set_coord(x, y);
        p = new Polygon();
        for (int i = 0; i < this.num_pts; i++) {
            p.addPoint(P[i].getX(), P[i].getY());
        }
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
        int t = this.to_update(id);
        if (t != -1) P[t].update(x, y, id);
        System.out.println("up du point " + t);
        p = new Polygon();
        for (int i = 0; i < this.num_pts; i++) {
            p.addPoint(P[i].getX(), P[i].getY());
        }
    }

    @Override
    public Color get_couleur() {
        return this.couleur;
    }

    @Override
    public void set_couleur(Color c) {
        this.couleur = new Color(c.getRed(), c.getGreen(), c.getBlue(), this.tranparence);
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
        Color c = g.getColor();

        g.setColor(new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue()));
        g.drawPolygon(p);

        g.setColor(couleur);
        g.fillPolygon(p);

        g.setColor(c);
    }

    @Override
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
