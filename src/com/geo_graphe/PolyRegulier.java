package com.geo_graphe;

import java.awt.*;

/**
 * Classe de création de polynome régulier.
 */
public class PolyRegulier extends Forme2D implements forme {

    /**
     * id du polygone
     */
    int id,
    /**
     * nombre de coté du polygone.
     */
    nbcote,
    /**
     * le rayon
     */
    rayon,
    /**
     * The Dx.
     */
    dx,
    /**
     * The Dy.
     */
    dy;
    /**
     * Le polygone P
     */
    Polygon p;
    /**
     * L'angle
     */
    double angle;
    /**
     * La couleur de base du polygone régulier
     */
    Color couleur = new Color(123, 123, 12, 50);
    /**
     * Transparence du polygone
     */
    int tranparence = 50;
    /**
     * Transparence du polygone lorsque l'on passe par dessus.
     */
    int tranparence_over = 70;


    /**
     * Instancie un nouveau polygone régulier
     *
     * @param A the a
     * @param B the b
     * @param nbcote the nbcote
     * @param id the id
     */
    public PolyRegulier(Pt A,Pt B,int nbcote,int id)
    {
        super(A, B, id);
        this.id=id;
        this.nbcote=nbcote;
        this.rayon=(int)A.distance(B.getX(),B.getY());
        dx = B.getX() - A.getX();
        dy=B.getY() - A.getY();
        angle = Math.atan2(dy, dx);
        p = new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.P[0].getX() + this.rayon * Math.cos(angle + i * 2 * Math.PI / this.nbcote)),
                    (int) (this.P[0].getY() + this.rayon * Math.sin(angle + i * 2 * Math.PI / this.nbcote)));
    }

    /**
     * Si on passe la souris dans le polygone, alors le fond change de couleur, sinon elle reprend sa couleur d'origine.
     *
     * @param x the x
     * @param y the y
     * @return vrai si dedans, faux sinon.
     */
    public boolean isNear(int x, int y) {
        if (p.contains(x, y)) {
            couleur = new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), this.tranparence_over);
            return true;
        } else {
            couleur = new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), this.tranparence);
            return false;
        }
    }

    /**
     *
     * @return id du polygone
     */
    public int get_id() {
        return this.id;
    }

    /**
     * défini un id au polygone.
     * @param i l'id à définir
     */
    public void set_id(int i) {

    }

    /**
     * Modifie la position du polygone régulier.
     * @param x the x
     * @param y the y
     * @param id the id
     */
        public void update(int x, int y, int id) {
        if (id == P[1].get_id()) {
            P[1].set_coord(x, y);
            this.rayon = (int) P[0].distance(P[1].getX(), P[1].getY());
            dx = P[1].getX() - P[0].getX();
            dy = P[1].getY() - P[0].getY();
           angle = Math.atan2(dy, dx);
       }
        if (id == P[0].get_id()) {
            P[0].set_coord(x, y);
            this.rayon = (int) P[0].distance(P[1].getX(), P[1].getY());
            dx = P[1].getX() - P[0].getX();
            dy = P[1].getY() - P[0].getY();
            angle = Math.atan2(dy, dx);
        }
        p = new Polygon();
        for (int i = 0; i < this.nbcote; i++)
            p.addPoint((int)
                            (this.P[0].getX() + this.rayon * Math.cos(angle + i * 2 * Math.PI / this.nbcote)),
                    (int) (this.P[0].getY() + this.rayon * Math.sin(angle + i * 2 * Math.PI / this.nbcote)));

    }

    /**
     *
     * @return la couleur du polygone régulier
     */
    public Color get_couleur() {
        return this.couleur;
    }

    /**
     *
     * @param c la couleur à définir
     */
    public void set_couleur(Color c) {
        this.couleur = new Color(c.getRed(), c.getGreen(), c.getBlue(), this.tranparence);
    }

    /**
     *
     * @return true si deplacable, false sinon.
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
     * Dessine le polygone régulier dans la canvas.
     * @param g
     */
    public void draw(Graphics g) {

        Color c = g.getColor();

        g.setColor(new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue()));
        g.drawPolygon(p);

        g.setColor(couleur);
        g.fillPolygon(p);

        g.setColor(c);
    }


    /**
     *
     * @return true si visible, false sinon.
     */
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setVisible(Boolean visible) {

    }
}