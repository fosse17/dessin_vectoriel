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
    Graph G = new Graph(0);
	protected String mode;
	protected Repere R;
    protected Pt O;
    protected int id_figure=0;//id de la figure a inserer dans le graphe et dans la lissLinked

    public int getId_figure() {
        return id_figure;
    }

    public void update_id_figure()
    {
        this.id_figure++;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected Color color;



	
	MyCanvas()
	{

		super();
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800,600));
        mode="Deplacer";
        R=new Repere(-10,10,-10,10,this.getPreferredSize(),++this.id_figure);
        R.setVisible(true);
        O=new Pt(R.getOrigine(),0);
        this.addForme(O);
        this.addForme(R);
        G.addEdge(O.get_id(),R.get_id());


        Pt test=new Pt(300,100,++this.id_figure);
        Pt p=new Pt(100,100,++this.id_figure);
        Pt p1=new Pt(150,150,++this.id_figure);
        Pt p2=new Pt(150,150,++this.id_figure);/*

        Pt[] tabPt=new Pt[2];
        tabPt[0]=test;tabPt[1]=p;

        Droite d=new Droite(test,p,++this.id_figure);
        Droite d1=new Droite(test,p1,++this.id_figure);
        Droite d2=new Droite(p,p1,++this.id_figure);
        //Milieu m=new Milieu(tabPt,-1);
        DroitePerp DP=new DroitePerp(d,p1,p2,++this.id_figure);
        //Triangle tr=new Triangle(d,d1,d2,++this.id_figure);

        this.addForme(test);
        this.addForme(p);
        this.addForme(p1);
        this.addForme(p2);
        this.addForme(d);
        this.addForme(d1);
        this.addForme(d2);//this.addForme(DP.P[1],false);
        this.addForme(DP);



        //color=Color.BLACK;
        //this.setBackground(color);
        /*
        Pt test=new Pt(300,100,++this.id_figure);
        test.set_couleur(Color.blue);
        Pt p=new Pt(100,100,++this.id_figure);
        Pt p1=new Pt(150,150,++this.id_figure);
        Segment s=new Segment(p,p1,++this.id_figure);*/
        Cercle c= new Cercle(p,p1,++this.id_figure);

        PtCercle ptc=new PtCercle(c,0,0,++this.id_figure);
        tangente ta=new tangente(c,ptc,test,++this.id_figure);
        /*

        Rectangl Re=new Rectangl(p,p1,++this.id_figure);
        Pt[] tabPt=new Pt[3];
        tabPt[0]=test;tabPt[1]=p;tabPt[2]=p1;
        Barycentre Bar=new Barycentre(tabPt,3,++this.id_figure);
        //System.out.println("jlhvljhvljhvljhv"+Bar.P[0]);
        tabPt[0]=test;tabPt[1]=p;tabPt[2]=Bar;
        Barycentre Bar1=new Barycentre(tabPt,3,++this.id_figure);
        Droite d=new Droite(test,p,++this.id_figure);
        Droite d1=new Droite(Bar,p1,++this.id_figure);

        PtInterDroite interd=new PtInterDroite(d,d1,++this.id_figure);

        PtSegment ptd=new PtSegment(s,125,10,++this.id_figure);

        Triangle T=new Triangle(test,p,p1,++this.id_figure);


        tabPt=new Pt[2];
        tabPt[0]=Bar;tabPt[1]=Bar1;
        Milieu mil=new Milieu(tabPt,++this.id_figure);
       */
        this.addForme(test);
        this.addForme(p);
        this.addForme(p1);
        this.addForme(p2);
        this.addForme(c);
        this.addForme(ptc);
        this.addForme(ta);
        /*
        this.addForme(Re);
        this.addForme(Bar);
        this.addForme(Bar1);
        this.addForme(d);
        this.addForme(d1);
        this.addForme(interd);
        this.addForme(ptd);
        this.addForme(T);
        this.addForme(mil);

        G.addEdge(s.P[0].id,s.id);
        G.addEdge(s.P[1].id,s.id);
        */
        G.addEdge(c.P[0].id,c.id);
        G.addEdge(c.P[1].id,c.id);

        G.addEdge(c.P[0].id,ptc.get_id());
        G.addEdge(c.P[1].id,ptc.get_id());
        G.addEdge(c.id,ptc.get_id());

        G.addEdge(ta.P[0].id,ta.get_id());
        G.addEdge(ptc.get_id(),ta.get_id());

        /*
        G.addEdge(Re.P[0].id,Re.id);
        G.addEdge(Re.P[1].id,Re.id);

        G.addEdge(Bar.P[0].id,Bar.id);
        G.addEdge(Bar.P[1].id,Bar.id);
        G.addEdge(Bar.P[2].id,Bar.id);

        G.addEdge(Bar1.P[0].id,Bar1.id);
        G.addEdge(Bar1.P[1].id,Bar1.id);
        G.addEdge(Bar1.P[2].id,Bar1.id);

        G.addEdge(d.P[0].id,d.id);
        G.addEdge(d.P[1].id,d.id);
        G.addEdge(d1.P[0].id,d1.id);
        G.addEdge(d1.P[1].id,d1.id);
        G.addEdge(d2.P[0].id,d2.id);
        G.addEdge(d2.P[1].id,d2.id);

        //G.addEdge(p1.id,DP.id);
        G.addEdge(d.P[0].id,DP.id);
        G.addEdge(d.P[1].id,DP.id);
        G.addEdge(d.P[0].id,DP.P[0].id);
        G.addEdge(d.P[1].id,DP.P[1].id);
        G.addEdge(DP.P[0].id,DP.id);
        G.addEdge(DP.P[1].id,DP.id);
        //G.addEdge(p1.id,DP.id);
        /*
        G.addEdge(d.P[0].id,interd.id);
        G.addEdge(d.P[1].id,interd.id);
        G.addEdge(d1.P[0].id,interd.id);
        G.addEdge(d1.P[1].id,interd.id);

        G.addEdge(s.P[0].id,ptd.id);
        G.addEdge(s.P[1].id,ptd.id);


        G.addEdge(T.P[0].id, T.id);
        G.addEdge(T.P[1].id,T.id);
        G.addEdge(T.P[2].id,T.id);


        G.addEdge(mil.P[0].id,mil.id);
        G.addEdge(mil.P[1].id,mil.id);
        //System.out.println(G.toString());


        repaint();*/
    }

	
	public LinkedList<forme> get_formes()
	{
		return formes;
	}
	
	public void paint(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2.setStroke(new BasicStroke(1.1f));

        //g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
       // System.out.println(G.toString());
		repaint();
	}
    public void addForme(forme p,boolean b) {
        formes.add(p);
        if(b) G.add_vertex();
        // System.out.println(G.toString());
        repaint();
    }

	public void removeForme(forme p) {
		formes.remove(p);
		repaint();
	}

	public void clear() {
		formes.clear();
		repaint();
	}
	
	public void setMode(String mode)
	{
		this.mode=mode;
	}

	public String  getMode()
	{
		return mode;
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
            }
            if(f instanceof Repere)
                f.update(((Pt)formes.get(0)).getX(),((Pt)formes.get(0)).getY(),-1);

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
        g2.setStroke(new BasicStroke(1.1f));
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
