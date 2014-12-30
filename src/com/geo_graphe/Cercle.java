package com.geo_graphe;

import java.awt.*;


/**
 * Classe pour créer un cercle
 */
public class Cercle extends Forme2D implements forme{

    /**
     * Le rayon du cercle
     */
    int rayon, /**
     * The Dx.
     */
    dx, /**
     * The Dy.
     */
    dy;
    /**
     * par défault on ne peut pas bouger le cercle
     */
    boolean move=false;
    /**
     * l'id du cercle est initialisé à 0
     */
    int id=0;
    /**
     * The Over.
     */
//Color couleur=Color.DARK_GRAY;
    Color over=Color.BLUE;
    /**
     * The Nover.
     */
    Color nover=couleur;

    /**
     * Instancie un nouveau cercle
     *
     * @param A un point A
     * @param B un point B
     * @param i l'id du cercle
     */
    public Cercle(Pt A, Pt B,int i)
    {
        super(A,B,i);
        this.id=i;
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        System.out.println("vecteur  "+dx+" "+dy);
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    /**
     * Met à jour le rayon
     *
     * @param a the a
     * @param b the b
     */
    protected void update_rayon(int a, int b)
    {
        super.update_end(a,b);
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    /**
     * Modifie la position du centre
     *
     * @param a the a
     * @param b the b
     */
    protected void update_centre(int a, int b)
    {
        P[0].set_coord(a,b);
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
        //super.update_end(P[0].getX()+dx,P[0].getY()+dy);
        //rayon=(int) Math.sqrt((init.x-end.x)*(init.x-end.x)+(init.y-end.y)*(init.y-end.y));
    }


    /**
     * Update _ zoom.
     */
    public void update_zoom()
    {
        dx=P[1].getX()-P[0].getX();
        dy=P[1].getY()-P[0].getY();
        rayon=(int) Math.sqrt((dx)*(dx)+(dy)*(dy));
    }

    /**
     * Change de couleur si on est proche du cercle
     *
     * @param x Coordonnée x de la souris
     * @param y Coordonnée y de la souris
     * @return true si dessus, false sinon.
     */
    public boolean isNear(int x,int y)
     {
         if((this.P[0].distance(x, y) < (this.rayon + 5)) && (this.P[0].distance(x, y) > (this.rayon - 5))) {
             this.couleur=over; return true;
         }
         this.couleur=nover;return false;
     }

    /**
     *
     * @return id du cercle
     */
    public int get_id() {
        return this.id;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Défini un nouvel id au cercle
     * @param i le nouvel id
     */
    public void set_id(int i) {
        this.id = i;
    }

    /**
     * Modifie le centre et le rayon du cercle par rapport aux nouvelles coordonnées x et y
     * @param x nouvelle abscisse
     * @param y nouvelle ordonnée
     * @param id the id
     */
    public void update(int x, int y, int id) {
        if(id==P[0].get_id()) this.update_centre(x,y);
        if(id==P[1].get_id()) this.update_rayon(x,y);
    }

    /**
     *
     * @return la couleur actuelle du cercle
     */
    public Color get_couleur() {
        return this.couleur;
    }

    /**
     *
     * @param c la couleur à définir
     */
    public void set_couleur(Color c) {
        super.setCouleur(c);
    }

    /**
     *
     * @return true si movable, false sinon
     */
    public boolean is_movable() {
        return move;
    }

    /**
     * Défini si une figure est deplacable ou non
     * @param c true si deplacable, false sinon
     */
    public void set_movable(Boolean c) {
        this.move=c;
    }

    /**
     * Dessine le cercle dans la canvas
     * @param g
     */
    public void draw(Graphics g) {
        Color a=g.getColor();
        g.setColor(couleur);
        g.drawOval(P[0].getX()-rayon,P[0].getY()-rayon,2*rayon,2*rayon);
        g.setColor(a);

    }

    /**
     *
     * @param visible true si visible, false sinon.
     */
    public void setVisible(Boolean visible) {
        super.setVisible(visible);

    }

}

