package com.geo_graphe;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;

public class Dessin {

	private JFrame frame;
	protected MyCanvas Canvas;
	protected Menu menu;
	MyMouseListener m;
	
	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public Dessin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("dessin vectoriel");
		
		Canvas = new MyCanvas();
		frame.getContentPane().add(Canvas);


		frame.setJMenuBar(new Menu(Canvas));
		m= new MyMouseListener(Canvas);
		frame.pack();
		//frame.getContentPane().add(menu, BorderLayout.NORTH);		
	}
	
	

}
