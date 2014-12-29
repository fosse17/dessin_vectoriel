package com.geo_graphe;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.LinkedList;

public class MyCanvas extends JPanel implements Printable {

	protected LinkedList<forme> formes = new LinkedList<forme>();
	protected String mode;
	protected Repere R;
    protected Pt O;
    protected int id_figure=0;//id de la figure a inserer dans le graphe et dans la lissLinked
    protected Color color;
    Graph G = new Graph(0);

    MyCanvas() {

        super();
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        mode = "Deplacer";
        R = new Repere(-20, 10, -10, 10, this.getPreferredSize(), ++this.id_figure);
        R.setVisible(true);
        O = new Pt(R.getOrigine(), 0);
        this.addForme(O);
        this.addForme(R);
        G.addEdge(O.get_id(), R.get_id());
        color = Color.BLACK;

        //classe de constructeur
        Pt test = new Pt(300, 100, ++this.id_figure);
        Pt p = new Pt(100, 100, ++this.id_figure);
        Pt p1 = new Pt(150, 150, ++this.id_figure);
        Pt p2 = new Pt(350, 250, ++this.id_figure);

        Pt pp1 = new Pt(-10, -10, ++this.id_figure);
        Pt pp2 = new Pt(-10, -10, ++this.id_figure);
        Pt[] pts = new Pt[100];
        Polygone polygone = new Polygone(pts, 0, ++this.id_figure);
        polygone.add(p);
        polygone.add(p1);
        polygone.add(p2);



        this.addForme(test);
        this.addForme(p);
        this.addForme(p1);
        this.addForme(p2);
        this.addForme(pp1);
        this.addForme(pp2);
        this.addForme(polygone);


        G.addEdge(p.get_id(), polygone.get_id());
        G.addEdge(p1.get_id(), polygone.get_id());
        G.addEdge(p2.get_id(), polygone.get_id());


    }

    public int getId_figure() {
        return id_figure;
    }

    public void update_id_figure()
    {
        this.id_figure++;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

	public LinkedList<forme> get_formes()
	{
		return formes;
	}
	
	public void paint(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.5f));
        g2.clearRect(0,0,this.getWidth(),this.getHeight());
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        for(forme p:formes)
        {
            if(p.isVisible())
            {
                p.draw(g2);
            }
        }
	}
	
	public void addForme(forme p) {
		formes.add(p);
        G.add_vertex();
		repaint();
	}


    public void removeForme(forme p) {
        formes.remove(p);
        repaint();
	}

	public void clear() {
		formes.clear();
        G = new Graph(0);
        id_figure = 0;
        mode = "Deplacer";
        R = new Repere(-10, 10, -10, 10, this.getPreferredSize(), ++this.id_figure);
        R.setVisible(true);
        O = new Pt(R.getOrigine(), 0);
        this.addForme(O);
        this.addForme(R);
        G.addEdge(O.get_id(), R.get_id());
        repaint();
	}

    public String getMode() {
        return mode;
    }

	public void setMode(String mode)
	{
		this.mode=mode;
	}

	public Repere getR() {


		return R;
	}

    void Zoom(double facteur)
    {
        for(forme f:formes) {

            if(f instanceof Pt)
            {
                //System.out.println("jaitrouveunpoint");
                double abs=R.getabs(((Pt) f).getX())*facteur;
                double ord=R.getord(((Pt) f).getY())*facteur*(-1);
                ((Pt) f).set_coord(R.convert(abs, ord).getX(), R.convert(abs, ord).y);
                for (forme p : this.get_formes()) {
                    p.update(((Pt) f).getX(), ((Pt) f).getY(), ((Pt) f).get_id());
                }
            }
            //if(f instanceof Repere)
            //f.update(((Pt)formes.get(0)).getX(),((Pt)formes.get(0)).getY(),-1);

        }
        for(int i=0;i<formes.size() ;i++) {
            if(formes.get(i) instanceof Cercle)
            {
                ((Cercle) formes.get(i)).update_zoom();
            }
        }
        repaint();
    }

    public void do_print()
    {
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        pj.setPrintable(this,pf);
        if ( pj.printDialog() )
            try {
                pj.print(); }
            catch(PrinterException pe) {
                System.out.println("Erreur d'impression");}
    }




    @Override
    public int print(Graphics g, PageFormat pageFormat, int page) throws PrinterException {
        if ( page >= 1 )
            return(Printable.NO_SUCH_PAGE);
        Graphics2D g2 =(Graphics2D) g;
        g2.setStroke(new BasicStroke(1.3f));
        for(forme p:formes)
        {
            if(p.isVisible())
            {
                p.draw(g2);
            }
        }
        return(Printable.PAGE_EXISTS);
    }
}
