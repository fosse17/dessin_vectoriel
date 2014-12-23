package com.geo_graphe;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class MyMouseListener implements MouseListener,MouseMotionListener {
	
	MyCanvas canvas;
    String mode;
    String sous_mode;
    forme f = null;
    private Triangle T;
    private Cercle C;
    private Texte text;
    private CercleTrans cercleTrans;
    private DroiteTrans droiteTrans;
    private SegmentTrans segmentTrans;
    private Rectangl R;
    private PtCercle ptc = null;
    private PtDroite psd;
    private PtSegment pss = null;
    private PolyRegulier pr;
    private Pt pt2;
    private Segment Seg;
    private vecteur Vec;
    private Droite D;
    private Droite D1;
    private PtInterDroite Pinter;
    private Pt[] ptb;
	private Pt init;
    private DroitePerp Drperp;
    private DroitePara Dpara;
    private int num;
    private int nb_click;//num1 est utile pour les triangles et pour les barycentres, milieu
    private BreadthFirstPaths Bfs;

	MyMouseListener(MyCanvas canvas)
	{
		this.canvas = canvas;
		this.canvas.addMouseListener(this);
		this.canvas.addMouseMotionListener(this);
		mode=this.canvas.getMode();
        sous_mode="";
        nb_click=0;
		
	}
	
	public MyCanvas getCanvas() {
		return canvas;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mode=canvas.getMode();
		if (SwingUtilities.isLeftMouseButton(e)) {
			leftClickAction(e);
		} else {
			rightClickAction(e);
		}
	}
	
	protected void rightClickAction(MouseEvent e) {

		
	}

	protected void leftClickAction(MouseEvent e) {
        //System.out.println(e.getSource());

		}


	 public Pt assign(int x,int y,int except)
     {
         for(forme p:canvas.get_formes())
         {
             if (p instanceof Pt)
             {
                 if(((Pt) p).isNear(x,y) && ((Pt) p).id!=except) return (Pt)p;

             }
         }
         return null;//sans doute plus simple a gerer
     }

	@Override
    public void mousePressed(MouseEvent evt) {

        mode=canvas.getMode();

        int x = evt.getX();
        int y = evt.getY();

        num=-1;

        if(mode.equals("Point"))
        {
            Pt pt=new Pt(x, y,++canvas.id_figure);
            pt.set_couleur(canvas.getColor());
            canvas.addForme(pt);
            //System.out.print("mode point");
        }
        if(mode.equals("Ptcercle"))
        {
            for (forme p:canvas.get_formes())
            {
                if(p instanceof Cercle)
                {
                    if(((Cercle) p).isNear(x,y))
                    {
                        ptc=new PtCercle((Cercle)p,x,y,++this.canvas.id_figure);
                        this.f=p;

                    }
                }
            }
            if(ptc!=null)
            {
                canvas.addForme(ptc);
                canvas.G.addEdge(((Cercle) f).P[0].get_id(),ptc.get_id());
                canvas.G.addEdge(((Cercle) f).P[1].get_id(),ptc.get_id());
                //canvas.G.addEdge(((Cercle) f).get_id(),ptc.get_id());
            }

        }
        if(mode.equals("Ptdroite"))
        {
            for (forme p:canvas.get_formes())
            {
                if(p instanceof Droite)
                {
                    if(((Droite) p).isNear(x,y))
                    {
                        psd=new PtDroite((Droite)p,x,y,++this.canvas.id_figure);
                        this.f=p;

                    }
                }
            }
            if(psd!=null)
            {
                canvas.addForme(psd);
                canvas.G.addEdge(((Droite) f).P[0].get_id(),psd.get_id());
                canvas.G.addEdge(((Droite) f).P[1].get_id(),psd.get_id());
                //canvas.G.addEdge(((Cercle) f).get_id(),ptc.get_id());
            }

        }
        if(mode.equals("PtSegment"))
        {
            System.out.println("mode point sur segment");
            for (forme p:canvas.get_formes())
            {
                if(p instanceof Segment)
                {
                    if(((Segment) p).isNear(x,y))
                    {
                        //System.out.println("je suis bien proche pourtant");
                        pss=new PtSegment((Segment)p,x,y,++this.canvas.id_figure);
                        this.f=p;

                    }
                }
            }
            if(pss!=null)
            {
                canvas.addForme(pss);
                canvas.G.addEdge(((Segment) f).P[0].get_id(),pss.get_id());
                canvas.G.addEdge(((Segment) f).P[1].get_id(),pss.get_id());
                //canvas.G.addEdge(((Cercle) f).get_id(),ptc.get_id());
            }

        }
        if(mode.equals("Cercle"))
        {
            init=assign(x,y,-1);
            if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
            pt2=new Pt(x, y,++this.canvas.id_figure);
            canvas.addForme(pt2);
            C=new Cercle(init,pt2,++canvas.id_figure);
            C.set_couleur(canvas.getColor());
            canvas.addForme(C);
        }

        if(mode.equals("Texte"))
        {
            String tt = JOptionPane.showInputDialog("Entrez votre texte:");
            if(tt!=null) {
                init=assign(x,y,-1);
                if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
                text = new Texte(tt, init, ++this.canvas.id_figure);
                canvas.addForme(text);
                canvas.G.addEdge(init.get_id(),text.get_id());
            }
        }
        if(mode.equals("Rectangle"))
        {
            init=assign(x,y,-1);
            if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
            pt2=new Pt(x, y,++this.canvas.id_figure);
            canvas.addForme(pt2);
            R=new Rectangl(init,pt2,++canvas.id_figure);
            R.set_couleur(canvas.getColor());
            canvas.addForme(R);

        }
        if(mode.equals("Segment"))
        {
            init=assign(x,y,-1);
            if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
            pt2=new Pt(x, y,++this.canvas.id_figure);
            canvas.addForme(pt2);
            Seg=new Segment(init,pt2,++canvas.id_figure);
            Seg.set_couleur(canvas.getColor());
            canvas.addForme(Seg);
        }

        if(mode.equals("Polyreg"))
        {

            init=assign(x,y,-1);
            if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
            pt2=new Pt(x, y,++this.canvas.id_figure);
            canvas.addForme(pt2);
            pr=new PolyRegulier(init,pt2,Menu.nbcote,++canvas.id_figure);
            pr.set_couleur(canvas.getColor());
            canvas.addForme(pr);
        }

        if(mode.equals("Vecteur"))
        {
            init=assign(x,y,-1);
            if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
            pt2=new Pt(x, y,++this.canvas.id_figure);
            canvas.addForme(pt2);
            Vec=new vecteur(init,pt2,++canvas.id_figure);
            Vec.set_couleur(canvas.getColor());
            canvas.addForme(Vec);
        }

        if(mode.equals("B3"))
        {
            int nb_point_total=3;//demande
            if(nb_click==0) {ptb=new Pt[nb_point_total]; }
            if(nb_click<nb_point_total)
            {
                //System.out.println("je compte les points : "+nb_click);
                f=assign(x,y,-1);
                if(f==null) {ptb[nb_click]=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(ptb[nb_click]);}
                else {
                    ptb[nb_click]=(Pt)f;
                }
                nb_click+=1;
            }
            if(nb_click==nb_point_total) {
                Barycentre Bar=new Barycentre(ptb,nb_point_total,++this.canvas.id_figure);
                canvas.addForme(Bar);
                for(int i=0;i<nb_point_total;i++) {
                    canvas.G.addEdge(Bar.P[i].get_id(), Bar.get_id());
                }
                nb_click=0;}

        }
        if(mode.equals("tangente")) {
            this.f=null;
            for (forme p:canvas.get_formes()) {
                if (p instanceof Cercle) {
                    if (((Cercle) p).isNear(x, y)) {
                        ptc = (PtCercle) this.assign(x, y, -1);
                        this.f = p;

                    }
                }
            }
            if(ptc==null)
                {
                    ptc=new PtCercle((Cercle)this.f,x,y,++this.canvas.id_figure);
                }
                else
                {
                    ptc=new PtCercle((Cercle)this.f,x,y,++this.canvas.id_figure);
                    //pas encore gere :)
                }
            canvas.addForme(ptc);
            Pt enc=new Pt(-10,10,++canvas.id_figure);
            canvas.addForme(enc);
            tangente tan=new tangente((Cercle)this.f,ptc,enc,++canvas.id_figure);
            canvas.addForme(tan);

            canvas.G.addEdge(((Cercle)f).P[0].get_id(),ptc.get_id());
            canvas.G.addEdge(((Cercle)f).P[1].get_id(),ptc.get_id());

            canvas.G.addEdge(tan.P[0].id,tan.get_id());
            canvas.G.addEdge(ptc.get_id(),tan.get_id());
            canvas.G.addEdge(((Cercle)f).P[0].get_id(),tan.get_id());
            canvas.G.addEdge(((Cercle)f).P[1].get_id(),tan.get_id());

        }


        if(mode.equals("droiteperp"))
        {
            if (nb_click == 0) {
                D=null;init=null; pt2=null;
            }
            if (nb_click == 0) {
                for (forme p : canvas.get_formes()) {
                    if (p instanceof Droite) {
                        if (((Droite) p).isNear(x, y)) {D = (Droite) p;nb_click++;}
                    }
                }
            }
            else if (nb_click == 1)
            {
                init = this.assign(x, y, -1);
                if (init == null)
                {
                    init = new Pt(x, y, ++this.canvas.id_figure);
                    canvas.addForme(init);

                }
                pt2 = new Pt(x, y, ++this.canvas.id_figure);
                canvas.addForme(pt2);
                if (D != null) {

                    Drperp = new DroitePerp(D, init,pt2, ++this.canvas.id_figure);
                    canvas.addForme(Drperp);
                    System.out.println(D.P[0].id+" "+D.P[1].id+" "+init.get_id()+" "+Drperp.get_id());
                    canvas.G.addEdge(D.P[0].id, Drperp.get_id());
                    canvas.G.addEdge(D.P[1].id, Drperp.get_id());

                    canvas.G.addEdge(D.P[0].id, Drperp.P[0].get_id());
                    canvas.G.addEdge(D.P[0].id, Drperp.P[1].get_id());
                    canvas.G.addEdge(D.P[1].id, Drperp.P[0].get_id());
                    canvas.G.addEdge(D.P[1].id, Drperp.P[1].get_id());

                    canvas.G.addEdge(Drperp.P[0].get_id(), Drperp.get_id());
                    canvas.G.addEdge(Drperp.P[1].get_id(), Drperp.get_id());
                    //System.out.print(canvas.G.toString());

                }
                nb_click=0;
            }
        }
        if(mode.equals("Translation"))
        {
            if (nb_click == 0) {
                C=null;Vec=null;sous_mode="";
            }
            if (nb_click == 0) {
                for (forme p : canvas.get_formes()) {
                    if (p instanceof Cercle) {
                        if (((Cercle) p).isNear(x, y)) {C = (Cercle) p;nb_click++;sous_mode="cercle";}
                    }
                    if (p instanceof Droite) {
                        if (((Droite) p).isNear(x, y)) { D= (Droite) p;nb_click++; sous_mode="droite";}
                    }
                    if (p instanceof Segment) {
                        if (((Segment) p).isNear(x, y)) {
                            Seg = (Segment) p;
                            nb_click++;
                            sous_mode = "segment";
                        }
                    }
                }
            }
            else if (nb_click == 1)
            {
                for (forme p : canvas.get_formes()) {
                    if (p instanceof vecteur) {
                        if (((vecteur) p).isNear(x, y)) {Vec = (vecteur) p;nb_click++;}
                    }
                }
                if(sous_mode.equals("cercle")) {
                    if ((C != null) && (Vec != null)) {
                        init=new Pt(-10,-10,++this.canvas.id_figure);
                        pt2=new Pt(-10,-10,++this.canvas.id_figure);
                        canvas.addForme(init);
                        canvas.addForme(pt2);
                        cercleTrans = new CercleTrans(C, Vec,init,pt2, ++this.canvas.id_figure);
                        canvas.addForme(cercleTrans);
                        //System.out.println(D.P[0].id+" "+D.P[1].id+" "+init.get_id()+" "+Drperp.get_id());
                        canvas.G.addEdge(C.P[0].id, cercleTrans.get_id());
                        canvas.G.addEdge(C.P[1].id, cercleTrans.get_id());
                        canvas.G.addEdge(Vec.P[0].id, cercleTrans.get_id());
                        canvas.G.addEdge(Vec.P[1].id, cercleTrans.get_id());
                    }
                }
                if(sous_mode.equals("droite")) {
                    if ((D != null) && (Vec != null)) {
                        init=new Pt(-10,-10,++this.canvas.id_figure);
                        pt2=new Pt(-10,-10,++this.canvas.id_figure);
                        canvas.addForme(init);
                        canvas.addForme(pt2);
                         droiteTrans= new DroiteTrans(D, Vec,init,pt2, ++this.canvas.id_figure);
                        canvas.addForme(droiteTrans);
                        //System.out.println(D.P[0].id+" "+D.P[1].id+" "+init.get_id()+" "+Drperp.get_id());
                        canvas.G.addEdge(D.P[0].id, droiteTrans.get_id());
                        canvas.G.addEdge(D.P[1].id, droiteTrans.get_id());
                        canvas.G.addEdge(D.P[0].id, droiteTrans.P[0].get_id());
                        canvas.G.addEdge(D.P[0].id, droiteTrans.P[1].get_id());
                        canvas.G.addEdge(D.P[1].id, droiteTrans.P[0].get_id());
                        canvas.G.addEdge(D.P[1].id, droiteTrans.P[1].get_id());
                        canvas.G.addEdge(Vec.P[0].id, droiteTrans.get_id());
                        canvas.G.addEdge(Vec.P[1].id, droiteTrans.get_id());
                    }
                }
                if (sous_mode.equals("segment")) {
                    if ((Seg != null) && (Vec != null)) {
                        init = new Pt(-10, -10, ++this.canvas.id_figure);
                        pt2 = new Pt(-10, -10, ++this.canvas.id_figure);
                        canvas.addForme(init);
                        canvas.addForme(pt2);
                        segmentTrans = new SegmentTrans(Seg, Vec, init, pt2, ++this.canvas.id_figure);
                        canvas.addForme(segmentTrans);
                        //System.out.println(D.P[0].id+" "+D.P[1].id+" "+init.get_id()+" "+Drperp.get_id());
                        canvas.G.addEdge(Seg.P[0].id, segmentTrans.get_id());
                        canvas.G.addEdge(Seg.P[1].id, segmentTrans.get_id());
                        canvas.G.addEdge(Seg.P[0].id, segmentTrans.P[0].get_id());
                        canvas.G.addEdge(Seg.P[0].id, segmentTrans.P[1].get_id());
                        canvas.G.addEdge(Seg.P[1].id, segmentTrans.P[0].get_id());
                        canvas.G.addEdge(Seg.P[1].id, segmentTrans.P[1].get_id());
                        canvas.G.addEdge(Vec.P[0].id, segmentTrans.get_id());
                        canvas.G.addEdge(Vec.P[1].id, segmentTrans.get_id());
                    }
                }
                nb_click=0;
            }
        }
        if(mode.equals("droitepara"))
        {
            if (nb_click == 0) {
                D=null;init=null; pt2=null;
            }
            if (nb_click == 0) {
                for (forme p : canvas.get_formes()) {
                    if (p instanceof Droite) {
                        if (((Droite) p).isNear(x, y)) {D = (Droite) p;nb_click++;}
                    }
                }
            }
            else if (nb_click == 1)
            {
                init = this.assign(x, y, -1);
                if (init == null)
                {
                    init = new Pt(x, y, ++this.canvas.id_figure);
                    canvas.addForme(init);

                }
                pt2 = new Pt(x, y, ++this.canvas.id_figure);
                canvas.addForme(pt2);
                if (D != null) {

                    Dpara = new DroitePara(D, init,pt2, ++this.canvas.id_figure);
                    canvas.addForme(Dpara);
                    //System.out.println(D.P[0].id+" "+D.P[1].id+" "+init.get_id()+" "+Drperp.get_id());
                    canvas.G.addEdge(D.P[0].id, Dpara.get_id());
                    canvas.G.addEdge(D.P[1].id, Dpara.get_id());

                    canvas.G.addEdge(D.P[0].id, Dpara.P[0].get_id());
                    canvas.G.addEdge(D.P[0].id, Dpara.P[1].get_id());
                    canvas.G.addEdge(D.P[1].id, Dpara.P[0].get_id());
                    canvas.G.addEdge(D.P[1].id, Dpara.P[1].get_id());

                    canvas.G.addEdge(Dpara.P[0].get_id(), Dpara.get_id());
                    canvas.G.addEdge(Dpara.P[1].get_id(), Dpara.get_id());
                    System.out.print(canvas.G.toString());

                }
                nb_click=0;
            }
        }
        if(mode.equals("InterDroite")) {
            if (nb_click == 0) {
                D=null;D1=null;
            }
            if (nb_click == 0) {
                for (forme p : canvas.get_formes()) {
                    if (p instanceof Droite) {
                        if (((Droite) p).isNear(x, y)) {D = (Droite) p;nb_click++;}
                    }
                }
            }
            else if (nb_click == 1) {
                for (forme p : canvas.get_formes()) {
                    if (p instanceof Droite) {
                        if (((Droite) p).isNear(x, y)) D1 = (Droite) p;
                    }
                }
                if((D != null) && (D1 != null) && (!D.paralelle(D1))) {
                    //System.out.println("je cre un point d'intersection");
                    Pinter= new PtInterDroite(D, D1, ++this.canvas.id_figure);
                    System.out.println("x"+Pinter.getX()+" y:"+Pinter.getY());
                    canvas.addForme(Pinter);
                    canvas.G.addEdge(D.P[0].id,Pinter.id);
                    canvas.G.addEdge(D.P[1].id,Pinter.id);
                    canvas.G.addEdge(D1.P[0].id,Pinter.id);
                    canvas.G.addEdge(D1.P[1].id,Pinter.id);
                }
                nb_click=0;
            }
        }
        if(mode.equals("Mil"))
        {
            int nb_point_total=2;
            if(nb_click==0) {ptb=new Pt[nb_point_total]; }
            if(nb_click<nb_point_total)
            {
                System.out.println("je compte les points : "+nb_click);
                f=assign(x,y,-1);
                if(f==null) {ptb[nb_click]=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(ptb[nb_click]);}
                else {
                    ptb[nb_click]=(Pt)f;
                }
                nb_click+=1;
            }
            if(nb_click==nb_point_total) {
                Barycentre Bar=new Barycentre(ptb,nb_point_total,++this.canvas.id_figure);
                canvas.addForme(Bar);
                canvas.G.addEdge(Bar.P[0].get_id(), Bar.get_id());
                canvas.G.addEdge(Bar.P[1].get_id(), Bar.get_id());
                nb_click=0;}


        }
        if(mode.equals("Med"))
        {
            int nb_point_total=2;
            if(nb_click==0) {ptb=new Pt[nb_point_total]; }
            if(nb_click<nb_point_total)
            {
                System.out.println("je compte les points : "+nb_click);
                f=assign(x,y,-1);
                if(f==null) {ptb[nb_click]=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(ptb[nb_click]);}
                else {
                    ptb[nb_click]=(Pt)f;
                }
                nb_click+=1;
            }
            if(nb_click==nb_point_total) {
                Pt t1=new Pt(-10,10,++this.canvas.id_figure);
                canvas.addForme(t1);
                Pt t2=new Pt(-10,10,++this.canvas.id_figure);
                canvas.addForme(t2);
                Mediatrice med = new Mediatrice(ptb[0], ptb[1], t1, t2, ++this.canvas.id_figure);
                canvas.addForme(med);
                canvas.G.addEdge(ptb[0].get_id(), med.get_id());
                canvas.G.addEdge(ptb[1].get_id(), med.get_id());

                canvas.G.addEdge(ptb[0].get_id(),med.P[0].get_id());
                canvas.G.addEdge(ptb[0].get_id(),med.P[0].get_id());

                canvas.G.addEdge(ptb[1].get_id(), med.P[1].get_id());
                canvas.G.addEdge(ptb[1].get_id(),med.P[1].get_id());
                nb_click=0;}
        }
        if(mode.equals("Triangle"))
        {
            int nb_point_total=3;//demande
            if(nb_click==0)
            {
                ptb=new Pt[nb_point_total];
                f=assign(x,y,-1);
                if(f==null) {ptb[0]=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(ptb[0]);}
                else ptb[0]= (Pt) f;
                ptb[1]=new Pt(x,y,++this.canvas.id_figure);
                canvas.addForme(ptb[1]);
                ptb[2]=new Pt(x,y,++this.canvas.id_figure);
                canvas.addForme(ptb[2]);
                T=new Triangle(ptb,++this.canvas.id_figure);
                canvas.addForme(T);
                for(int i=0;i<nb_point_total;i++) {
                    canvas.G.addEdge(T.P[i].get_id(), T.get_id());
                }
                nb_click++;
            }
            else
            {
                if(nb_click<nb_point_total)
                {

                    f=assign(x,y,T.P[nb_click].get_id());
                    //erreur ici il prends l'indice de lautre point en mouvement
                    if(f==null) {ptb[nb_click].set_coord(x,y);}
                    else {
                        T.P[nb_click]=(Pt)f;
                        ptb[nb_click].set_coord(-1000,-100000);
                    }

                    System.out.println("jcheck  : "+nb_click+" "+ptb[nb_click].get_id());
                    nb_click+=1;
                }

                if(nb_click==nb_point_total) {

                nb_click=0;}
            }

        }
        if(mode.equals("Droite"))
        {
            init=assign(x,y,-1);
            if(init==null) {init=new Pt(x,y,++this.canvas.id_figure);canvas.addForme(init);}
            pt2=new Pt(x, y,++this.canvas.id_figure);
            canvas.addForme(pt2);
            D=new Droite(init,pt2,++canvas.id_figure);
            D.set_couleur(canvas.getColor());
            canvas.addForme(D);
        }
        if(mode.equals("Translate"))
        {
            init=new Pt(x,y);
            System.out.print("translate   " + num);
        }
        if(mode.equals("Deplacer"))
        {
            for(forme p:canvas.get_formes())
            {
                if (p instanceof Pt)
                {

                    boolean over=(((Pt) p).isNear(x, y)) ;
                    if(over && ((Pt) p).isMovable()) {
                        //System.out.print("jy suis");
                        num= p.get_id();
                        Bfs =new BreadthFirstPaths(canvas.G,((Pt) p).id);}

                }
            }
        }
    }

	
	@Override
    public void mouseDragged(MouseEvent evt) {
        int x = evt.getX();
        int y = evt.getY();


        if (mode.equals("Cercle"))
        {
             C.update_rayon(x,y);
        }
        if (mode.equals("Polyreg"))
        {
            pr.update(x, y, pt2.get_id());
        }
        if (mode.equals("Vecteur"))
        {
            Vec.update(x,y,pt2.get_id());
        }
        if (mode.equals("Rectangle"))
        {
            R.update(x,y,pt2.get_id());
        }
        if (mode.equals("Droite"))
        {
            D.update(x,y,pt2.get_id());
        }
        if (mode.equals("Segment")) {
            Seg.update(x, y, pt2.get_id());
        }

        canvas.repaint();
        if(mode.equals("Translate"))
        {
            for(forme p:canvas.get_formes())
            {
                if (p instanceof Pt)
                {
                    ((Pt) p).set_coord(((Pt) p).getX()+(x-init.getX()), ((Pt) p).getY()+(y-init.getY()));
                    for (forme f : canvas.get_formes()) {
                        f.update(((Pt) p).getX(), ((Pt) p).getY(), ((Pt) p).get_id());
                    }

                }
                if(p instanceof Repere)
                    p.update(((Pt) canvas.get_formes().get(0)).getX(), ((Pt) canvas.get_formes().get(0)).getY(), -1);
            }
            canvas.repaint();
            init.set_coord(x,y);
        }
        if(mode.equals("Deplacer"))
        {
            for(forme p:canvas.get_formes())
            {

                if (p instanceof Pt)
                {
                    if (((Pt) p).id==num  && ((Pt) p).isMovable()){
                        //System.out.println("je suis un point mobile :"+((Pt) p).id);
                        if(p instanceof PtCercle) ((PtCercle) p).updatepos(x,y);
                        else if (p instanceof PtDroite) ((PtDroite) p).updatepos(x,y);
                        else if (p instanceof PtSegment) ((PtSegment) p).updatepos(x,y);
                        else ((Pt) p).set_coord(x, y);


                        System.out.println(Bfs.path().toString());
                        for(LinkedList<Integer>a:Bfs.path())
                        {
                            forme obj=canvas.get_formes().get(a.get(1));
                            Pt init=(Pt)canvas.get_formes().get(a.get(0));

                            //System.out.println("Je dois update "+obj.get_id()+" avec "+a.get(0));
                            obj.update(init.getX(),init.getY(),a.get(0));

                        }

                        canvas.repaint();

                    }
                }

            }
            canvas.repaint();

        }

    }
	@Override
	public void mouseReleased(MouseEvent evt) {
		//forme f=null;
        int x = evt.getX();
        int y = evt.getY();

        if (mode.equals("Cercle"))
        {
                        f=assign (x,y,pt2.get_id());
                        if(f!=null)
                        {
                            C.P[1]=(Pt)f;
                            pt2.set_coord(-10,-10);
                        }
                        //else C.update(x,y,pt2.get_id());
                        canvas.G.addEdge(C.P[0].get_id(),C.get_id());
                        canvas.G.addEdge(C.P[1].get_id(),C.get_id());
                        canvas.G.addEdge(C.P[0].get_id(),C.P[1].get_id());
                        canvas.G.addEdge(C.P[1].get_id(),C.P[0].get_id());
                        //System.out.println("lien entre "+C.P[0].get_id()+" , "+ C.P[1].get_id()+" et "+C.get_id());
        }
        if (mode.equals("Rectangle"))
        {
            f=assign (x,y,pt2.get_id());
            if(f!=null)
            {
                R.P[1]=(Pt)f;
                pt2.set_coord(-10,-10);
            }
            //else C.update(x,y,pt2.get_id());
            canvas.G.addEdge(R.P[0].get_id(), R.get_id());
            canvas.G.addEdge(R.P[1].get_id(), R.get_id());
            //System.out.println("lien entre " + R.P[0].get_id() + " , " + R.P[1].get_id() + " et " + R.get_id());
        }
        if (mode.equals("Segment"))
        {
            f=assign (x,y,pt2.get_id());
            if(f!=null)
            {
                Seg.P[1]=(Pt)f;
                pt2.set_coord(-10,-10);
            }
            //else C.update(x,y,pt2.get_id());
            canvas.G.addEdge(Seg.P[0].get_id(), Seg.get_id());
            canvas.G.addEdge(Seg.P[1].get_id(), Seg.get_id());
            System.out.println("lien entre " + Seg.P[0].get_id() + " , " + Seg.P[1].get_id() + " et " + Seg.get_id());
        }
        if (mode.equals("Polyreg"))
        {
            f=assign (x,y,pt2.get_id());
            if(f!=null)
            {
                pr.P[1] = (Pt) f;
                pt2.set_coord(-10,-10);
            }
            //else C.update(x,y,pt2.get_id());
            canvas.G.addEdge(init.get_id(), pr.get_id());
            canvas.G.addEdge(pt2.get_id(), pr.get_id());
           // System.out.println("lien entre " + Seg.P[0].get_id() + " , " + Seg.P[1].get_id() + " et " + Seg.get_id());
        }
        if (mode.equals("Vecteur"))
        {
            f=assign (x,y,pt2.get_id());
            if(f!=null)
            {
                Vec.P[1]=(Pt)f;
                pt2.set_coord(-10,-10);
            }
            //else C.update(x,y,pt2.get_id());
            canvas.G.addEdge(Vec.P[0].get_id(), Vec.get_id());
            canvas.G.addEdge(Vec.P[1].get_id(), Vec.get_id());
        }
        if (mode.equals("Droite"))
        {
            f=assign (x,y,pt2.get_id());
            if(f!=null)
            {
                D.P[1]=(Pt)f;
                pt2.set_coord(-10,-10);
            }
            //else C.update(x,y,pt2.get_id());
            canvas.G.addEdge(D.P[0].get_id(), D.get_id());
            canvas.G.addEdge(D.P[1].get_id(), D.get_id());
            System.out.println("lien entre " + D.P[0].get_id() + " , " + D.P[1].get_id() + " et " + D.get_id());
        }
         num=-1;

        canvas.repaint();

	}
	
	@Override
	public void mouseMoved(MouseEvent evt) {
		int x = evt.getX();
        int y = evt.getY();

        for( forme f:canvas.get_formes())
        {
            if(f instanceof Cercle){ if(((Cercle) f).isNear(x,y)) {}}
            if(f instanceof Droite){ if(((Droite) f).isNear(x,y)) {}}
            if(f instanceof Segment){ if(((Segment) f).isNear(x,y)) {}}
            if (f instanceof PolyRegulier) {
                if (((PolyRegulier) f).isNear(x, y)) {
                }
            }
        }



        if (mode.equals("Triangle"))
        {
            if(nb_click==1) T.update1(x, y);
            if(nb_click==2) T.update2(x, y);
        }
        canvas.repaint();
	}
@Override
	public void mouseEntered(MouseEvent arg0) {


	}

	@Override
	public void mouseExited(MouseEvent arg0) {


	}

	

}
