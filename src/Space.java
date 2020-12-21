import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Point;

public class Space extends JLabel {

   private static final char EMPTY = '\0';

   public static String blankFilename = "Blank.png";
   private static String bodyFilename = "Body_50.png";
   private static String headFilename = "HackBI_50.png";
   private static String tailFilename = "HackBI_50.png";

   private static ImageIcon blankImage = new ImageIcon(blankFilename);
   private static ImageIcon bodyImage = new ImageIcon(bodyFilename);
   private static ImageIcon tailImage = new ImageIcon(tailFilename);
   private static ImageIcon headImage = new ImageIcon(headFilename);

   private Point point; // Not sure this is going to be important, but perhaps where the space is in the matrix
                     // so that it can be properly drawn in paintComponent

   private char orientation; // can be N, S, E, W or the null character

// This could be done with an enum
   private boolean body; // right now covers body and tail
   private boolean head; // head needs to be delineated because the movement gets set when the head passes
   private boolean tail; // needs to be used because the movement resets when the tail passes

   Space(int row, int col) {
      setIcon(blankImage);
      setText(null);
      point = new Point(col, row);  // because x is width and col is width - 
                                // unintuitively, in a point, the column comes first
      orientation = EMPTY;
      body = false;
      head = false;
      tail = false;
   }

   public int getCol() {
      return (int) point.getX();
   }

   public int getRow() {
      return (int) point.getY();
   }

   private void resetImage() {
      ImageIcon ii;
      if (body) ii = bodyImage;
      else if (tail) ii = tailImage;
      else if (head) ii = headImage;
      else ii = blankImage;
      setIcon(ii);
   }

   public void setBody(boolean b) {
      body = b;
      if (b) {
         tail = false;
         head = false;
      }
      resetImage();
   }

   public void setHead(boolean b) {
      head = b;
      if (b) {
         body = false;
         tail = false;
      }
      resetImage();
   }

   public void setTail(boolean b) {
      tail = b;
      if (b) {
         body = false;
         head = false;
      }
      resetImage();
   }
   
   public char getDirection() {
     return orientation;
     }
     
   public void setDirection(char direction) {
     orientation = direction;
   }
   public String getType() {
      if (head) 
         return "head";
      if (tail) 
         return "tail";
      if (body) 
         return "body";
      return "";
   }

   public String toString() {
   // String start = super.toString();  // useful if you want to see the entire label
      ImageIcon icon = (ImageIcon) getIcon();
      String result = String.format ("Type: %s, Point: (%d, %d), Facing: %c\n", getType(), getY(), getX(), orientation);
      return result;
   }

}