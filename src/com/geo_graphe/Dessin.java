package com.geo_graphe;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;

/**
 * Classe Principale du projet contenant le main
 */
public class Dessin {
	/**
	 * Création de la Frame
	 */
	private JFrame frame;
	/**
	 * MyCanvas
     */
	protected MyCanvas Canvas;
	/**
	 * Menu
     */
	protected Menu menu;
	/**
	 * m un écouteur d'événement de la souris
     */
	MyMouseListener m;

	/**
	 * Lance l'application
	 * @param args Les arguments entrant
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dessin window = new Dessin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

	/**
	 * Crée l'application
     */
	public Dessin() {
		initialize();
	}

	/**
	 * Initialise le contenu de la frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dessin Vectoriel");
		
		Canvas = new MyCanvas();
		frame.getContentPane().add(Canvas);


		frame.setJMenuBar(new Menu(Canvas));
		m= new MyMouseListener(Canvas);
		frame.pack();
		//frame.getContentPane().add(menu, BorderLayout.NORTH);		
	}
	
	

}
