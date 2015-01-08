package com.geo_graphe;


/**
 * Création d'un symétrique d'un point par rapport à un autre point.
 */
public class PtSymCentrale extends Pt {

    /**
     * Un point A
     */
    Pt A;
    /**
     * Un point O
     */
    Pt O;

    /**
     * Instancie un nouveau point, symétrique d'un point par rapport à un autre.
     *
     * @param A the a
     * @param O the o
     * @param i the i
     */
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
