package com.geo_graphe;

import java.awt.*;


public class Texte implements forme{

    Pt A;
    int id;
    private String text;
    private int fontSize;
    private Color col;

    public Texte(String t, Pt A, int id) {
        this.A = A;
        this.id = id;
        this.text = t;
        fontSize = 20;
        col = Color.black;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Color getCol() {
        return col;
    }

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
