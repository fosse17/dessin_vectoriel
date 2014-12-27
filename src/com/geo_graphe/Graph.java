package com.geo_graphe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

class Graph {
    LinkedList<Integer>[] adj;
    private int V;
    private int E;

    /**
     * Creation d'un graphe vide avec V sommets sans aretes
     * param V le nombre de sommets
     *
     * @throws java.lang.IllegalArgumentException
     *          si <tt>V</tt> < 0
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Le nombre d'aretes ne peut pas être negatif.");
        if (V < 0) throw new IllegalArgumentException("Le nombre d'aretes ne peut pas être negatif.");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[10000000];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    /**
     * Initialisation d'un graphe suivant un fichier au format pfg
     *
     * @throws java.lang.IndexOutOfBoundsException
     * @throws java.lang.IllegalArgumentException
     */
    public Graph(String s) {

        int num_ligne = 0;

        LinkedList<String> arete = new LinkedList<String>();

        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(s));
            while ((ligne = fichier.readLine()) != null) {
                num_ligne += 1;
                if (num_ligne == 1) this.V = Integer.parseInt(ligne);
                else arete.add(ligne);
            }
            System.out.print(this.V);
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(arete.toString());
        //creation des listes d'adjacences
        adj = (LinkedList<Integer>[]) new LinkedList[100000000];
        for (int v = 0; v < this.V; v++) {
            adj[v] = new LinkedList<Integer>();
        }

        System.out.print("eeee" + arete.size());
        //remplissage des listes d'adjacences
        for (int i = 0; i < arete.size(); i++) {

            String[] tab = new String[2];
            tab = (arete.get(i)).split(",");
            System.out.print(tab[0] + " " + tab[1]);
            this.addEdge(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]));
        }

        System.out.println(this.toString());
    }

    public void add_vertex()
    {

        adj[this.V]=new LinkedList<Integer>();
        this.V++;

    }

    public void save(String url) {
        try {
            PrintWriter fichier = new PrintWriter(new FileWriter(url));

            fichier.println(this.V);
            for (int v = 0; v < this.V; v++) {
                for (int w : adj[v]) {
                    fichier.println(v + "," + w);
                }
            }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Retourne le nombre de sommet du graphe
     *
     * @return le nombre de sommet du graphe
     */
    public int V() {
        return V;
    }

    /**
     * Retourne le nombre d'arretes du graphe
     *
     * @return le nombre d'arretes du graphe
     */
    public int E() {
        return E;
    }

    /**
     * Valide la creation d'un sommet
     *
     * @throws IndexOutOfBoundsException
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("le sommet " + v + " n'est pas entre 0 et " + (V - 1));
    }

    /**
     * ajoute une arete au graphe.
     *
     * @param v un sommet
     * @param w un autre sommet
     * @throws java.lang.IndexOutOfBoundsException
     *
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
    }


    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Retourne un affichage du graphe.
     *
     * @return un affichage du graphe sous forme de String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " sommets, " + E + " aretes " + NEWLINE);
        for (int v = 0; v < this.V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


}
