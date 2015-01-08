package com.geo_graphe;

import java.awt.*;


/**
 * Classe permettant d'écrire du texte dans la zone de dessin
 */
public class Texte implements forme{

    /**
     * The A.
     */
    Pt A;
    /**
     * The Id.
     */
    int id;
    private String text;
    private int fontSize;
    private Color col;

    /**
     * Instancie un nouveau texte
     *
     * @param t the t
     * @param A the a
     * @param id the id
     */
    public Texte(String t, Pt A, int id) {
        this.A = A;
        this.id = id;
        this.text = t;
        fontSize = 20;
        col = Color.black;
    }

    /**
     * Retourne la taille de la police
     *
     * @return the font size
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Initialise la taille du texte
     *
     * @param fontSize the font size
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Retourne la couleur
     *
     * @return the col
     */
    public Color getCol() {
        return col;
    }

    /**
     * Defini la couleur
     *
     * @param col the col
     */
    public void setCol(Color col) {
        this.col = col;
    }

    public void draw(Graphics g)
    {
        //super.draw(g);
        Color anc=g.getColor();
        g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));

        g.setColor(col);
        g.drawString(text, this.A.getX() + 7, this.A.getY());
        g.setColor(anc);
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setVisible(Boolean visible) {

    }

    @Override
    public int get_id() {
        return this.id;
    }

    @Override
    public void set_id(int i) {

    }

    public void update(int x,int y,int id)
    {
        if(id==this.A.get_id())
        {
            this.A.set_coord(x, y);
        }
    }

    @Override
    public Color get_couleur() {
        return null;
    }

    @Override
    public void set_couleur(Color c) {

    }

    @Override
    public boolean is_movable() {
        return true;
    }

    @Override
    public void set_movable(Boolean c) {

    }
}
