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
 * Created by nahor on 22/12/14.
 */
public class MenuVertical extends JFrame implements ActionListener {

    protected MyCanvas canvas;
    /**
     * The constant nbcote.
     */
    protected static int nbcote=0;
    /**
     * The M.
     */
    MyMouseListener m;




    public MenuVertical(MyCanvas canvas) {
        super();
        this.canvas=canvas;
        initUI();

    }





    public final void initUI() {
        JToolBar toolbar1 = new JToolBar();

        ImageIcon newi = new ImageIcon("/images/new.png","new");
        ImageIcon open = new ImageIcon("images/open.png","open");
        ImageIcon save = new ImageIcon("save.png","save");
        ImageIcon exit = new ImageIcon("exit.png","exit");

        JButton newb = new JButton(newi);
        JButton openb = new JButton(open);
        JButton saveb = new JButton(save);
        JButton exitb = new JButton(exit);

        toolbar1.add(newb);
        toolbar1.add(openb);
        toolbar1.add(saveb);
        toolbar1.add(exitb);

        exitb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });
        toolbar1.setVisible(true);
        add(toolbar1);

    }

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
