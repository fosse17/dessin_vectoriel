package com.geo_graphe;

import java.awt.*;

/**
 * Classe de création d'un segment.
 */
public class Segment extends Forme2D implements forme {

    /**
     * La couleur est bleu lorsque l'on passe dessus.
     */
    Color over=Color.BLUE ;
    /**
     * La couleur lorsque l'on n'est pas dessus.
     */
    Color nover=couleur;

    /**
     * Instancie un nouveau segment.
     *
     * @param A the a
     * @param B the b
     * @param id the id
     */
    public Segment(Pt A, Pt B,int id)
    {
        super(A,B,id);
    }

    /**
     * On associe le segment à un id
     * @param i l'id
     */
    public void set_id(int i) {
        super.id=i;
    }

    /**
     * On retourne l'id du segment
     * @return id
     */
    public int get_id() {
        return super.id;
    }

    /**
     * On met à jour la position du segment id aux coordonnées (x,y)
     * @param x the x
     * @param y the y
     * @param id the id
     */
    public void update(int x, int y, int id) {
        if(id==P[0].get_id()) P[0].set_coord(x,y);
        if(id==P[1].get_id()) P[1].set_coord(x, y);
    }

    /**
     * On définit la couleur du segment
     * @param c la couleur à définir
     */
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    /**
     * On retourne la couleur actuelle du segment
     * @return couleur
     */
    public Color get_couleur() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @return true si movable, faux sinon
     */
    public boolean is_movable() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param c vrai si deplacable, faux sinon
     */
    public void set_movable(Boolean c) {
    }

    /**
     * On dessine le segment dans le canvas
     * @param g
     */
    public void draw(Graphics g) {
        Color a=g.getColor();
        g.setColor(couleur);
        P[0].draw(g);
        P[1].draw(g);
        g.drawLine(P[0].getX(),P[0].getY(), P[1].getX(),P[1].getY());
        g.setColor(a);

    }

    /**
     *
     * @param visible the visible
     */
    public void setVisible(Boolean visible) {
        super.setVisible(visible);

    }

    /**
     * Si la souris est proche du segment, on change la couleur
     *
     * @param a the a
     * @param b the b
     * @return true si proche, faux sinon.
     */
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
