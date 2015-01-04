package com.geo_graphe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

/**
 * The type Menu.
 */
public class Menu extends JMenuBar implements ActionListener{

    /**
     * The constant nbcote.
     */
    protected static int nbcote=0;
    protected static int nb_point_bary = 0;
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
        JMenu mfichier = new JMenu("Fichier");
        this.add(mfichier);

        JMenuItem mnew = new JMenuItem("Nouveau");
        mnew.addActionListener(this);
        mfichier.add(mnew);

        JMenuItem mopen = new JMenuItem("Ouvrir");
        mopen.addActionListener(this);
        mfichier.add(mopen);

        JMenuItem msauve = new JMenuItem("Enregistrer");
        msauve.addActionListener(this);
        mfichier.add(msauve);

        JMenuItem msauve2 = new JMenuItem("Enregistrer sous");
        msauve2.addActionListener(this);
        mfichier.add(msauve2);

        JMenuItem mimprim = new JMenuItem("Imprimer");
        mimprim.addActionListener(this);
        mfichier.add(mimprim);


        JMenu mdessiner = new JMenu("Dessiner");
		this.add(mdessiner);

        JMenuItem mrectangl = new JMenuItem("Rectangle");
		mrectangl.addActionListener(this);
		mdessiner.add(mrectangl);

        JMenuItem mbary = new JMenuItem("Barycentre");
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

        JMenuItem mpoly = new JMenuItem("Polygone");
        mpoly.setActionCommand("Poly");//penser a utiliser les action commande pour les autres partie du menu
        mpoly.addActionListener(this);
        mdessiner.add(mpoly);

        JMenuItem mpolyindef = new JMenuItem("Polygone indeformable");
        mpolyindef.setActionCommand("Polyindef");//penser a utiliser les action commande pour les autres partie du menu
        mpolyindef.addActionListener(this);
        mdessiner.add(mpolyindef);

        JMenuItem mcercle = new JMenuItem("Cercle");
		mcercle.addActionListener(this);
		mdessiner.add(mcercle);

        JMenuItem mtexte = new JMenuItem("Texte");
        mtexte.addActionListener(this);
        mdessiner.add(mtexte);

        JMenuItem mpolyreg = new JMenuItem("Polyreg");
        mpolyreg.addActionListener(this);
        mdessiner.add(mpolyreg);

        JMenuItem mtranscercle = new JMenuItem("Translation");
        mtranscercle.addActionListener(this);
        mdessiner.add(mtranscercle);

        JMenuItem msymcentrale = new JMenuItem("Symétrie Centrale");
        msymcentrale.setActionCommand("Symcentrale");
        msymcentrale.addActionListener(this);
        mdessiner.add(msymcentrale);

        JMenuItem msymaxiale = new JMenuItem("Symétrie Axiale");
        msymaxiale.setActionCommand("Symaxiale");
        msymaxiale.addActionListener(this);
        mdessiner.add(msymaxiale);

        JMenuItem mlagrange = new JMenuItem("Lagrange");
        mlagrange.setActionCommand("lagrange");
        mlagrange.addActionListener(this);
        mdessiner.add(mlagrange);

        JMenuItem msegment = new JMenuItem("Segment");
		msegment.addActionListener(this);
		mdessiner.add(msegment);

        JMenuItem mvecteur = new JMenuItem("Vecteur");
        mvecteur.addActionListener(this);
        mdessiner.add(mvecteur);

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

        /*JMenuItem mprint = new JMenuItem("Print");
        mprint.addActionListener(this);
        this.add(mprint);

        JMenuItem msave = new JMenuItem("Save");
        msave.addActionListener(this);
        this.add(msave);*/

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
        /*maction.add(mprint);
        maction.add(msave);*/
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
        if(e.getActionCommand()=="Imprimer")
        {
            canvas.do_print();
        }
        if (e.getActionCommand() == "Nouveau") {
            canvas.clear();
        }
        if (e.getActionCommand() == "B3") {
            nb_point_bary = Integer.parseInt(JOptionPane.showInputDialog("nombre de points:"));
        }
        if (e.getActionCommand() == "Polyreg") {
            String tt = JOptionPane.showInputDialog("nombre de cotés:");
            nbcote=Integer.parseInt(tt);

        }
        if (e.getActionCommand() == "Enregistrer") {
            try {
                FileDialog fd = new FileDialog((Frame) null, "Enregistrement", FileDialog.SAVE);
                fd.setDirectory("./");
                fd.setFile("*.geo");
                fd.setFilenameFilter(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return (name.endsWith(".geo"));
                    }
                });
                fd.setLocation(50, 50);
                fd.setVisible(true);
                String st = fd.getDirectory() +
                        System.getProperty("file.separator") + fd.getFile();
                FileOutputStream fos = new FileOutputStream(st);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(canvas.get_formes());
                oos.flush();
                oos.close();
                fos.close();
                canvas.G.save(st + ".grp");
            } catch (Exception ex) {
                System.out.println("");
            }
        }
        if (e.getActionCommand() == "Ouvrir") {

            try {
                FileDialog fileDialog = new FileDialog((Frame) null, "Choississez votre fichier", FileDialog.LOAD);

                fileDialog.setFilenameFilter(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return (name.endsWith(".geo"));
                    }
                });
                fileDialog.setDirectory("./");
                fileDialog.setLocation(50, 50);
                fileDialog.setVisible(true);
                String st = fileDialog.getDirectory() + fileDialog.getFile();
                ObjectInputStream oi = new ObjectInputStream(new FileInputStream(st));
                Object o = oi.readObject();
                canvas.formes = (LinkedList<forme>) o;
                oi.close();
                canvas.G = new Graph(st + ".grp");
                canvas.G.toString();
                canvas.id_figure = canvas.G.V() - 1;
                canvas.repaint();
            } catch (Exception exc) {
            }
        }

	}


}
