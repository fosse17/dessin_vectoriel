package com.geo_graphe;


/**
 * La classe DroitePara permet de créer une droite qui est la parallèle d'une autre droite
 */
public class DroitePara extends Droite {
    /**
     * Une droite D
     */
    Droite D;
    //Pt A;

    /**
     * Instancie une nouvelle droite parallèle.
     *
     * @param D the d
     * @param A the a
     * @param B the b
     * @param id the id
     */
    DroitePara(Droite D, Pt A,Pt B, int id) {
        super(A, B, id);
        this.D=D;
        //this.A=A;
        int ABx=this.D.P[1].getX()-this.D.P[0].getX()+P[0].getX();
        int ABy=(this.D.P[1].getY()-D.P[0].getY())+P[0].getY();
        P[1].set_coord(ABx,ABy);
        P[1].setVisible(false);
    }

    /**
     * Modifie la position de la droite en la gardant parallèle
     * @param x
     * @param y
     * @param id
     */
    public void update(int x,int y,int id)
    {
        if(id==this.P[0].id  ){ this.P[0].set_coord(x, y);}
        if(id==this.P[1].id  ){ this.P[1].set_coord(x,y);}
        this.D.update(x, y, id);
        //System.out.print("je dois up la droite");
        int ABx=D.P[1].getX()-D.P[0].getX()+P[0].getX();
        int ABy=(D.P[1].getY()-D.P[0].getY())+P[0].getY();
        P[1].set_coord(ABx,ABy);

    }
}
