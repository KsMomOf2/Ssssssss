import javax.swing.JLabel;
import java.awt.Point;

public class BodyPart extends JLabel {

private Point point;

BodyPart(int row, int col) {
  point = new Point(col, row); 
}

public int getCol() {
  return (int) point.getX();
}

public int getRow() {
  return (int) point.getY();
}

public Point getPoint() {
  return point;
}

public void setPoint(Point p) {
  point = p;
  }


public String toString() {
 // String start = super.toString();
  String result = String.format("(%d, %d)", getRow(), getCol());
  return result;
}

}