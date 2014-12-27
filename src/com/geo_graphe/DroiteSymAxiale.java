package com.geo_graphe;

/**
 * Created by Stephane on 27/12/14.
 */
public class DroiteSymAxiale extends Droite {
    Droite d, axe;

    DroiteSymAxiale(Droite d, Droite axe, Pt A, Pt B, int id) {
        super(A, B, id);
        Pt X = new PtSymAxiale(d.P[0], axe, -1);
        Pt Y = new PtSymAxiale(d.P[1], axe, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.d = d;
        this.axe = axe;
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        P[0].setVisible(false);
        P[1].setVisible(false);
        P[0].set_movable(false);
        P[1].set_movable(false);
    }

    @Override
    public void update(int x, int y, int id) {
        d.update(x, y, id);
        axe.update(x, y, id);
        Pt X = new PtSymAxiale(d.P[0], axe, -1);
        Pt Y = new PtSymAxiale(d.P[1], axe, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());

    }
}
