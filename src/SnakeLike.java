import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class SnakeLike extends JFrame {

 Game game;

SnakeLike() {
  createFrame();
  game = new Game();
  add(game, BorderLayout.CENTER);
  add(createFooter(), BorderLayout.PAGE_END);
  //pack();
  setVisible(true);
  
}

private void createFrame() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLocation(200,200);
 // setLocationRelativeTo(null);
  setSize(800, 700);
 }
 
 private JPanel createFooter() {
   JButton north = new JButton("^");
   north.addActionListener(createMovementListener('n'));
   JButton south = new JButton("v");
   south.addActionListener(createMovementListener('s'));
   JButton stay = new JButton("move");
   stay.addActionListener(createMovementListener('\0'));
   JButton east = new JButton(">");
   east.addActionListener(createMovementListener('e'));
   JButton west = new JButton("<");
   west.addActionListener(createMovementListener('w'));
   
   JPanel panel = new JPanel();
   panel.setLayout(new GridLayout (3, 3));
   panel.add(new JButton());
   panel.add(north);
   panel.add(new JButton());
   panel.add(west);
   panel.add(stay);
   panel.add(east);
   panel.add(new JButton());
   panel.add(south);
   panel.add(new JButton());
   
   return panel;
   }
 
 private ActionListener createMovementListener(char direction) {
   ActionListener al = new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       if (direction != '\0')
         game.setDirection(direction);
       game.move();
     
     }
     }
     ;
     return al;
 }
 
 public static void main(String[] args) {
   SnakeLike snake = new SnakeLike();
   snake.game.move();
 }
  
}