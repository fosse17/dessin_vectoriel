package com.geo_graphe;


import java.awt.*;

public class Barycentre extends Pt implements forme {

    int num_point;
    Pt[] P;




    public Barycentre(Pt[] tab,int nb_point,int id)
    {
        super(0,0,id);
        int a=0;
        int b=0;
        this.num_point=nb_point;
        P=new Pt[nb_point];
        for(int i=0;i<this.num_point;i++)
        {
            this.P[i]=tab[i];
            a+=tab[i].getX();b+=tab[i].getY();
        }
        this.set_coord(a/nb_point, b/nb_point);
        this.setMovable(false);
        for(int i=0;i<this.num_point;i++) System.out.print(P[i].get_id()+"  ");
        System.out.println();

    }


    public int check_in(int id1)  //verfie sir le Pt passer en paramettre appartiens à l'ensemble des piints du barycentre
    {
        for(int i=0;i<this.num_point;i++)
        {
            if(this.P[i].get_id()==id1) return i;

        }
        return -1;
    }

    public void update(int x,int y,int i1)
    {
        int pos=check_in(i1);
        System.out.println("Il faut bouger le point n°"+pos);
        P[pos].set_coord(x,y);
        int a=0;
        int b=0;
        for(int i=0;i<this.num_point;i++)
        {
            a+=P[i].getX();b+=P[i].getY();
        }
        this.set_coord(a/num_point, b/num_point);
    }

    @Override
    public void set_id(int i) {

    }

    @Override
    public int get_id() {
        return this.id;
    }

    @Override
    public void set_couleur(Color c) {
        //todo dans la classe Pt
    }

    @Override
    public Color get_couleur() {
        return super.get_couleur();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean is_movable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set_movable(Boolean c) {
        //not yet
    }

    @Override
    public void draw(Graphics g) {
       super.draw(g);
    }

    @Override
    public void setVisible(Boolean visible) {
       this.visible=visible;
    }
}
