package com.geo_graphe;

import java.awt.*;
import java.io.Serializable;


/**
 * La classe permettant de créer un point dans la zone de Dessin.
 */
public class Pt implements forme, Serializable {

    /**
     * La couleur du point
     */
    protected Color c=Color.BLACK;
    /**
     * Couleur d'un point non-modifiable
     */
    protected Color cover=Color.red;
    /**
     * un entier y
     */
    protected int y;
    /**
     * La taille du point
     */
    protected int taille=7;
    /**
     * The Over.
     */
    protected boolean over=false;
    /**
     * On initialise le point à visible
     */
    protected boolean visible=true;
    /**
     * On initialise le point à deplacable
     */
    protected boolean movable=true;
    /**
     * The Id.
     */
    protected int id=-1;
    private int x;


    /**
     * Constructeur de point
     * @param a int : abscisse du point
     * @param b int : ordonné du point
     */
    Pt(int a, int b)
    {
        this.x=a;
        this.y=b;
        this.id= -1;
    }

    /**
     * Instancie un nouveau point
     *
     * @param A the a
     */
    Pt(Pt A)
    {
        this.x=A.x;
        this.y=A.y;
        this.id=A.get_id();
    }

    /**
     * Instancie un nouveau point
     *
     * @param A the a
     * @param i the i
     */
    Pt(Pt A,int i)
    {
        this.x=A.x;
        this.y=A.y;
        this.id=i;
    }

    /**
     * Instancie un nouveau point
     *
     * @param a the a
     * @param b the b
     * @param i the i
     */
    public Pt(int a, int b,int i)
    {
        this.x=a;
        this.y=b;
        this.id=i;
    }

    /**
     * Is movable.
     *
     * @return the boolean
     */
/* ********************************************************
      Getter and setter
     *********************************************************/
    public boolean isMovable() {
        return movable;
    }

    /**
     * Sets movable.
     *
     * @param movable the movable
     */
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    /**
     * Sets _ coord.
     *
     * @param x the x
     * @param y the y
     */
    public void set_coord(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    /**
     * Get x.
     *
     * @return the int
     */
    public int getX(){return this.x;}

    /**
     * Get y.
     *
     * @return the int
     */
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


    /**
     * Gets c.
     *
     * @return the c
     */
    public Color getC() {
        return c;
    }

    /**
     * Sets c.
     *
     * @param c the c
     */
    public void setC(Color c) {
        this.c = c;
    }

    /**
     * Gets taille.
     *
     * @return the taille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Sets taille.
     *
     * @param taille the taille
     */
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
        //g.drawString(Integer.toString(this.id), x, y);
        g.fillOval(x- (taille-1)/2, y- (taille-1)/2, taille, taille);
        g.setColor(cl);
    }

     //**********************
    //utilitaire
    //***********************

    /**
     * Is near.
     *
     * @param X the x
     * @param Y the y
     * @return the boolean
     */
    public boolean isNear(int X, int Y)
    {
        return this.distance(x, y, X, Y) < 10 && this.isVisible();
    }

    /**
     * Distance double.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     * @return the double
     */
    public double distance(int x1, int y1, int x2, int y2)
    {
        return(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
    }

    /**
     * Distance double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public double distance(int x,int y)
    {
        return distance(this.x,this.y,x,y);
    }



}
