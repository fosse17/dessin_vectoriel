package com.geo_graphe;

import java.awt.*;

/**
 * Classe pour créer un triangle
 */
public class Triangle extends Forme2D implements forme{

    /**
     * Couleur du triangle
     */
    Color couleur=new Color(123,123,12,50);
    /**
     * The Visible.
     */
    boolean visible=true;
    /**
     * initialise le mode à point
     */
    private String mode="point";

    /**
     * Instancie un nouveau triangle à partir de 3 points
     *
     * @param A the a
     * @param B the b
     * @param C the c
     * @param id the id
     */
    Triangle(Pt A,Pt B,Pt C,int id)
    {
        super(A,B,C,id);
    }

    /**
     * Instancie un nouveau triangle à partir d'un tableau de points
     *
     * @param pt the pt
     * @param id the id
     */
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

    /**
     *
     * @return
     */
    public String toString() {
        return "("+P[0].getX()+","+P[0].getY()+")"+"("+P[1].getX()+","+P[1].getY()+")"+"("+P[2].getX()+","+P[2].getY()+")";
    }

    /**
     * Update 1.
     *
     * @param x the x
     * @param y the y
     */
    public void update1(int x,int y)
    {
        P[1].set_coord(x,y);
        //P[2].set_coord(x,y);
    }

    /**
     * Update 2.
     *
     * @param x the x
     * @param y the y
     */
    public void update2(int x,int y)
    {
        P[2].set_coord(x,y);
    }

    /**
     *
     * @return retourne l'id du triangle
     */
    public int get_id() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *défini un id au triangle
     * @param i l'id à définir
     */
    public void set_id(int i) {

    }

    /**
     *
     * @param x the x
     * @param y the y
     * @param id the id
     */
    public void update(int x, int y, int id) {
        int pos=super.to_update(id);
        P[pos].set_coord(x,y);
    }

    /**
     *
     * @return la couleur actuelle de la figure
     */
    public Color get_couleur() {
        return this.couleur;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param c la couleur à définir
     */
    public void set_couleur(Color c) {
        couleur = new Color(c.getRed(), c.getGreen(), c.getBlue(), 50);
    }

    /**
     *
     * @return true si movable, false sinon.
     */
    public boolean is_movable() {
        return true;
    }

    /**
     *
     * @param c true si deplacable, false sinon
     */
    public void set_movable(Boolean c) {

    }

    /**
     * Dessine le triangle dans la canvas
     * @param g
     */
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

    /**
     *
     * @return rend le triangle visible
     */
    public boolean isVisible() {
        return true;
    }

    public void setVisible(Boolean visible) {
        visible=true;

    }
}
