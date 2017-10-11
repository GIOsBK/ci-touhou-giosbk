import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
    BufferedImage player;
    int playX = 180;
    int playY = 500;
    boolean rightPressed;
    boolean leftPressed;
    boolean downPessed;
    boolean upPessed;
    BufferedImage backBuffer;
    Graphics backGraphic;

    public GameCanvas(){
        //0.create back bufer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
        backGraphic = backBuffer.getGraphics();
        //1.Load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();// lich su goi ham
        }
    }

    public void render(){
        //1.draw everything on back buffer
        backGraphic.drawImage(background, 0, 0,null);
        backGraphic.drawImage(player,playX,playY,null);

        //2.call repaint
        repaint();
    }
    //2.draw background

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
           leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
           downPessed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
           upPessed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            downPessed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPessed = false;
        }

    }
    public void run() {
        int vx = 0;
        int vy = 0;
        if (rightPressed) {
            vx += 5;
        }
        if (leftPressed) {
            vx -= 5;
        }
        playX = playX + vx;

    }
}
