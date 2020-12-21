import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;

public class Game extends JPanel {
   private static final ImageIcon BLANK = new ImageIcon("Blank_50.png");
 //  private static Dimension size = new Dimension(50, 50);
   private static Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
   private static int rows=10, cols=5;
   private static int snakeStartSize = 3;

   private JLabel[][] spaces;
   private ArrayList<BodyPart> parts;

   Game() {
      setLayout(new GridLayout(rows, cols));
      createGrid();
      parts = new ArrayList<BodyPart>();
      createSnake();
   }

   private void createSnake() {
      Random r = new Random();
      int row = rows/2;// start the snake with a head in the middle
      int col = cols/2;
   
      for (int s = 0; s < snakeStartSize; s++) {
         parts.add(new BodyPart(row,col)); 
         if (r.nextBoolean()) 
            row--;
         else
            col--;     
      }
   }


   private void createGrid() {
      spaces = new JLabel[rows][cols];
      for (int row = 0; row < rows; row++)
         for (int col = 0; col < cols; col++) {
            JLabel label = new JLabel(BLANK);
            label.setBorder(blackLine);
            add(label);
            spaces[row][col] = label;
         }
   }

   public void paintComponent(Graphics g) {
      for (JLabel[] row : spaces) {
         for (JLabel space : row) {
            space.setIcon(BLANK);
/*            space.setPreferredSize(size);
            space.setMinimumSize(size);
            space.setMaximumSize(size);     
*/         }
      }
    
      for (BodyPart b : parts) {
         int r = b.getRow();
         int c = b.getCol();
         ImageIcon im = (ImageIcon)b.getIcon();
         JLabel label = spaces[r][c];
         label.setText("HELLO");
         label.setIcon(im);
  /*       label.setPreferredSize(size);
         label.setMinimumSize(size);
         label.setMaximumSize(size);
   */   }
   }

}
  
