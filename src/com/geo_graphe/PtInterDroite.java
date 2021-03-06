package com.geo_graphe;

/**
 * Classe PtInterDroite permet la création d'un point à l'intersection de deux droites
 */
public class PtInterDroite extends Pt {

    Droite d;
    Droite d1;

    PtInterDroite(Droite d,Droite d1,int i) {
        super(-10, -10, i);
        this.d=d;this.d1=d1;
        //System.out.println("coef "+this.d.coeff()[0]+" "+this.d.coeff()[1]+" "+this.d.coeff()[2]);
        //System.out.println("coef "+this.d1.coeff()[0]+" "+this.d1.coeff()[1]+" "+this.d1.coeff()[2]);
        this.set_movable(false);
        create();

    }

    /**
     * Création du point
     */
    public void create()
    {
        int[] t1=d.coeff();
        int[] t2=d1.coeff();
        int delta=t1[0]*t2[1]-t1[1]*t2[0];
        if(delta==0)   //les droite sont parallele
        {
            //System.out.print("allllllller !");
        }
        else
        {
            int delta1=t1[2]*t2[1]-t2[2]*t1[1];
            int delta2=t1[0]*t2[2]-t2[0]*t1[2];
            this.set_coord(-delta1/delta,-delta2/delta);
        }
    }

    /**
     * Modifie la position du point si on bouge les droites
     * @param x
     * @param y
     * @param id
     */
    public void update(int x,int y,int id)
    {
        d.update(x, y, id);
        d1.update(x,y,id);
        create();
    }
}
