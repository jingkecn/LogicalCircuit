package tools;

import java.io.*;

/*
 * Classe pour la lecture et l'ecriture de fichiers texte.
 */
public class FileHandler {
    private static BufferedReader in = null;

    /*
     * La methode lit un fichier texte et
     * renvoie un tableau de String renfermant
     * les lignes du fichier.
     */
    public String[] extract(String fic) {
        String line;
        String[] temp = new String[10000];
        int n = 0;
        try {
            in = new BufferedReader(new FileReader(fic));
            while ((line = in.readLine()) != null) {
                if (!line.equals("")) temp[n++] = line;
            }
            String[] res = new String[n];
            for (int i = 0; i < n; i++) res[i] = temp[i];
            return res;
        } catch (IOException e) {
            System.out.println("Cannot read file " + fic);
            return null;
        }
    }
    /*
     * La methode ecrit un tableau de String dans un fichier texte.
	 */


    public void write(String filename, String[] tab) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));//append
            for (int i = 0; i < tab.length; i++)
                out.println(tab[i]);
            out.close();
        } catch (IOException e) {
            System.out.println("Cannot write file " + filename);
        }
    }

    public void clear(String filename) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)));
            out.print("");
            out.close();
        } catch (IOException e) {
            System.out.println("Cannot clear file " + filename);
        }
    }
}
