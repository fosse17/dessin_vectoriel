package com.geo_graphe;


/**
 * La classe SegmentTrans pour créer la transposée d'un segment.
 */
public class SegmentTrans extends Segment {

    /**
     * The S.
     */
    Segment s;
    /**
     * The V.
     */
    vecteur v;


    /**
     * Instancie une nouveau segment transposé du segment d'origine
     *
     * @param s the s
     * @param v the v
     * @param A the a
     * @param B the b
     * @param id the id
     */
    public SegmentTrans(Segment s, vecteur v, Pt A, Pt B, int id) {
        super(s.P[0], s.P[1], id);
        Pt X = new PtTrans(s.P[0], v, -1);
        Pt Y = new PtTrans(s.P[1], v, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.s = s;
        this.v = v;
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        P[0].setVisible(false);
        P[1].setVisible(false);
        P[0].set_movable(false);
        P[1].set_movable(false);
    }

    @Override
    public void update(int x, int y, int id) {
        s.update(x, y, id);
        v.update(x, y, id);
        Pt X = new PtTrans(s.P[0], v, -1);
        Pt Y = new PtTrans(s.P[1], v, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());

    }
}
