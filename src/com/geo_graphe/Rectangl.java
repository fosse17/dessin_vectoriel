package com.geo_graphe;

import java.awt.*;

public class Rectangl extends Forme2D implements forme {

	
	Rectangl(Pt A, Pt B,int id)
	{
		super(A,B,id);
	}

    public void updade_end(int x,int y)
    {
        super.update_end(x,y);
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
        if(id==P[0].get_id()) P[0].set_coord(x,y);
        if(id==P[1].get_id()) P[1].set_coord(x, y);
    }

    @Override
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    @Override
    public Color get_couleur() {
        return super.couleur;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean is_movable() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_movable(Boolean c) {
        //pas impleùenter pour une droite
    }

    @Override
	public void draw(Graphics g) {
		Color a=g.getColor();
		g.setColor(couleur);
		P[0].draw(g);
		P[1].draw(g);
		g.drawLine(P[0].getX(),P[0].getY(), P[0].getX(),P[1].getY());
        g.drawLine(P[1].getX(),P[1].getY(), P[1].getX(),P[0].getY());
        g.drawLine(P[0].getX(),P[0].getY(), P[1].getX(),P[0].getY());
        g.drawLine(P[0].getX(),P[1].getY(), P[1].getX(),P[1].getY());
		g.setColor(a);
		
	}

	@Override
	public void setVisible(Boolean visible) {
		super.setVisible(visible);
		
	}


}
