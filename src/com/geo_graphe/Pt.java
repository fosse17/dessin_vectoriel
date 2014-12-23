package com.geo_graphe;

import java.awt.*;
import java.io.Serializable;


public class Pt implements forme, Serializable {

    protected Color c=Color.BLACK;
    protected Color cover=Color.red;
    protected int y;
    protected int taille=7;
    protected boolean over=false;
    protected boolean visible=true;
    protected boolean movable=true;
    protected int id=-1;
    private int x;



    /**
     * Constructeur
     * @param a int : abscisse du point
     * @param b int : ordonné du point
     */
    Pt(int a, int b)
    {
        this.x=a;
        this.y=b;
        this.id= -1;
    }

    Pt(Pt A)
    {
        this.x=A.x;
        this.y=A.y;
        this.id=A.get_id();
    }
    Pt(Pt A,int i)
    {
        this.x=A.x;
        this.y=A.y;
        this.id=i;
    }
    public Pt(int a, int b,int i)
    {
        this.x=a;
        this.y=b;
        this.id=i;
    }

    /* ********************************************************
      Getter and setter
     *********************************************************/
    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public void set_coord(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}

    @Override
    public int get_id() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_id(int i) {
        this.id = i;
    }

    @Override
    public void update(int x, int y, int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Color get_couleur() {
        return this.c;
    }

    @Override
    public void set_couleur(Color c) {
        this.c = c;
    }

    @Override
    public boolean is_movable() {
        return this.movable;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_movable(Boolean c) {
        this.movable=c;
    }


    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }


    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(Boolean visible) {
        this.visible=visible;

    }
    //////
    //////     tracer
    //////
    public void draw(Graphics g)
    {

        Color cl=g.getColor();
        if(!movable)g.setColor(cover);else g.setColor(c);
        //g.drawString(Integer.toString(this.id),x,y);
        g.fillOval(x- (taille-1)/2, y- (taille-1)/2, taille, taille);
        g.setColor(cl);
    }

     //**********************
    //utilitaire
    //***********************

    public boolean isNear(int X, int Y)
    {
        return this.distance(x, y, X, Y) < 10 && this.is_movable();
    }

    public double distance(int x1, int y1, int x2, int y2)
    {
        return(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
    }

    public double distance(int x,int y)
    {
        return distance(this.x,this.y,x,y);
    }



}
