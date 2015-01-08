package com.geo_graphe;

/**
 * Permet de donner le milieu d'un segment,qui est aussi le barycentre des deux points du segment.
 */
public class Milieu extends Barycentre{
    public Milieu(Pt[] tab,int id) {
        super(tab, 2,id);
    }

}
