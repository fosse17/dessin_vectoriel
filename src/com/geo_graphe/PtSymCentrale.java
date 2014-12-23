package com.geo_graphe;

/**
 * Created by Stephane on 24/12/14.
 */
public class PtSymCentrale extends Pt {

    Pt A;
    Pt O;

    public PtSymCentrale(Pt A, Pt O, int i) {
        super(2 * O.getX() - A.getX(), 2 * O.getY() - A.getY(), i);
        this.A = A;
        this.O = O;
        this.set_movable(false);
    }

    @Override
    public void update(int x, int y, int id) {
        if ((id == this.A.get_id()) || (id == this.O.get_id())) {
            this.set_coord(2 * O.getX() - A.getX(), 2 * O.getY() - A.getY());
        }

    }
}
