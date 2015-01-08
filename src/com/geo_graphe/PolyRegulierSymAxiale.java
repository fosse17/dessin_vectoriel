package com.geo_graphe;

import java.awt.*;

/**
 * Le symétrie par rapport à une droite d'un polygone Régulier
 */
public class PolyRegulierSymAxiale extends PolyRegulier {
    /**
     * Un Polygone
     */
    PolyRegulier poly;
    /**
     * L'axe de symétrie
     */
    Droite axe;


    /**
     * Instancie un nouveau Polygone
     *
     * @param poly the poly
     * @param axe the axe
     * @param A the a
     * @param B the b
     * @param id the id
     */
    public PolyRegulierSymAxiale(PolyRegulier poly, Droite axe, Pt A, Pt B, int id) {
        super(A, B, poly.nbcote, id);
        P[0].set_movable(false);
        P[1].set_movable(false);
        this.poly = poly;
        this.axe = axe;
        Pt X = new PtSymAxiale(poly.P[0], axe, -1);
        Pt Y = new PtSymAxiale(poly.P[1], axe, -1);
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

    @Override
    public void update(int x, int y, int id) {
        poly.update(x, y, id);
        axe.update(x, y, id);
        Pt X = new PtSymAxiale(poly.P[0], axe, -1);
        Pt Y = new PtSymAxiale(poly.P[1], axe, -1);
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
