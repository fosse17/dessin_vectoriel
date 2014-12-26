package com.geo_graphe;

import java.awt.*;

/**
 * Created by Stephane on 26/12/14.
 */
public class PolyRegulierSymCentrale extends PolyRegulier {

    PolyRegulier poly;
    Pt O;

    public PolyRegulierSymCentrale(PolyRegulier poly, Pt O, Pt A, Pt B, int id) {
        super(A, B, poly.nbcote, id);
        P[0].set_movable(false);
        P[1].set_movable(false);
        this.poly = poly;
        this.O = O;
        Pt X = new PtSymCentrale(poly.P[0], O, -1);
        Pt Y = new PtSymCentrale(poly.P[1], O, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
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
        if (O.get_id() == id) O.update(x, y, id);
        Pt X = new PtSymCentrale(poly.P[0], O, -1);
        Pt Y = new PtSymCentrale(poly.P[1], O, -1);
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
