package com.geo_graphe;

import java.awt.*;


/**
 * The type Cercle.
 */
public class Cercle extends Forme2D implements forme{

    /**
     * The Rayon.
     */
    int rayon, /**
     * The Dx.
     */
    dx, /**
     * The Dy.
     */
    dy;
    /**
     * The Move.
     */
    boolean move=false;
    /**
     * The Id.
     */
    int id=0;
    /**
     * The Over.
     */
//Color couleur=Color.DARK_GRAY;
    Color over=Color.BLUE;
    /**
     * The Nover.
     */
    Color nover=couleur;

    /**
     * Instantiates a new Cercle.
     *
     * @param A the a
     * @param B the b
     * @param i the i
     */
    public Cercle(Pt A, Pt B,int i)
    {
        super(A,B,i);
        this.id=i;
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        System.out.println("vecteur  "+dx+" "+dy);
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    /**
     * Update _ rayon.
     *
     * @param a the a
     * @param b the b
     */
    protected void update_rayon(int a, int b)
    {
        super.update_end(a,b);
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    /**
     * Update _ centre.
     *
     * @param a the a
     * @param b the b
     */
    protected void update_centre(int a, int b)
    {
        P[0].set_coord(a,b);
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
        //super.update_end(P[0].getX()+dx,P[0].getY()+dy);
        //rayon=(int) Math.sqrt((init.x-end.x)*(init.x-end.x)+(init.y-end.y)*(init.y-end.y));
    }


    /**
     * Update _ zoom.
     */
    public void update_zoom()
    {
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    /**
     * Is near.
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean isNear(int x,int y)
     {
         if((this.P[0].distance(x, y) < (this.rayon + 5)) && (this.P[0].distance(x, y) > (this.rayon - 5))) {
             this.couleur=over; return true;
         }
         this.couleur=nover;return false;
     }

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
        if(id==P[0].get_id()) this.update_centre(x,y);
        if(id==P[1].get_id()) this.update_rayon(x,y);
    }

    @Override
    public Color get_couleur() {
        return this.couleur;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    @Override
    public boolean is_movable() {
        return move;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_movable(Boolean c) {
        this.move=c;
    }

    @Override
    public void draw(Graphics g) {
        Color a=g.getColor();
        g.setColor(couleur);
        g.drawOval(P[0].getX()-rayon,P[0].getY()-rayon,2*rayon,2*rayon);
        g.setColor(a);

    }

    @Override
    public void setVisible(Boolean visible) {
        super.setVisible(visible);

    }

}

