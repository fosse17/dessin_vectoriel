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
public class MenuVertical extends JToolBar implements ActionListener{

    /**
     * The Canvas.
     */
    protected MyCanvas canvas;
    /**
     * The constant nbcote.
     */
    protected static int nbcote=0;
    /**
     * The M.
     */
    MyMouseListener m;

    private JToolBar toolBar;


    /**
     * Create the panel.
     * @param canvas the canvas
     */
    public MenuVertical(MyCanvas canvas) {
        super();
        this.canvas=canvas;
        init();

    }


    /**
     * Init void.
     */
    public void init() {

        ImageIcon point = new ImageIcon("/images/icones_geogebra/b1.png");
        ImageIcon droite = new ImageIcon("/images/icones_geogebra/b4.png");
        ImageIcon segment = new ImageIcon("/images/icones_geogebra/b5.png");
        ImageIcon triangle = new ImageIcon("/images/icones_geogebra/b10.png");
        ImageIcon cercle = new ImageIcon("/images/icones_geogebra/d1.png");
        ImageIcon mediatrice = new ImageIcon("/images/icones_geogebra/c3.png");
        ImageIcon texte = new ImageIcon("/images/icones_geogebra/g1.png");
        ImageIcon zoom1 = new ImageIcon("/images/icones_geogebra/h2.png");
        ImageIcon zoom2 = new ImageIcon("/images/icones_geogebra/j3.png");

        JButton pointButton = new JButton(point);
        JButton droiteButton = new JButton(droite);
        JButton segmentButton = new JButton(segment);
        JButton triangleButton = new JButton(triangle);
        JButton cercleButton = new JButton(cercle);
        JButton mediatriceButton = new JButton(mediatrice);
        JButton texteButton = new JButton(texte);
        JButton zoom1Button = new JButton(zoom1);
        JButton zoom2Button = new JButton(zoom2);


        toolBar.add(pointButton);
        toolBar.add(droiteButton);
        toolBar.add(segmentButton);
        toolBar.add(triangleButton);
        toolBar.add(cercleButton);
        toolBar.add(mediatriceButton);
        toolBar.add(texteButton);
        toolBar.add(zoom1Button);
        toolBar.add(zoom2Button);

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
        if (e.getActionCommand() == "Polyreg") {
            String tt = JOptionPane.showInputDialog("nombre de cotés:");
            nbcote=Integer.parseInt(tt);

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
