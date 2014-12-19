package com.geo_graphe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 * The type Menu.
 */
public class Menu extends JMenuBar implements ActionListener{

    /**
     * The Canvas.
     */
    protected MyCanvas canvas;
    /**
     * The M.
     */
    MyMouseListener m;

    private JMenuBar menuBar;


    /**
     * Create the panel.
     * @param canvas the canvas
     */
    public Menu(MyCanvas canvas) {
        super();
        this.canvas=canvas;
		init();
		
	}


    /**
     * Init void.
     */
    public void init() {

        JMenu mdessiner = new JMenu("Dessiner");
		this.add(mdessiner);

        JMenuItem mrectangl = new JMenuItem("Rectangle");
		mrectangl.addActionListener(this);
		mdessiner.add(mrectangl);

        JMenuItem mbary = new JMenuItem("Barycentre3");
        mbary.setActionCommand("B3");//penser a utiliser les action commande pour les autres partie du menu
        mbary.addActionListener(this);
        mdessiner.add(mbary);

        JMenuItem mMed = new JMenuItem("Mediatrice");
        mMed.setActionCommand("Med");//penser a utiliser les action commande pour les autres partie du menu
        mMed.addActionListener(this);
        mdessiner.add(mMed);

        JMenuItem mmil = new JMenuItem("Milieu");
        mmil.setActionCommand("Mil");//penser a utiliser les action commande pour les autres partie du menu
        mmil.addActionListener(this);
        mdessiner.add(mmil);

        JMenuItem mcercle = new JMenuItem("Cercle");
		mcercle.addActionListener(this);
		mdessiner.add(mcercle);

        JMenuItem msegment = new JMenuItem("Segment");
		msegment.addActionListener(this);
		mdessiner.add(msegment);

        JMenuItem mdroite = new JMenuItem("Droite");
        mdroite.addActionListener(this);
        mdessiner.add(mdroite);

        JMenuItem mpoint = new JMenuItem("Point");
		mpoint.addActionListener(this);
		mdessiner.add(mpoint);

        JMenuItem mtriangle = new JMenuItem("Triangle");
        mtriangle.addActionListener(this);
        mdessiner.add(mtriangle);


        JMenuItem mptcercle = new JMenuItem("Ptcercle");
        mptcercle.addActionListener(this);
        mdessiner.add(mptcercle);

        JMenuItem mptdroite = new JMenuItem("Ptdroite");
        mptdroite.addActionListener(this);
        mdessiner.add(mptdroite);

        JMenuItem mptdroiteperp = new JMenuItem("droiteperp");
        mptdroiteperp.addActionListener(this);
        mdessiner.add(mptdroiteperp);

        JMenuItem mptdroitepara = new JMenuItem("droitepara");
        mptdroitepara.addActionListener(this);
        mdessiner.add(mptdroitepara);

        JMenuItem mpttann = new JMenuItem("tangente");
        mpttann.addActionListener(this);
        mdessiner.add(mpttann);

        JMenuItem mptinterdroite = new JMenuItem("InterDroite");
        mptinterdroite.addActionListener(this);
        mdessiner.add(mptinterdroite);

        JMenuItem mptsegment = new JMenuItem("PtSegment");
        mptsegment.addActionListener(this);
        mdessiner.add(mptsegment);

        JMenu maction = new JMenu("action");
        JMenuItem mdeplacer = new JMenuItem("Deplacer");
		mdeplacer.addActionListener(this);

        JMenuItem mzoomplus = new JMenuItem("Zoom+");
        mzoomplus.addActionListener(this);
        this.add(maction);

        JMenuItem mzoommoins = new JMenuItem("Zoom-");
        mzoommoins.addActionListener(this);
		this.add(maction);

        JMenuItem mtranslate = new JMenuItem("Translate");
        mtranslate.addActionListener(this);
        this.add(maction);

        JMenuItem mcolor = new JMenuItem("Color");
        mcolor.addActionListener(this);
        this.add(maction);

        JMenuItem mprint = new JMenuItem("Print");
        mprint.addActionListener(this);
        this.add(mprint);

        JMenuItem msave = new JMenuItem("Save");
        msave.addActionListener(this);
        this.add(msave);

        JMenuItem mclear = new JMenuItem("Clear");
        mclear.addActionListener(this);
        this.add(mclear);

        JMenuItem mrestore = new JMenuItem("Restore");
        mrestore.addActionListener(this);
        this.add(mrestore);

        maction.add(mdeplacer);
        maction.add(mzoomplus);
        maction.add(mzoommoins);
        maction.add(mtranslate);
        maction.add(mcolor);
        maction.add(mprint);
        maction.add(msave);
        maction.add(mclear);
        maction.add(mrestore);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		canvas.setMode(e.getActionCommand());
        if (e.getActionCommand().equals("Color"))
        {
            Color C =JColorChooser.showDialog(canvas,
                "choix de la couleur", Color.BLACK);
            canvas.setColor(C);
            //canvas.repaint();
        }

        if(e.getActionCommand()=="Zoom+")
        {
            canvas.Zoom(1.2);
            canvas.repaint();
        }
        if(e.getActionCommand()=="Zoom-")
        {
            canvas.Zoom(0.8);
            canvas.repaint();
        }
        if(e.getActionCommand()=="Print")
        {
            canvas.do_print();
        }
        if (e.getActionCommand() == "Clear") {
            canvas.clear();
        }

        if (e.getActionCommand() == "Save") {
            try {
                FileOutputStream fos = new FileOutputStream("figure.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(canvas.get_formes());
                oos.flush();
                oos.close();
                fos.close();
                canvas.G.save("graphe.txt");
            } catch (Exception ex) {
                System.out.println("");
            }
        }
        if (e.getActionCommand() == "Restore") {
            forme f;
            try {
                ObjectInputStream oi = new ObjectInputStream(new FileInputStream("figure.txt"));
                Object o = oi.readObject();
                canvas.formes = (LinkedList<forme>) o;
                oi.close();
                canvas.G = new Graph("graphe.txt");
                canvas.G.toString();
                canvas.id_figure = canvas.G.V();
                canvas.repaint();
            } catch (Exception exc) {
            }
        }

	}


}
