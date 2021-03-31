import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import javax.swing.border.*;
import java.applet.Applet;
import java.awt.event.*;

public class Grid extends JFrame{

  int row;
  int col;
  JLabel[][] grid;
  JFrame fenetre1 = new JFrame();
  JPanel panel = new JPanel();
  JPanel panel2 = new JPanel();

  String[][] rvb_grid;
  String[] color = {"R", "V", "B"};

  ImageIcon imageRED = new ImageIcon(getClass().getResource("apple_food_fruit_icon_182561.png"));
  ImageIcon imageGREEN = new ImageIcon(getClass().getResource("coconut_food_fruit_icon_182573.png"));
  ImageIcon imageBLUE =  new ImageIcon(getClass().getResource("food_fruit_grape_icon_182560.png"));

  int posX;
  int posY;


  public Grid(int nblig, int nbcol) {

    row = nblig;
    col = nbcol;
    grid = new JLabel[row][col];
    rvb_grid = new String[10][15];

    JLabel bouton = new JLabel("score", SwingConstants.CENTER);
    bouton.setPreferredSize(new Dimension(250,100));
    panel2.add(bouton);
    panel2.setBackground(Color.WHITE);
    fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //fenetre1.setBounds(100, 100, col*50, row*52);
    panel.setLayout(new GridLayout(row, col));
    fenetre1.setResizable(false);
    fenetre1.add(panel, BorderLayout.WEST);
    fenetre1.add(panel2, BorderLayout.EAST);
    FillCase c = new FillCase();
    rvb_grid = c.RVBgridFill();
  }

  public void FillGrid(){

    Click click = new Click(grid,rvb_grid);

    for (int i = 0; i < row; i++){
      for (int j = 0; j < col; j++){
          grid[i][j] = new JLabel();
          grid[i][j].setBorder(new LineBorder(Color.WHITE));
          grid[i][j].setOpaque(true);

          if(rvb_grid[i][j] == "R"){
            grid[i][j].setIcon(imageRED);
          }
          if(rvb_grid[i][j] == "V"){
            grid[i][j].setIcon(imageGREEN);
          }
          if(rvb_grid[i][j] == "B"){
            grid[i][j].setIcon(imageBLUE);
          }
          if(rvb_grid[i][j] == "N"){
            grid[i][j].setIcon(null);
          }
          //grid[i][j] = c.RandomItem(grid[i][j]);

          grid[i][j].addMouseListener(click);
          panel.add(grid[i][j]);
      }
    }

    fenetre1.setVisible(true);
    fenetre1.pack();

    //panel.addMouseListener(click);
  }

  //grid[0][0].setBackground(Color.red);
  //MouseMove move = new MouseMove(grid);
  //panel.addMouseMotionListener(move);
}
