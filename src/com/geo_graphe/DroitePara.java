package com.geo_graphe;

/**
 * Created by Stephane on 12/12/14.
 */
public class DroitePara extends Droite {
    Droite D;
    //Pt A;

    DroitePara(Droite D, Pt A,Pt B, int id) {
        super(A, B, id);
        this.D=D;
        //this.A=A;
        int ABx=this.D.P[1].getX()-this.D.P[0].getX()+P[0].getX();
        int ABy=(this.D.P[1].getY()-D.P[0].getY())+P[0].getY();
        P[1].set_coord(ABx,ABy);
        P[1].setVisible(false);
    }

    public void update(int x,int y,int id)
    {
        if(id==this.P[0].id  ){ this.P[0].set_coord(x, y);}
        if(id==this.P[1].id  ){ this.P[1].set_coord(x,y);}
        this.D.update(x, y, id);
        System.out.print("je dois up la droite");
        int ABx=D.P[1].getX()-D.P[0].getX()+P[0].getX();
        int ABy=(D.P[1].getY()-D.P[0].getY())+P[0].getY();
        P[1].set_coord(ABx,ABy);

    }
}
