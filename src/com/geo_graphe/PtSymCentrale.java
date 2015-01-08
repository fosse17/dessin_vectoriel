package com.geo_graphe;


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
