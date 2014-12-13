package com.geo_graphe;

import java.awt.*;
import java.io.Serializable;


public abstract class Forme2D implements Serializable {

    public int id;
    protected Color couleur =Color.BLACK;
    protected boolean visible=true;
    protected int num_point;
    protected Pt P[];

    Forme2D(Pt A, Pt B,int id)
    {
        this.num_point=2;
        P=new Pt[2];
        this.P[0]=A;
        this.P[1]=B;
        this.id=id;
    }

    Forme2D(Pt A, Pt B,Pt C,int id)
    {
        this.num_point=3;
        P=new Pt[3];
        this.P[0]=A;
        this.P[1]=B;
        this.P[2]=C;
        this.id=id;
    }

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

    //retourne la position a update dans la tableau de points
    public int to_update(int num)
    {
        for(int a=0;a<num_point;a++)
        {
            if (P[a].id==num) return a;
        }
        return -1;
    }

    public boolean isVisible() {
        return visible;
    }


    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    protected void update_end(int x,int y)
    {
        this.P[1].set_coord(x,y);
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }



}
