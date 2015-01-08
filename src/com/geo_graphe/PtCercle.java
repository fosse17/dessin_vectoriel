package com.geo_graphe;


/**
 * Classe permettant de créer un point sur un cercle
 */
public class PtCercle extends Pt implements forme {
    /**
     * Le point A
     */
    Pt A;
    /**
     * Le cercle
     */
    Cercle cercle;
    private double cosa,sina;


    /**
     * Instancie un nouveau point sur Cercle
     *
     * @param C the c
     * @param x the x
     * @param y the y
     * @param id the id
     */
    PtCercle(Cercle C,int x,int y,int id)
    {
        super(x,y,id);
        cercle=C;
        this.set_coord((int)(cercle.P[0].getX()-cercle.rayon*this.cosangle(x,y)),(int) (cercle.rayon * this.sinangle(x,y) + cercle.P[0].getY()));
        sina=this.sinangle(x,y);
        cosa=this.cosangle(x,y);
    }

    /**
     *
     * @param x
     * @param y
     * @return le cosinus de l'angle du point et de l'axe des abscisses
     */
    private double cosangle(int x,int y)
    {
        return (cercle.P[0].getX()-x)/(cercle.P[0].distance(x,y));
    }

    /**
     *
     * @param x
     * @param y
     * @return le sinus de l'angle du point et de l'axe des ordonnées
     */
    private double sinangle(int x,int y)
    {
        return -(cercle.P[0].getY()-y)/(cercle.P[0].distance(x,y));
    }

    /**
     * On met à jour la position du point sur le cercle du cercle courant
     *
     * @param x the x
     * @param y the y
     */
    public void updatepos(int x,int y)
    {
        cosa=this.cosangle(x,y);
        sina=this.sinangle(x,y);
        this.set_coord((int)(cercle.P[0].getX()-cercle.rayon*this.cosangle(x,y)),(int) (cercle.rayon * this.sinangle(x,y) + cercle.P[0].getY()));
    }

    /**
     * On met à jour la position du point sur le cercle sans le calcul de cosa ou de sina
     * @param x the x
     * @param y the y
     * @param id the id
     */
    public void update(int x,int y,int id)
    {

       // this.cercle.update(x,y,id);
        this.set_coord((int)(cercle.P[0].getX()-cercle.rayon*cosa),(int) (cercle.rayon * sina) + cercle.P[0].getY());
    }



}
