import javax.swing.JLabel;
import java.awt.Point;

public class BodyPart extends JLabel {

private Point point;
private String type;

BodyPart(int row, int col) {
  point = new Point(col, row); 
  type = "body";  // Eventually this needs to create head, body, or tail
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

public String getType() {
  return type;
}

public String toString() {
 // String start = super.toString();
  String result = String.format("{%s (%d, %d)}", type, getRow(), getCol());
  return result;
}

}