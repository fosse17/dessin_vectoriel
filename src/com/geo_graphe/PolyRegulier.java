package com.geo_graphe;

import java.awt.*;

/**
 * Created by Stephane on 21/12/14.
 */
public class PolyRegulier extends Forme2D implements forme {

    int id,nbcote,rayon,dx,dy;
    Polygon p;
    double angle;
    Color couleur = new Color(123, 123, 12, 50);
    int tranparence = 50;
    int tranparence_over = 70;


    public PolyRegulier(Pt A,Pt B,int nbcote,int id)
    {
        super(A, B, id);
        this.id=id;
        this.nbcote=nbcote;
        this.rayon=(int)A.distance(B.getX(),B.getY());
        dx = B.getX() - A.getX();
        dy=B.getY() - A.getY();
        angle = Math.atan2(dy, dx);
        p = new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.P[0].getX() + this.rayon * Math.cos(angle + i * 2 * Math.PI / this.nbcote)),
                    (int) (this.P[0].getY() + this.rayon * Math.sin(angle + i * 2 * Math.PI / this.nbcote)));
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

    @Override
    public int get_id() {
        return this.id;
    }

    @Override
    public void set_id(int i) {

    }

    @Override
    public void update(int x, int y, int id) {
        if (id == P[1].get_id()) {
            P[1].set_coord(x, y);
            this.rayon = (int) P[0].distance(P[1].getX(), P[1].getY());
            dx = P[1].getX() - P[0].getX();
            dy = P[1].getY() - P[0].getY();
           angle = Math.atan2(dy, dx);
       }
        if (id == P[0].get_id()) {
            P[0].set_coord(x, y);
            this.rayon = (int) P[0].distance(P[1].getX(), P[1].getY());
            dx = P[1].getX() - P[0].getX();
            dy = P[1].getY() - P[0].getY();
            angle = Math.atan2(dy, dx);
        }
        p = new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.P[0].getX() + this.rayon * Math.cos(angle + i * 2 * Math.PI / this.nbcote)),
                    (int) (this.P[0].getY() + this.rayon * Math.sin(angle + i * 2 * Math.PI / this.nbcote)));

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
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setVisible(Boolean visible) {

    }
}
