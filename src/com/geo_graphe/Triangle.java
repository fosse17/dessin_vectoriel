package com.geo_graphe;

import java.awt.*;

public class Triangle extends Forme2D implements forme{

    Color couleur=new Color(123,123,12,50);
    boolean visible=true;
    private String mode="point";

    Triangle(Pt A,Pt B,Pt C,int id)
    {
        super(A,B,C,id);
    }

    Triangle(Pt[] pt,int id)
    {
        super(pt,3,id);
    }

    /*Triangle(Droite d1,Droite d2, Droite d3,int id)
    {
        super(new PtInterDroite(d1,d2,-1),new PtInterDroite(d2,d3,-1),new PtInterDroite(d1,d3,-1),id);
        System.out.println(this.toString());
        this.mode="droite";

    }*/

    @Override
    public String toString() {
        return "("+P[0].getX()+","+P[0].getY()+")"+"("+P[1].getX()+","+P[1].getY()+")"+"("+P[2].getX()+","+P[2].getY()+")";
    }

    public void update1(int x,int y)
    {
        P[1].set_coord(x,y);
        //P[2].set_coord(x,y);
    }
    public void update2(int x,int y)
    {
        P[2].set_coord(x,y);
    }

    @Override
    public void set_id(int i) {

    }

    @Override
    public int get_id() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(int x, int y, int id) {
        int pos=super.to_update(id);
        P[pos].set_coord(x,y);
    }

    @Override
    public void set_couleur(Color c) {
        couleur=new Color(c.getRed(),c.getGreen(),c.getBlue(),50);
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
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void draw(Graphics g) {
        Color a=g.getColor();
        g.setColor(couleur);
        if(this.mode.equals("point")) {
            P[0].draw(g);
            P[1].draw(g);
            P[2].draw(g);
        }
        int[] tabx=new int[3];tabx[0]=P[0].getX(); tabx[1]=P[1].getX();tabx[2]=P[2].getX();
        int[] taby=new int[3];taby[0]=P[0].getY(); taby[1]=P[1].getY();taby[2]=P[2].getY();
        g.drawPolygon(tabx,taby,3);
        g.fillPolygon(tabx,taby,3);
        g.setColor(a);

    }

    @Override
    public boolean isVisible() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setVisible(Boolean visible) {
        visible=true;

    }
}
