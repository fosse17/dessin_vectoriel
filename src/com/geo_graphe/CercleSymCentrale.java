package com.geo_graphe;

/**
 * Classe pour créer le symétrique d'un cercle par rapport à un point
 */
public class CercleSymCentrale extends Cercle {

    /**
     * Le cercle C a symétrisé
     */
    Cercle c;
    /**
     * Un point O pour la symétrie
     */
    Pt O;

    /**
     * Instancie un nouveau cercle qui sera le symétrique du cercle selectionné par rapport à une point.
     * Ce nouveau cercle ne sera pas déplacable.
     *
     * @param c the c
     * @param O the b
     * @param A the a
     * @param B the b
     * @param id the i
     */
    public CercleSymCentrale(Cercle c, Pt O, Pt A, Pt B, int id) {
        super(c.P[0], c.P[1], id);
        Pt X = new PtSymCentrale(c.P[0], O, -1);
        Pt Y = new PtSymCentrale(c.P[1], O, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.c = c;
        this.O = O;
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        P[0].setVisible(false);
        P[1].setVisible(false);
        P[0].set_movable(false);
        P[1].set_movable(false);
    }

    /**
     *
     * @param x nouvelle abscisse
     * @param y nouvelle ordonnée
     * @param id the id
     */
    public void update(int x, int y, int id) {
        c.update(x, y, id);
        if (O.get_id() == id) O.update(x, y, id);
        Pt X = new PtSymCentrale(c.P[0], O, -1);
        Pt Y = new PtSymCentrale(c.P[1], O, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        ;
        dx = P[1].getX() - P[0].getX();
        dy = P[1].getY() - P[0].getY();
        rayon = (int) Math.sqrt((dx) * (dx) + (dy) * (dy));
        //rayon=c.rayon;

    }

}
