import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import javax.swing.border.*;
import java.applet.Applet;

public class Virus {
  int a = 0;
  int b = 0;
  boolean find = true;
  //int[] tabX = new int[150];
  //int[] tabY = new int[150];

  JLabel[][] grid;
  String[][] rvb_grid;
  ArrayList<Integer> xList;
  ArrayList<Integer> yList;

  //int cpt = 0;

  public Virus(JLabel[][] grid, String[][] RVBgrid, int row, int col){
    this.grid = grid;
    this.rvb_grid = RVBgrid;

    xList = new ArrayList<Integer>();
    yList = new ArrayList<Integer>();

    xList.add(row);
    yList.add(col);
  }

  public void regroup(int a, int b, int cpt){
    Hdroite(a, b, cpt);
    Hgauche(a, b, cpt);
    Vbas(a, b, cpt);
    Vhaut(a, b, cpt);
  }

  public boolean verification(int a, int b){
    int taille = xList.size();
    int z;

    boolean verif = false;
    for(z=0; z<taille;z++){
      int o = xList.get(z);
      int p = yList.get(z);
      if (o == a && p == b) {
        verif = true;
      }
    }
    z=0;
    return verif;
  }

  public void Hdroite(int a, int b, int cpt){

      if (b+1 <= 14 && rvb_grid[a][b] == rvb_grid[a][b+1] && verification(a, b+1)==false) {
        System.out.println("ajout HD");
        System.out.println(a+" "+(b+1));
        xList.add(a);
        yList.add(b+1);
        regroup(a, b+1, cpt);
      }

  }

  public void Hgauche(int a, int b, int cpt){

      if (b-1 >= 0 && rvb_grid[a][b] == rvb_grid[a][b-1] && verification(a, b-1)==false) {
        System.out.println("ajout HG");
        System.out.println(a+" "+(b-1));
        xList.add(a);
        yList.add(b-1);
        regroup(a, b-1, cpt);
      }

  }

  public void Vbas(int a, int b, int cpt){

      if (a-1 >= 0 && rvb_grid[a][b] == rvb_grid[a-1][b] && verification(a-1, b)==false) {
        System.out.println("ajout VB");
        System.out.println((a-1)+" "+b);
        xList.add(a-1);
        yList.add(b);
        regroup(a-1, b, cpt);
      }

  }

  public void Vhaut(int a, int b, int cpt){

      if (a+1 <= 9 && rvb_grid[a][b] == rvb_grid[a+1][b] && verification(a+1, b)==false) {
        System.out.println("ajout VH");
        System.out.println((a+1)+" "+b);
        xList.add(a+1);
        yList.add(b);
        regroup(a+1, b, cpt);
      }

  }


  public void colorationRed(){
    int taille = xList.size();
    for(int z=0; z<taille;z++){
      int a = xList.get(z);
      int b = yList.get(z);
      if (rvb_grid[a][b] != "N") {
        grid[a][b].setBackground(Color.ORANGE);
      }
    }
  }
  public void colorationWhite(){
    int taille = xList.size();
    for(int z=0; z<taille;z++){
      int a = xList.get(z);
      int b = yList.get(z);
      grid[a][b].setBackground(new Color(238,238,238));
    }
  }
  public ArrayList<Integer> getXlist(){
    return xList;
  }
  public ArrayList<Integer> getYlist(){
    return yList;
  }
}
