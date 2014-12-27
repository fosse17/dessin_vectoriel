package com.geo_graphe;

/**
 * Created by Stephane on 27/12/14.
 */
public class PtSymAxiale extends Pt {

    Pt A;
    Droite d;

    public PtSymAxiale(Pt A, Droite d, int i) {
        super(0, 0, i);
        this.A = A;
        this.d = d;
        /*
        n=a²+b²
        cm= -axm - bym
        xm' = xm +2a(-c+cm)/n
        ym' = ym +2b(-c+cm)/n
         */
        int[] t = d.coeff();
        int n = t[0] * t[0] + t[1] * t[1];
        int cm = (-1) * t[0] * A.getX() + (-1) * t[1] * A.getY();
        int xm = A.getX() + 2 * t[0] * (cm - t[2]) / n;
        int ym = A.getY() + 2 * t[1] * (cm - t[2]) / n;
        this.set_coord(xm, ym);
        this.set_movable(false);

    }

    @Override
    public void update(int x, int y, int id) {
        if (id == this.A.get_id()) A.set_coord(x, y);
        d.update(x, y, id);
        int[] t = d.coeff();
        int n = t[0] * t[0] + t[1] * t[1];
        int cm = (-1) * t[0] * A.getX() + (-1) * t[1] * A.getY();
        int xm = A.getX() + 2 * t[0] * (cm - t[2]) / n;
        int ym = A.getY() + 2 * t[1] * (cm - t[2]) / n;
        this.set_coord(xm, ym);
    }
}
