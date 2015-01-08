package com.geo_graphe;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Création d'un vecteur pour faire les translations
 */
public class vecteur extends Segment {

    private final int ARR_SIZE = 6;

    /**
     * Instancie un nouveau vecteur
     *
     * @param A the a
     * @param B the b
     * @param id the id
     */
    public vecteur(Pt A, Pt B, int id) {
        super(A, B, id);
    }

    public void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1.create();
        P[0].draw(g);;
        P[1].draw(g);;
        double dx = P[1].getX() - P[0].getX();
        double dy=P[1].getY() - P[0].getY();
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(P[0].getX(), P[0].getY());
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);

    }

}
