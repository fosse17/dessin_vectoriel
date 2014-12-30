package com.geo_graphe;

/**
 * Classe permettant de créer le perpendiculaire d'une droite
 */
public class DroitePerp extends Droite {

    /**
     * Une droite D
     */
    Droite D;

    /**
     * Instancie une nouvelle droite parallèle d'une droite passant par un point
     *
     * @param D the d
     * @param A the a
     * @param B the b
     * @param id the id
     */
    DroitePerp(Droite D, Pt A,Pt B, int id) {
        super(A, B, id);
        this.D=D;
        int ABy=this.D.P[1].getX()-this.D.P[0].getX()+P[0].getY();
        int ABx=-(this.D.P[1].getY()-D.P[0].getY())+P[0].getX();
        P[1].set_coord(ABx,ABy);
        P[1].setVisible(false);
    }

    /**
     * Modifie la position de la droite
     * @param x
     * @param y
     * @param id: id de la droite
     */
    public void update(int x,int y,int id)
    {
          if(id==this.P[0].id  ){ this.P[0].set_coord(x, y);}
        if(id==this.P[1].id  ){ this.P[1].set_coord(x,y);}
              this.D.update(x, y, id);
              int ABy=D.P[1].getX()-D.P[0].getX()+P[0].getY();
              int ABx=-(D.P[1].getY()-D.P[0].getY())+P[0].getX();
              P[1].set_coord(ABx,ABy);

    }
}
