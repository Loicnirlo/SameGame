import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import javax.swing.border.*;
import java.applet.Applet;

public class FillCase {

  public String[] color = {"R", "V", "B"};
  public String[][] RVBgrid = new String[10][15];
  Random random = new Random();
/*  private ImageIcon imageRED = new ImageIcon(getClass().getResource("apple_food_fruit_icon_182561.png"));
  private ImageIcon imageGREEN = new ImageIcon(getClass().getResource("coconut_food_fruit_icon_182573.png"));
  private ImageIcon imageBLUE =  new ImageIcon(getClass().getResource("food_fruit_grape_icon_182560.png"));
*/
  public FillCase(){

  }

/*  public JLabel RandomItem(JLabel label){

    int r = random.nextInt(3);
    String s = color[r];

    if (s=="R") {
    label.setIcon(imageRED);
    }
    else if(s=="V") {
    label.setIcon(imageGREEN);

    }
    else if(s=="B") {
    label.setIcon(imageBLUE);
    }

    return label;
  }
  */
  public String[][] RVBgridFill(){
    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 15; j++){
        int r = random.nextInt(3);
        RVBgrid[i][j] = color[r];
        System.out.print(RVBgrid[i][j]);
      }
      System.out.println();
    }
  /*  for (int i = 0; i < 10; i++){
      for (int j = 0; j < 15; j++){

      if(RVBgrid[i][j] == "R"){
        System.out.println("red");
      }
      }

    }
    */
    return RVBgrid;
  }
}
