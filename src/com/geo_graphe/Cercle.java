package com.geo_graphe;

import java.awt.*;


public class Cercle extends Forme2D implements forme{

    int rayon,dx,dy;
    boolean move=false;
    int id=0;
    //Color couleur=Color.DARK_GRAY;
    Color over=Color.BLUE;
    Color nover=couleur;

    public Cercle(Pt A, Pt B,int i)
    {
        super(A,B,i);
        this.id=i;
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        System.out.println("vecteur  "+dx+" "+dy);
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    public void update_rayon(int a,int b)
    {
        super.update_end(a,b);
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }
    public void update_centre(int a,int b)
    {
        P[0].set_coord(a,b);
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
        //super.update_end(P[0].getX()+dx,P[0].getY()+dy);
        //rayon=(int) Math.sqrt((init.x-end.x)*(init.x-end.x)+(init.y-end.y)*(init.y-end.y));
    }


    public void update_zoom()
    {
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

     public boolean isNear(int x,int y)
     {
         if((this.P[0].distance(x, y) < (this.rayon + 5)) && (this.P[0].distance(x, y) > (this.rayon - 5))) {
             this.couleur=over; return true;
         }
         this.couleur=nover;return false;
     }


    @Override
    public void set_id(int i) {
        this.id=i;
    }

    @Override
    public int get_id() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(int x, int y, int id) {
        if(id==P[0].get_id()) this.update_centre(x,y);
        if(id==P[1].get_id()) this.update_rayon(x,y);
    }

    @Override
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    @Override
    public Color get_couleur() {
        return this.couleur;  //To change body of implemented methods use File | Settings | File Templates.
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
        try {
            g.drawOval(P[0].getX()-rayon,P[0].getY()-rayon,2*rayon,2*rayon);
        } catch (NullPointerException e) {
        }
        g.setColor(a);

    }

    @Override
    public void setVisible(Boolean visible) {
        super.setVisible(visible);

    }

}

