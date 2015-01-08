package com.geo_graphe;

/**
 * Created with IntelliJ IDEA.
 * User: Stephane
 * Date: 08/12/14
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class PtDroite extends Pt{
    Droite d;
    int ABx,ABy;
    double t,dx,dy;

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

    public void updatepos(int a,int b)
    {
        dx=(double)(a-d.P[0].getX());

        dy=(double)(b-d.P[0].getY());
        //System.out.println("dx.... :"+(dx*dx+dy*dy));
        t = (dx * dx + dy * dy) / (double)(ABx * ABx + ABy * ABy);
        t=Math.sqrt(t);
        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }

    public void update(int a,int b,int id)
    {
        ABx=d.P[1].getX()-d.P[0].getX();
        ABy=d.P[1].getY()-d.P[0].getY();

        this.set_coord((int)(d.P[0].getX()+t*ABx),(int)(d.P[0].getY()+t*ABy));
    }
}
