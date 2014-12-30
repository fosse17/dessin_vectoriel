package com.geo_graphe;

public class DroiteSymCentrale extends Droite {
    Droite d;
    Pt O;

    DroiteSymCentrale(Droite d, Pt O, Pt A, Pt B, int id) {
        super(d.P[0], d.P[1], id);
        Pt X = new PtSymCentrale(d.P[0], O, -1);
        Pt Y = new PtSymCentrale(d.P[1], O, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.d = d;
        this.O = O;
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
        if (O.get_id() == id) O.update(x, y, id);
        Pt X = new PtSymCentrale(d.P[0], O, -1);
        Pt Y = new PtSymCentrale(d.P[1], O, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());

    }

}
