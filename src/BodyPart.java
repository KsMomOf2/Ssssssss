import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Point;

public class BodyPart extends JLabel {

public static String filename = "HackBI_50.png";
private Point point;

BodyPart(int row, int col) {
  setIcon( new ImageIcon(filename));
  point = new Point(col, row); 
}

public int getCol() {
  return (int) point.getX();
}

public int getRow() {
  return (int) point.getY();
}

public String toString() {
  String start = super.toString();
  ImageIcon icon = (ImageIcon) getIcon();
  String result = point + " " + getText() + "\n" + icon;
  return result;
}

}