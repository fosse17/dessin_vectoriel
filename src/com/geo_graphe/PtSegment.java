package com.geo_graphe;


/**
 * La classe PtSegment permet de créer un point sur un segment
 */
public class PtSegment extends Pt {

    /**
     * Un segment d
     */
    Segment d;
    /**
     * The A bx.
     */
    int ABx, /**
     * The A by.
     */
    ABy;
    /**
     * The Dx.
     */
    double dx, /**
     * The Dy.
     */
    dy;
    /**
     * The T.
     */
    double t;

    /**
     * Instancie un nouveau point sur un segment
     *
     * @param d1 the d 1
     * @param a the a
     * @param b the b
     * @param i the i
     */
    PtSegment(Segment d1,int a, int b, int i) {
        super(a, b, i);
        this.d=d1;
        ABx=d.P[1].getX()-d.P[0].getX();
        ABy=d.P[1].getY()-d.P[0].getY();
        dx=(double)(this.getX()-d.P[0].getX());

        dy=(double)(this.getY()-d.P[0].getY());
        //System.out.println("dx.... :"+(dx*dx+dy*dy));
        t = (dx * dx + dy * dy) / (double)(ABx * ABx + ABy * ABy);
        t=Math.sqrt(t);
        if(t<0) t=0;
        if(t>1) t=1;
        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }

    /**
     * Modifie la position du point courant sur le segment
     *
     * @param a the a
     * @param b the b
     */
    public void updatepos(int a,int b)
    {
        dx=(double)(a-d.P[0].getX());

        dy=(double)(b-d.P[0].getY());
        //System.out.println("dx.... :"+(dx*dx+dy*dy));
        t = (dx * dx + dy * dy) / (double)(ABx * ABx + ABy * ABy);
        t=Math.sqrt(t);
        if(t<0) t=0;
        if(t>1) t=1;
        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }

    /**
     * Modifie la position d'un point sur un segment
     * @param a
     * @param b
     * @param id
     */
    public void update(int a,int b,int id)
    {
        //d.update(a,b,id);
        ABx=d.P[1].getX()-d.P[0].getX();
        ABy=d.P[1].getY()-d.P[0].getY();

        //if(t<0) t=0;
        //if(t>1) t=1;
        //System.out.println("t="+t);

        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }
}

