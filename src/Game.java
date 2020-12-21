import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;

public class Game extends JPanel {
   private static final ImageIcon BLANK = new ImageIcon("Blank_50.png");
   private static Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
   private static int rows=10, cols=15;
   private static int snakeStartSize = 5;
   
   private char currentDirection = '\0';

   private Space[][] spaces;
   private ArrayList<BodyPart> parts;

   Game() {
      setLayout(new GridLayout(rows, cols, 0, 0));
      createGrid();
      parts = new ArrayList<BodyPart>();
      createSnake();
      System.out.println(parts);
   }

   public void setDirection(char direction) {
     currentDirection = direction;
   }
   
   private void createSnake() {
      Random r = new Random();
      int row = rows/2;// start the snake with a head in the middle
      int col = cols/2;
      currentDirection = getRandomDirection();
      char nextDirection = currentDirection;
      
      for (int s = 0; s < snakeStartSize; s++) {
         parts.add(new BodyPart(row,col)); 
         spaces[row][col].setDirection(nextDirection);
         if (r.nextBoolean()) {
            row--;
            nextDirection = 's';
         }
         else  {
            col--;
            nextDirection = 'e';
         }     
      }
      currentDirection = getRandomDirection();
      System.out.println("Direction: " + currentDirection);
   }
   
   private char getRandomDirection() {
      int numDirections = 4;
      char[] directions = new char[] {'n', 's', 'e', 'w'};
     
      int index = (int) (Math.random()*4);
      return directions[index];
   }

   private void createGrid() {
      spaces = new Space[rows][cols];
      for (int row = 0; row < rows; row++)
         for (int col = 0; col < cols; col++) {
            Space space = new Space(row, col);
            space.setBorder(blackLine);
            add(space);  // this adds the label to the layout
            spaces[row][col] = space; // this puts it in the matrix - which allows us to update it later
         }
   }

   public void paintComponent(Graphics g) {
      for (Space[] row : spaces) {
         for (Space space : row) {
            space.setIcon(BLANK);
         //         System.out.printf("%c\t", space.getDirection());
         }
      //      System.out.println();
      }
    
      for (BodyPart b : parts) {
         int r = b.getRow();
         int c = b.getCol();
         Space space = spaces[r][c];
         space.setText("" + space.getDirection());
         space.setBody(true); // THIS NEEDS TO BE HEAD/BODY/TAIL eventually
      }
   
   
   
   }
// can eventually be private
// Right now only moves the head

   public void move() {
      char nextDirection = currentDirection;
      int currentPart = 0; // The head is added first, so it is at the beginning
      BodyPart head = parts.get(currentPart);
      int row = head.getRow();
      int col = head.getCol();
     
      Point nextPoint = move(row, col, nextDirection);
   
      int nextRow = (int) nextPoint.getY();
      int nextCol = (int) nextPoint.getX();
      
      if (! isValid(nextRow, nextCol)) {
         System.out.printf("Snake Crashed: (%d, %d)\n", nextRow, nextCol);
         System.exit(0);
      }
      head.setPoint(nextPoint);
   
      Space nextSpace = spaces[nextRow][nextCol];
      nextSpace.setHead(true);
      nextSpace.setDirection(nextDirection);
      repaint();
      System.out.println(parts);
     
     
     
     
     
   
   }
   
   private boolean isValid(int row, int col) {
     boolean inBounds = row >= 0 && col >= 0 & row < rows && col < cols;
     if (! inBounds) {
       System.out.println("Out of Bounds");
       return false;
     }
     
     for (BodyPart s : parts) {
       int r = s.getRow();
       int c = s.getCol();
       if (row == r && col == c) {
         System.out.println("Ran into Itself");
         return false;
         }
   }
   return true;
   }
   
   private Point move(int row,int col, char nextDirection) {
      switch (nextDirection) {
         case 'n':
            row--;
            break;
         case 'e':
            col++;
            break;
         case 's':
            row++;
            break;
         case 'w':
            col--;
            break;
         default:
      }
      Point point = new Point(col, row);
   
      return point;
   }
   
   // Add a button to move the snake in its current direction
   // move the head 
   // add buttons to change the direction
   // move the head
   
   // add the body and the tail
}
  
