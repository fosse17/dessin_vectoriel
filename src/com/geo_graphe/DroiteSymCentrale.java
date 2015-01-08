package com.geo_graphe;

/**
 * La classe DroiteSymCentrale permet de créer le symétrique d'une droite par rapport à un point
 */
public class DroiteSymCentrale extends Droite {
    /**
     * La droite d
     */
    Droite d;
    /**
     * Un point O
     */
    Pt O;

    /**
     * Instancie une nouvelle droite qui est le symétrique de la droite d'origine par rapport à un point..
     *
     * @param d the d
     * @param O the o
     * @param A the a
     * @param B the b
     * @param id the id
     */
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
