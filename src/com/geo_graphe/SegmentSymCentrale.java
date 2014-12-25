package com.geo_graphe;

/**
 * Created by Stephane on 25/12/14.
 */
public class SegmentSymCentrale extends Segment {

    Segment s;
    Pt O;


    public SegmentSymCentrale(Segment s, Pt O, Pt A, Pt B, int id) {
        super(s.P[0], s.P[1], id);
        Pt X = new PtSymCentrale(s.P[0], O, -1);
        Pt Y = new PtSymCentrale(s.P[1], O, -1);
        this.P[0] = A;
        this.P[1] = B;
        this.s = s;
        this.O = O;
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
        if (O.get_id() == id) O.update(x, y, id);
        Pt X = new PtSymCentrale(s.P[0], O, -1);
        Pt Y = new PtSymCentrale(s.P[1], O, -1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());

    }
}
