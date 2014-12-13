package com.geo_graphe;


import java.awt.*;

public interface forme {

    public void set_id(int i);
    public int get_id();

    public void update(int x,int y,int id);

    public void set_couleur(Color c);
    public Color get_couleur();

    public boolean is_movable();
    public void set_movable(Boolean c);

	public void draw(Graphics g);
	public boolean isVisible();
	public void setVisible(Boolean visible);

}
