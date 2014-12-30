package com.geo_graphe;

/**
 * The type Cercle sym axiale.
 */
public class CercleSymAxiale extends Cercle {

    /**
     * Un cercle C
     */
    Cercle c;
    /**
     * Une droite axe
     */
    Droite axe;

    /**
     * Instancie un nouveau cercle qui sera le symétrique du cercle selectionné par rapport à une droite.
     * Ce nouveau cercle ne sera pas déplacable.
     *
     * @param c Un cercle
     * @param axe Une droite pour la symétrie
     * @param A Un point A
     * @param B Un point B
     * @param i un id i
     */
    public CercleSymAxiale(Cercle c, Droite axe, Pt A, Pt B, int i) {
        super(c.P[0], c.P[1], i);
        Pt X = new PtSymAxiale(c.P[0], axe, -1);
        Pt Y = new PtSymAxiale(c.P[1], axe, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.c = c;
        this.axe = axe;
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
        axe.update(x, y, id);
        Pt X = new PtSymAxiale(c.P[0], axe, -1);
        Pt Y = new PtSymAxiale(c.P[1], axe, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        ;
        dx = P[1].getX() - P[0].getX();
        dy = P[1].getY() - P[0].getY();
        rayon = (int) Math.sqrt((dx) * (dx) + (dy) * (dy));
        //rayon=c.rayon;
    }
}
