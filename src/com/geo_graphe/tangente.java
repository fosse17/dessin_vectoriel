package com.geo_graphe;


/**
 * The type Tangente.
 */
class tangente extends Droite {

    private Cercle c;

    /**
     * Instantiates a new Tangente.
     *
     * @param c the c
     * @param A the a
     * @param B the b
     * @param id the id
     */
    tangente(Cercle c,Pt A, Pt B, int id) {
        super(A, B, id);
        this.c=c;
        Droite D=new Droite(c.P[0],A,-1);
        Droite Perp=new DroitePerp(D,A,B,-1);
        this.P[1].set_coord(Perp.P[1].getX(),Perp.P[1].getY());
    }


    public void update(int x,int y,int id)
    {
          c.update(x,y,id);
        Droite D=new Droite(c.P[0],this.P[0],-1);
        Droite Perp=new DroitePerp(D,this.P[0],new Pt(-10,10),-1);
        this.P[1].set_coord(Perp.P[1].getX(),Perp.P[1].getY());
    }
}
