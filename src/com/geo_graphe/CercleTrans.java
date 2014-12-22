package com.geo_graphe;

/**
 * Created by Stephane on 22/12/14.
 */
public class CercleTrans extends Cercle {

    Cercle c;
    vecteur v;
    /**
     * Instantiates a new Cercle.
     *
     * @param  c
     * @param v the b
     * @param id the i
     */
    public CercleTrans(Cercle c, vecteur v,Pt A, Pt B, int id) {
        super(c.P[0], c.P[1], id);
        Pt X=new PtTrans(c.P[0],v,-1);
        Pt Y=new PtTrans(c.P[1],v,-1);
        this.P[0]=A;
        this.P[1]=B;
        this.c=c;
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
        c.update(x,y,id);
        v.update(x,y,id);
        Pt X=new PtTrans(c.P[0],v,-1);
        Pt Y=new PtTrans(c.P[1],v,-1);
        this.P[0].set_coord(X.getX(), X.getY());
        this.P[1].set_coord(Y.getX(), Y.getY());;
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
        //rayon=c.rayon;

    }
}
