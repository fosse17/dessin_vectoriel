package com.geo_graphe;


public class PtTrans extends Pt {

    Pt A;
    vecteur v;

    public PtTrans(Pt A,vecteur v, int id) {
        super(A.getX()+v.P[1].getX()-v.P[0].getX(), A.getY()+v.P[1].getY()-v.P[0].getY(), id);
        this.A=A;
        this.v=v;
        this.setMovable(false);
    }

    @Override
    public void update(int x, int y, int id) {
        if (id == this.A.get_id()) {
            this.set_coord(A.getX() + v.P[1].getX() - v.P[0].getX(), A.getY() + v.P[1].getY() - v.P[0].getY());
        } else {
            v.update(x, y, id);
            this.set_coord(A.getX() + v.P[1].getX() - v.P[0].getX(), A.getY() + v.P[1].getY() - v.P[0].getY());
        }
    }
}
