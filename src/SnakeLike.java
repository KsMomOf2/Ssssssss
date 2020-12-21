import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakeLike extends JFrame {

Game game;

SnakeLike() {
  createFrame();
  game = new Game();
  add(game);
  pack();
  setVisible(true);
  
}

private void createFrame() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  setSize(800, 700);
 }
 
 public static void main(String[] args) {
   new SnakeLike();
 }
  
}