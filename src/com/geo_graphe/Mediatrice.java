package com.geo_graphe;


/**
 * La classe Mediatrice permet de créer une médiatrice d'un segment
 */
public class Mediatrice extends Droite {

    /**
     * Le point A
     */
    Pt A, /**
     * Le point B
     */
    B, /**
     * Le Milieu
     */
    mil;

    /**
     * Instancie une nouvelle médiatrice
     *
     * @param A the a
     * @param B the b
     * @param med1 the med 1
     * @param med2 the med 2
     * @param id the id
     */
    Mediatrice(Pt A, Pt B, Pt med1, Pt med2, int id) {
        super(med1,med2,id);
        Pt[] tab=new Pt[2];
        this.A=tab[0]=A;
        this.B=tab[1]=B;
        mil=new Milieu(tab,-1);
        P[0].set_coord(mil.getX(), mil.getY());
        P[0].setVisible(false);
        int ABy=this.B.getX()-this.A.getX()+P[0].getY();
        int ABx=-(this.B.getY()-this.A.getY())+P[0].getX();
        P[1].set_coord(ABx, ABy);
        P[1].setVisible(false);

    }

    public void update(int x,int y,int id)
    {
        if(id==this.A.id){ this.mil.update(x,y,id);}
        if(id==this.B.id){ this.mil.update(x, y, id);}
        P[0].set_coord(mil.getX(),mil.getY());
            //System.out.print("je dois up la droite");
        int ABy=B.getX()-A.getX()+P[0].getY();
        int ABx=-(B.getY()-A.getY())+P[0].getX();
        P[1].set_coord(ABx,ABy);
}

}