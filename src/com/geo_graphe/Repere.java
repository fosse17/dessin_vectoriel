package com.geo_graphe;

import java.awt.*;
import java.io.Serializable;


/**
 * La classe Repere pour créer le repere et la grille
 */
public class Repere implements forme, Serializable {
	/**
	 * Le point à l'origine
     */
	Pt origine;
	/**
	 * The E _ x.
     */
	int e_x, /**
	 * The E _ y.
	 */
	e_y, /**
	 * The H.
	 */
	h, /**
	 * The L.
	 */
	l;
	/**
	 * Savoir si on affiche la grille ou non
     */
	boolean showgrille=true;
	/**
	 * Visible ou non
     */
	boolean visible;
	/**
	 * L'id du point du repère est 0
     */
	int id=0;

	/**
	 * Instancie un nouveau repère
	 *
	 * @param d the d
	 * @param O the o
     */
	Repere(Dimension d, Pt O)
	{
		e_x=30;e_y=30;
		origine=O;
		this.l=d.width;this.h=d.height;
		visible=false;
	}

	/**
	 * Instancie un nouveau repère
	 *
	 * @param xmin the xmin
	 * @param xmax the xmax
	 * @param ymin the ymin
	 * @param ymax the ymax
	 * @param d the d
	 * @param origine the origine
     * @param i the i
     */
	Repere(int xmin, int xmax, int ymin, int ymax, Dimension d, Pt origine, int i)
	{
		l=d.width;h=d.height;
		e_x=d.width/(xmax-xmin);
		e_y=d.height/(ymax-ymin);
		this.origine = origine;
		this.origine.set_coord(-e_x * xmin, e_y * ymax);//a modifier
		//System.out.println(origine);
		visible=false;
        this.id=i;
	}


	/**
	 * retourne l'abscisse d'un point.
	 *
	 * @param a the a
	 * @return the
     */
	public double getabs(Point a)
	{
		double d= ((double)(a.x- origine.getX())/e_x);
		return Math.round(d*100.0)/100.0;
		
	}

	/**
	 * Retourne l'abscisse par rapport à un entier
	 *
	 * @param a the a
	 * @return the
     */
	public double getabs(int a)
    {
        double d= ((double)(a- origine.getX())/e_x);
        return Math.round(d*100.0)/100.0;

    }

	/**
	 * Retourne l'ordonnée d'un point
	 *
	 * @param a the a
	 * @return the
     */
	public double getord(Point a)
	{
		double d= ((double)(a.y-origine.y)/e_y);
		return Math.round(d*100.0)/100.0;
	}

	/**
	 * Retourne l'ordonnée par rapport à un entier.
	 *
	 * @param a the a
	 * @return the
     */
	public double getord(int a)
    {
        double d= ((double)(a-origine.y)/e_y);
        return Math.round(d*100.0)/100.0;}

	/**
	 * Convertit un point pour le faire correspondre au repère
	 *
	 * @param abs the abs
	 * @param ord the ord
	 * @return le nouveau point
     */
	public Pt convert(double abs,double ord)
	{
		int a=(int) (origine.getX() +abs*e_x);
		int b=(int) (origine.y-ord*e_y);
		return new Pt(a,b);
	}

    @Override
	public int get_id() {
		return this.id;
	}

    @Override
	public void set_id(int i) {
		this.id = i;// par defaut methode a modifier
	}

    @Override
    public void update(int x, int y, int id) {
		if (id == origine.get_id()) {
			this.origine.set_coord(x, y);
		}
	}

    @Override
	public Color get_couleur() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

    @Override
	public void set_couleur(Color c) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

    @Override
    public boolean is_movable() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_movable(Boolean c) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void draw(Graphics g){
		g.setColor(Color.red);
		g.drawLine(0, origine.y,l , origine.y);
		g.drawLine(origine.getX(),0 , origine.getX(),h);
		for(int i=1;i<=100;i++)
		{
			g.drawLine(origine.getX() -3,origine.y+e_y*i, origine.getX() +3, origine.y+e_y*i);
			g.drawLine(origine.getX() -3,origine.y-e_y*i, origine.getX() +3, origine.y-e_y*i);

			g.drawLine(origine.getX() +e_x*i,origine.y-3, origine.getX() +e_x*i, origine.y+3);
			g.drawLine(origine.getX() -e_x*i,origine.y-3, origine.getX() -e_x*i, origine.y+3);
		}
		if(this.showgrille)
		{
			Graphics2D g2d = (Graphics2D)g.create();
			float epaisseur=1; /** taille de la ligne */
			float[] style = {5,5};
			g2d.setColor(Color.lightGray);
			g2d.setStroke(new BasicStroke(
					epaisseur,
					BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_MITER,
					10.0f,
					style,
					0
					));
			for(int i=1;i<=100;i++)
			{
				g2d.drawLine(0,origine.y+e_y*i, l, origine.y+e_y*i);
				g2d.drawLine(0,origine.y-e_y*i, l, origine.y-e_y*i);

				g2d.drawLine(origine.getX() +e_x*i,0, origine.getX() +e_x*i,h);
				g2d.drawLine(origine.getX() -e_x*i,0, origine.getX() -e_x*i, h);
			}
			
		}
		//g.setColor(Color.red);
		
		/*test 
		 * for (double i=-5;i<=10;i=i+0.01)
		{
		Point p=convert(i,10*Math.cos(i));
		g.fillOval(p.x-1,p.y-1,3,3);
		}*/
	}

	/**
	 * Gets origine.
	 *
	 * @return the origine
     */
	public Pt getOrigine() {
		return origine;
	}

	/**
	 * Sets origine.
	 *
	 * @param origine the origine
     */
	public void setOrigine(Pt origine) {
		this.origine = origine;
	}

	/**
	 * Gets e _ x.
	 *
	 * @return the e _ x
     */
	public int getE_x() {
		return e_x;
	}

	/**
	 * Sets e _ x.
	 *
	 * @param e_x the e _ x
     */
	public void setE_x(int e_x) {
		this.e_x = e_x;
	}

	/**
	 * Gets e _ y.
	 *
	 * @return the e _ y
     */
	public int getE_y() {
		return e_y;
	}

	/**
	 * Sets e _ y.
	 *
	 * @param e_y the e _ y
     */
	public void setE_y(int e_y) {
		this.e_y = e_y;
	}

	/**
	 * Sets _ dimension.
	 *
	 * @param d the d
     */
	public void set_dimension(Dimension d)
	{
		this.l=d.width;this.h=d.height;
	}
	

	@Override
	public boolean isVisible() {
		return visible;
	}
	@Override
	public void setVisible(Boolean visible) {
		this.visible=visible;
	}
	}


