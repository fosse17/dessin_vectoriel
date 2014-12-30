package com.geo_graphe;

import java.awt.*;
import java.io.Serializable;


/**
 * The type Forme 2 d.
 */
public abstract class Forme2D implements Serializable {

    /**
     * The Id.
     */
    public int id;
    /**
     * The Couleur.
     */
    protected Color couleur =Color.BLACK;
    /**
     * The Visible.
     */
    protected boolean visible=true;
    /**
     * The Num _ point.
     */
    protected int num_point;
    /**
     * The P.
     */
    protected Pt P[];

    /**
     * Instantiates a new Forme 2 d.
     *
     * @param A the a
     * @param B the b
     * @param id the id
     */
    Forme2D(Pt A, Pt B,int id)
    {
        this.num_point=2;
        P=new Pt[2];
        this.P[0]=A;
        this.P[1]=B;
        this.id=id;
    }

    /**
     * Instantiates a new Forme 2 d.
     *
     * @param A the a
     * @param B the b
     * @param C the c
     * @param id the id
     */
    Forme2D(Pt A, Pt B,Pt C,int id)
    {
        this.num_point=3;
        P=new Pt[3];
        this.P[0]=A;
        this.P[1]=B;
        this.P[2]=C;
        this.id=id;
    }

    /**
     * Instantiates a new Forme 2 d.
     *
     * @param pts the pts
     * @param n the n
     * @param id the id
     */
    Forme2D(Pt[] pts,int n,int id)
    {
        this.num_point=n;
        P=new Pt[n];
        for (int i=0;i<this.num_point;i++)
        {
            this.P[i]=pts[i];
        }
        this.id=id;
    }

    /**
     * To _ update.
     *
     * @param num the num
     * @return the int
     */
//retourne la position a update dans le tableau de points
    public int to_update(int num)
    {
        for(int a=0;a<num_point;a++)
        {
            if (P[a].id==num) return a;
        }
        return -1;
    }

    /**
     * Is visible.
     *
     * @return the boolean
     */
    public boolean isVisible() {
        return visible;
    }


    /**
     * Sets visible.
     *
     * @param visible the visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Update _ end.
     *
     * @param x the x
     * @param y the y
     */
    protected void update_end(int x,int y)
    {
        this.P[1].set_coord(x,y);
    }

    /**
     * Sets couleur.
     *
     * @param couleur the couleur
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }



}
