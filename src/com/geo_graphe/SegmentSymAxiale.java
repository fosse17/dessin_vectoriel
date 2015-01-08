package com.geo_graphe;


public class SegmentSymAxiale extends Segment {

    Segment s;
    Droite axe;

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
