package com.geo_graphe;

import java.awt.*;

public class Droite extends Forme2D implements forme {
    private Color over=Color.BLUE;
    private Color nover=couleur;

    Droite(Pt A, Pt B,int id)
    {
        super(A,B,id);
    }

    public void updade_end(int x,int y)
    {
        super.update_end(x,y);
    }

    public boolean isNear(int a,int b)
    {
        int ABx=P[1].getX()-P[0].getX();
        int ABy=(P[1].getY()-P[0].getY());
        int c=ABy*P[0].getX()-ABx*P[0].getY();
        double dist=Math.abs(-ABy*a+ABx*b+c) / Math.sqrt(ABx*ABx+ABy*ABy);
        if(dist<5) {couleur=over;return true;} else {  couleur=nover;return false;}
    }

    /**
     * retourne les coef a,b,c de la droite d'équation ax+by+c=0;
     * @return   le tableau d'entiers
     */
    public int[] coeff()
    {
        int[] t=new int[3];
        t[0]=-(P[1].getY()-P[0].getY());       // -ABy
        t[1]=P[1].getX()-P[0].getX();          //  ABx
        t[2]=-t[0]*P[0].getX()-t[1]*P[0].getY();
        return t;
    }

    public boolean paralelle(Droite d)
    {
        int[] t=new int[3];
        int[] t1=new int[3];
        t=this.coeff();
        t1=d.coeff();
        if(((t[0] * t1[1]) - (t[1] * t1[0])) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int get_id() {
        return super.id;
    }

    @Override
    public void set_id(int i) {
        super.id = i;
    }

    @Override
    public void update(int x, int y, int id) {
        if(id==P[0].get_id()) P[0].set_coord(x,y);
        if(id==P[1].get_id()) P[1].set_coord(x,y);
    }

    @Override
    public Color get_couleur() {
        return super.couleur;
    }

    @Override
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    @Override
    public boolean is_movable() {
        return true;
    }

    @Override
    public void set_movable(Boolean c) {

    }

    @Override
    public void draw(Graphics g) {
        int m = 1000;
        int vectx=(P[1].getX()-P[0].getX())*m;
        Color a=g.getColor();
        int vecty=(P[1].getY()-P[0].getY())*m;
        g.setColor(couleur);
        if(P[0].isVisible()) P[0].draw(g);
        if(P[1].isVisible()) P[1].draw(g);
        g.drawLine(P[0].getX(),P[0].getY(), P[1].getX()+vectx,P[1].getY()+vecty);
        g.drawLine(P[0].getX(),P[0].getY(), P[0].getX()-vectx,P[0].getY()-vecty);
        g.setColor(a);

    }

    @Override
    public void setVisible(Boolean visible) {
        super.setVisible(visible);

    }


}
