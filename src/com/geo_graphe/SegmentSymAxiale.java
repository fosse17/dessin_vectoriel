package com.geo_graphe;


/**
 * La classe SegmentSymAxiale permet de faire le symétrique d'un segment par rapport à une droite
 */
public class SegmentSymAxiale extends Segment {

    /**
     * Un segment s
     */
    Segment s;
    /**
     * Une droite Axe
     */
    Droite axe;

    /**
     * Instancie un nouveau segment symétrique du segment d'origine par rapport à une droite
     *
     * @param s the s
     * @param axe the axe
     * @param A the a
     * @param B the b
     * @param id the id
     */
    public SegmentSymAxiale(Segment s, Droite axe, Pt A, Pt B, int id) {
        super(A, B, id);
        Pt X = new PtSymAxiale(s.P[0], axe, -1);
        Pt Y = new PtSymAxiale(s.P[1], axe, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.s = s;
        this.axe = axe;
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        //P[0].setVisible(false);
        //P[1].setVisible(false);
        P[0].set_movable(false);
        P[1].set_movable(false);
    }

    @Override
    public void update(int x, int y, int id) {
        s.update(x, y, id);
        axe.update(x, y, id);
        Pt X = new PtSymAxiale(s.P[0], axe, -1);
        Pt Y = new PtSymAxiale(s.P[1], axe, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());

    }
}
