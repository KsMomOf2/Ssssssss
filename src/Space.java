import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Point;

public class Space extends JLabel {
private static final char EMPTY = '\0';
public static String filename = "Blank.png";
private Point point;
private char orientation;

SPACE(int row, int col) {
  setIcon( new ImageIcon(filename));
  point = new Point(col, row); 
  orientation = EMPTY;
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