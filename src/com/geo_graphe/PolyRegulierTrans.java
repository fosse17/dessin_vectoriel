package com.geo_graphe;

import java.awt.*;


public class PolyRegulierTrans extends PolyRegulier {

    PolyRegulier poly;
    vecteur v;

    public PolyRegulierTrans(PolyRegulier poly, vecteur v, Pt A, Pt B, int id) {
        super(A, B, poly.nbcote, id);
        P[0].set_movable(false);
        P[1].set_movable(false);
        this.poly = poly;
        this.v = v;
        Pt X = new PtTrans(poly.P[0], v, -1);
        Pt Y = new PtTrans(poly.P[1], v, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        this.id = id;
        this.rayon = (int) A.distance(B.getX(), B.getY());
        dx = B.getX() - A.getX();
        dy = B.getY() - A.getY();
        angle = Math.atan2(dy, dx);
        p = new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.P[0].getX() + this.rayon * Math.cos(angle + i * 2 * Math.PI / this.nbcote)),
                    (int) (this.P[0].getY() + this.rayon * Math.sin(angle + i * 2 * Math.PI / this.nbcote)));
    }

    @Override
    public void update(int x, int y, int id) {
        poly.update(x, y, id);
        v.update(x, y, id);
        Pt X = new PtTrans(poly.P[0], v, -1);
        Pt Y = new PtTrans(poly.P[1], v, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        this.rayon = (int) this.P[0].distance(this.P[1].getX(), this.P[1].getY());
        dx = this.P[1].getX() - this.P[0].getX();
        dy = this.P[1].getY() - this.P[0].getY();
        angle = Math.atan2(dy, dx);
        p = new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.P[0].getX() + this.rayon * Math.cos(angle + i * 2 * Math.PI / this.nbcote)),
                    (int) (this.P[0].getY() + this.rayon * Math.sin(angle + i * 2 * Math.PI / this.nbcote)));
    }
}
