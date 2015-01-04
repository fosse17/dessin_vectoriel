package com.geo_graphe;

import java.awt.*;
import java.io.Serializable;


/**
 * La classe Forme2D
 */
public abstract class Forme2D implements Serializable {

    /**
     *id de la forme
     */
    public int id;
    /**
     * Couleur de la forme
     */
    protected Color couleur =Color.BLACK;
    /**
     * On initialise la variable visible à true
     */
    protected boolean visible=true;
    /**
     * variable entier num_point
     */
    protected int num_point;
    /**
     * Un tableau de points P
     */
    protected Pt P[];

    /**
     * Instancie une nouvelle forme Forme2D à partir de deux tableaux de points.
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
     * Instancie une nouvelle forme Forme2D à partir de trois tableaux de points.
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
     * Instancie une nouvelle forme Forme2D à partir d'un tableau de points et d'un nombre n de points
     *
     * @param pts le tableau de points
     * @param n le nombre de points
     * @param id id de la forme à créer
     */
    Forme2D(Pt[] pts,int n,int id)
    {
        this.num_point=n;
        P = new Pt[pts.length];
        for (int i=0;i<this.num_point;i++)
        {
            this.P[i]=pts[i];
        }
        this.id=id;
    }

    /**
     * Retourne la position à modifier dans le tableau de points
     *
     * @param num the num
     * @return the int
     */
//retourne la position a update dans le tableau de points
    public int to_update(int num)
    {
        for (int a = 0; a < this.num_point; a++)
        {
            if (P[a].id == num && num != -1) return a;
        }
        return -1;
    }

    /**
     *
     *
     * @return true si visible, false sinon.
     */
    public boolean isVisible() {
        return visible;
    }


    /**
     * Défini si le triangle est visible ou non.
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
     * Défini la couleur du triangle.
     *
     * @param couleur the couleur
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }



}
