package com.geo_graphe;


import java.awt.*;

/**
 * L'interface forme qui est utilisé pour la création de toutes les formes géométriques
 */
public interface forme {

    /**
     * Donne un id à la forme pour pouvoir l'identifier
     *
     * @param i l'id
     */
    public void set_id(int i);

    /**
     * Retourne l'id de la forme
     *
     * @return l'id
     */
    public int get_id();

    /**
     * Permet de modifier la position de la forme id aux coordonnées x et y
     *
     * @param x the x
     * @param y the y
     * @param id the id
     */
    public void update(int x,int y,int id);

    /**
     * Défini la couleur de la forme avec c la couleur
     *
     * @param c la couleur à définir
     * */
    public void set_couleur(Color c);

    /**
     * Retourne la couleur de la forme.
     *
     * @return la couleur
     */
    public Color get_couleur();

    /**
     * Défini si la forme est deplacable ou non
     *
     * @return vrai si deplacable, faux sinon
     */
    public boolean is_movable();

    /**
     * Défini si un objet est deplacable ou non
     *
     * @param c vrai si deplacable, faux sinon
     */
    public void set_movable(Boolean c);

    /**
     * permet d'afficher la forme dans le canvas
     *
     * @param g
     */
    public void draw(Graphics g);

    /**
     * Is visible.
     *
     * @return the boolean
     */
    public boolean isVisible();

    /**
     * Rend visible ou non la figure
     *
     * @param visible the visible
     */
    public void setVisible(Boolean visible);

}
