package com.geo_graphe;

/**
 * Création d'un point sur une droite
 */
public class PtDroite extends Pt{
    /**
     *Une droite d
     */
    Droite d;
    /**
     * The A bx.
     */
    int ABx, /**
     * The A by.
     */
    ABy;
    /**
     * The T.
     */
    double t, /**
     * The Dx.
     */
    dx, /**
     * The Dy.
     */
    dy;

    /**
     * Instancie un nouveau point sur une droite
     *
     * @param d1 the d 1
     * @param a the a
     * @param b the b
     * @param i the i
     */
    PtDroite(Droite d1,int a, int b, int i) {
        super(a, b, i);
        this.d=d1;
        ABx=d.P[1].getX()-d.P[0].getX();
        ABy=d.P[1].getY()-d.P[0].getY();
        dx=(double)(this.getX()-d.P[0].getX());

        dy=(double)(this.getY()-d.P[0].getY());
        //System.out.println("dx.... :"+(dx*dx+dy*dy));
        t = (dx * dx + dy * dy) / (double)(ABx * ABx + ABy * ABy);
        t=Math.sqrt(t);
        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }

    /**
     * Modifie la position du point courant sur la droite
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
        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }

    /**
     * Modifie la position d'un point sur la droite
     * @param a
     * @param b
     * @param id
     */
    public void update(int a,int b,int id)
    {
        ABx=d.P[1].getX()-d.P[0].getX();
        ABy=d.P[1].getY()-d.P[0].getY();

        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }
}
