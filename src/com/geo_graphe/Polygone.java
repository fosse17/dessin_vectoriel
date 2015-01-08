package com.geo_graphe;

import java.awt.*;


/**
 * Classe permettant de créer un polygone.
 */
public class Polygone extends Forme2D implements forme {

    /**
     * Un polygone P
     */
    Polygon p;
    /**
     * Le Nombre de points du polygone
     */
    int num_pts;
    /**
     * Couleur du polygone
     */
    Color couleur = new Color(123, 123, 12, 50);
    /**
     * The Tranparence.
     */
    int tranparence = 50;
    /**
     * The Tranparence _ over.
     */
    int tranparence_over = 70;
    /**
     * Deformable ou non
     */
    boolean deformable;

    /**
     * Instancie un nouveau Polygone
     *
     * @param pts the pts
     * @param n the n
     * @param id the id
     */
    Polygone(Pt[] pts, int n, int id) {
        super(pts, n, id);
        this.num_pts = n;
        this.deformable = true;
    }

    /**.
     *
     * @return true si deformable, false sinon.
     */
    public boolean get_deformable() {
        return this.deformable;
    }

    /**
     * Defini si un polygone est deformable ou non.
     *
     * @param def true si deformable, faux sinon.
     */
    public void set_deformable(boolean def) {
        this.deformable = def;
    }

    /**
     * Defini si on est proche d'un polygone ou non
     *
     * @param x the x
     * @param y the y
     * @return the boolean
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
     * Rajoute un point au polygone
     *
     * @param A the a
     */
    public void add(Pt A) {

        this.P[num_pts] = A;
        this.num_pts++;
    }

    /**
     * On enleve un point.
     */
    public void minus() {
        this.num_pts--;
    }

    /**
     * On modifie les coordonnées du dernier point.
     *
     * @param x the x
     * @param y the y
     */
    public void updatelast(int x, int y) {
        this.P[num_pts - 1].set_coord(x, y);

    }

    @Override
    public int get_id() {
        return this.id;
    }

    @Override
    public void set_id(int i) {
        this.id = i;
    }

    @Override
    public void update(int x, int y, int id) {

        for (int i = 0; i < this.num_pts; i++) {
            if (P[i].get_id() == id) P[i].set_coord(x, y);
        }

    }

    @Override
    public Color get_couleur() {
        return this.couleur;
    }

    @Override
    public void set_couleur(Color c) {
        this.couleur = new Color(c.getRed(), c.getGreen(), c.getBlue(), this.tranparence);
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
        Color c = g.getColor();
        p = new Polygon();
        for (int i = 0; i < this.num_pts; i++) {
            p.addPoint(P[i].getX(), P[i].getY());
        }
        g.setColor(new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue()));
        g.drawPolygon(p);

        g.setColor(couleur);
        g.fillPolygon(p);

        g.setColor(c);
    }

    @Override
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
