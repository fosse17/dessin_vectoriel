package com.geo_graphe;

/**
 * Created with IntelliJ IDEA.
 * User: Stephane
 * Date: 07/12/14
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 */
public class PtCercle extends Pt implements forme {
    Pt A;
    Cercle cercle;
    private double cosa,sina;


    PtCercle(Cercle C,int x,int y,int id)
    {
        super(x,y,id);
        cercle=C;
        this.set_coord((int)(cercle.P[0].getX()-cercle.rayon*this.cosangle(x,y)),(int) (cercle.rayon * this.sinangle(x,y) + cercle.P[0].getY()));
        sina=this.sinangle(x,y);
        cosa=this.cosangle(x,y);
    }

    private double cosangle(int x,int y)
    {
        return (cercle.P[0].getX()-x)/(cercle.P[0].distance(x,y));
    }

    private double sinangle(int x,int y)
    {
        return -(cercle.P[0].getY()-y)/(cercle.P[0].distance(x,y));
    }

    public void updatepos(int x,int y)
    {
        cosa=this.cosangle(x,y);
        sina=this.sinangle(x,y);
        this.set_coord((int)(cercle.P[0].getX()-cercle.rayon*this.cosangle(x,y)),(int) (cercle.rayon * this.sinangle(x,y) + cercle.P[0].getY()));
    }

    public void update(int x,int y,int id)
    {

       // this.cercle.update(x,y,id);
        this.set_coord((int)(cercle.P[0].getX()-cercle.rayon*cosa),(int) (cercle.rayon * sina) + cercle.P[0].getY());
    }



}
