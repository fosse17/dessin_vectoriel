package com.geo_graphe;

import java.awt.*;

/**
 * Created by Stephane on 21/12/14.
 */
public class PolyRegulier implements forme {

    int id,nbcote,rayon,dx,dy;
    double angle;
    Pt O,B;


    public PolyRegulier(Pt A,Pt B,int nbcote,int id)
    {
         this.O=A;
        this.B=B;
        this.id=id;
        this.nbcote=nbcote;
        this.rayon=(int)A.distance(B.getX(),B.getY());
        dx = B.getX() - A.getX();
        dy=B.getY() - A.getY();
        angle = Math.atan2(dy, dx);
    }


    @Override
    public void set_id(int i) {

    }

    @Override
    public int get_id() {
        return this.id;
    }

    @Override
    public void update(int x, int y, int id) {
       if(id==B.get_id()) {
           B.set_coord(x, y);
           this.rayon = (int) O.distance(B.getX(), B.getY());
           dx = B.getX() - O.getX();
           dy = B.getY() - O.getY();
           angle = Math.atan2(dy, dx);
       }
        if(id==O.get_id()) {
            O.set_coord(x, y);
            this.rayon = (int) O.distance(B.getX(), B.getY());
            dx = B.getX() - O.getX();
            dy = B.getY() - O.getY();
            angle = Math.atan2(dy, dx);
        }

    }

    @Override
    public void set_couleur(Color c) {

    }

    @Override
    public Color get_couleur() {
        return null;
    }

    @Override
    public boolean is_movable() {
        return false;
    }

    @Override
    public void set_movable(Boolean c) {

    }

    @Override
    public void draw(Graphics g) {
        Polygon p=new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.O.getX() + this.rayon * Math.cos(angle+i * 2 * Math.PI / this.nbcote)),
                    (int) (this.O.getY() + this.rayon * Math.sin(angle+i * 2 * Math.PI /this.nbcote)));
        g.drawPolygon(p);
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setVisible(Boolean visible) {

    }
}
