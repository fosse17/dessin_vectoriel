package com.geo_graphe;


/**
 * Transposé d'un point par rapport à un vecteur
 */
public class PtTrans extends Pt {

    /**
     * Le point A
     */
    Pt A;
    /**
     * Le vecteur V
     */
    vecteur v;

    /**
     * Instancie un nouveau point, transposé du point d'origine
     *
     * @param A the a
     * @param v the v
     * @param id the id
     */
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
