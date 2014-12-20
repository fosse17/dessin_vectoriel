package com.geo_graphe;

import java.awt.*;

public class Segment extends Forme2D implements forme {

    Color over=Color.BLUE ;
    Color nover=couleur;

    public Segment(Pt A, Pt B,int id)
    {
        super(A,B,id);
    }

    @Override
    public void set_id(int i) {
        super.id=i;
    }

    @Override
    public int get_id() {
        return super.id;
    }

    @Override
    public void update(int x, int y, int id) {
        if(id==P[0].get_id()) P[0].set_coord(x,y);
        if(id==P[1].get_id()) P[1].set_coord(x, y);
    }

    @Override
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    @Override
    public Color get_couleur() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean is_movable() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_movable(Boolean c) {
    }

    @Override
    public void draw(Graphics g) {
        Color a=g.getColor();
        g.setColor(couleur);
        P[0].draw(g);
        P[1].draw(g);
        g.drawLine(P[0].getX(),P[0].getY(), P[1].getX(),P[1].getY());
        g.setColor(a);

    }

    @Override
    public void setVisible(Boolean visible) {
        super.setVisible(visible);

    }

    public boolean isNear(int a,int b)
    {
        int ABx=P[1].getX()-P[0].getX();
        int ABy=(P[1].getY()-P[0].getY());
        int c=ABy*P[0].getX()-ABx*P[0].getY();
        double dist=Math.abs(-ABy*a+ABx*b+c) / Math.sqrt(ABx*ABx+ABy*ABy);
        //System.out.println("distance : "+dist);
        if(dist<5 && a>Math.min(P[0].getX(),P[1].getX()) && a<Math.max(P[0].getX(),P[1].getX())) {couleur=over;return true;} else {  couleur=nover;return false;}
    }


}
