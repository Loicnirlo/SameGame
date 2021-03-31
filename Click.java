import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import javax.swing.border.*;
import java.applet.Applet;
import java.awt.event.*;

public class Click implements MouseListener{

  public int awx;
  public int awy;
  JLabel[][] grille;
  String[][] RVBgrille;

  ArrayList<Integer> xList;
  ArrayList<Integer> yList;

  int cptN;
  int colfullnull;

  Virus v;

  ImageIcon imageRED = new ImageIcon(getClass().getResource("apple_food_fruit_icon_182561.png"));
  ImageIcon imageGREEN = new ImageIcon(getClass().getResource("coconut_food_fruit_icon_182573.png"));
  ImageIcon imageBLUE =  new ImageIcon(getClass().getResource("food_fruit_grape_icon_182560.png"));


  public Click(JLabel[][] grid, String[][] RVBgrid){
    this.grille = grid;
    RVBgrille = RVBgrid;
    cptN = 0;
  }
  @Override
  public void mouseEntered(MouseEvent e) {
    Component c = e.getComponent();
    c.setBackground(Color.orange);
    JLabel b = (JLabel)e.getSource();
    Rectangle r = b.getBounds();
    Point p = b.getLocation();
    int row = p.y / r.height;
    int col = p.x / r.width;
    System.out.println("cell "+row+col);
    int cpt = 0;
    v = new Virus(grille, RVBgrille, row, col);
    v.regroup(row,col, cpt);
    v.colorationRed();
    xList = v.getXlist();
    yList = v.getYlist();
  }

  @Override
  public void mouseExited(MouseEvent e) {
    Component c = e.getComponent();
    c.setBackground(new Color(238,238,238));
    JLabel b = (JLabel)e.getSource();
    Rectangle r = b.getBounds();
    Point p = b.getLocation();
    int row = p.y / r.height;
    int col = p.x / r.width;
    System.out.println("cell "+row+col);
    int cpt = 0;
    v = new Virus(grille, RVBgrille, row, col);
    v.regroup(row,col, cpt);
    v.colorationWhite();

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int taille = xList.size();
    for(int z=0; z<taille;z++){
      int a = xList.get(z);
      int b = yList.get(z);
      RVBgrille[a][b]="N";
      cptN++;
    }

    for (int b=0; b<10;b++ ) {
      refresh();
      VerticalReplace();
    }
    v.colorationWhite();
    //HorizontalReplace();
    EmptyColomnDetector();
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  public void refresh(){

    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 15; j++){

        if(RVBgrille[i][j] == "R"){
          grille[i][j].setIcon(imageRED);
        }
        if(RVBgrille[i][j] == "V"){
          grille[i][j].setIcon(imageGREEN);
        }
        if(RVBgrille[i][j] == "B"){
          grille[i][j].setIcon(imageBLUE);
        }
        if(RVBgrille[i][j] == "N"){
          grille[i][j].setIcon(null);
        }
      }
    }
  }
  public void VerticalReplace(){
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 15; j++){

        if(RVBgrille[i][j] == "R"){
          if(RVBgrille[i+1][j] == "N"){
            grille[i][j].setIcon(null);
            grille[i+1][j].setIcon(imageRED);
            RVBgrille[i][j] = "N";
            RVBgrille[i+1][j] = "R";
         }
        }

        if(RVBgrille[i][j] == "V"){
          if(RVBgrille[i+1][j] == "N"){
            grille[i][j].setIcon(null);
            grille[i+1][j].setIcon(imageGREEN);
            RVBgrille[i][j] = "N";
            RVBgrille[i+1][j] = "V";
         }
        }

        if(RVBgrille[i][j] == "B"){
          if(RVBgrille[i+1][j] == "N"){
            grille[i][j].setIcon(null);
            grille[i+1][j].setIcon(imageBLUE);
            RVBgrille[i][j] = "N";
            RVBgrille[i+1][j] = "B";
         }
        }

      }
    }
  }

  public void EmptyColomnDetector(){
    for (int i=0; i<15; i++) {
      if (RVBgrille[0][i] == "N") {
        int cptVN = 0;
        for (int j=0; j<10; j++) {
          if(RVBgrille[j][i] == "N"){
            cptVN++;
          }
        }
        if (cptVN == 10) {
          colfullnull = i;
          System.out.println("colonne vide ! c'est la "+colfullnull);
          HorizontalReplace(colfullnull);
        }
      }
    }
  }
  public void HorizontalReplace(int colfullnull){
    int n = 0;
    int c = 0;
    int colnull = 0;

    while(colfullnull < 14){
        for (int j=0; j<10; j++){
          if(RVBgrille[j][colfullnull+1] == "R"){

              grille[j][colfullnull+1].setIcon(null);
              grille[j][colfullnull].setIcon(imageRED);
              RVBgrille[j][colfullnull+1] = "N";
              RVBgrille[j][colfullnull] = "R";

          }

          if(RVBgrille[j][colfullnull+1] == "V"){

              grille[j][colfullnull+1].setIcon(null);
              grille[j][colfullnull].setIcon(imageGREEN);
              RVBgrille[j][colfullnull+1] = "N";
              RVBgrille[j][colfullnull] = "V";

          }

          if(RVBgrille[j][colfullnull+1] == "B"){

              grille[j][colfullnull+1].setIcon(null);
              grille[j][colfullnull].setIcon(imageBLUE);
              RVBgrille[j][colfullnull+1] = "N";
              RVBgrille[j][colfullnull] = "B";

          }
        }
        colfullnull++;
      }





    }
  }
