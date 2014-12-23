package com.geo_graphe;

/**
 * Created by Stephane on 22/12/14.
 */
public class DroiteTrans extends Droite {

    Droite d;
    vecteur v;

    DroiteTrans(Droite d,vecteur v,Pt A, Pt B, int id) {
        super(d.P[0], d.P[1], id);
        Pt X=new PtTrans(d.P[0],v,-1);
        Pt Y=new PtTrans(d.P[1],v,-1);
        this.P[0]=A;
        this.P[1]=B;
        this.d=d;
        this.v=v;
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());
        P[0].setVisible(false);
        P[1].setVisible(false);
        P[0].set_movable(false);
        P[1].set_movable(false);
    }

    @Override
    public void update(int x, int y, int id) {
        d.update(x,y,id);
        v.update(x,y,id);
        Pt X=new PtTrans(d.P[0],v,-1);
        Pt Y=new PtTrans(d.P[1],v,-1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());

    }
}
