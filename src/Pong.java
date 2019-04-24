import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pong extends Canvas {
    BufferedImage img = null;
    int x = 400;
    int y = 50;
    int vx =4;
    int vy =-1;
    public Pong() {
        setSize(800,600);
        JFrame frame = new JFrame("Grafik");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        try {
            img = ImageIO.read(new File("Pong.jpg"));
            img = ImageIO.read(new File("Rödboll.gif"));
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void paint(Graphics g) {
        drawBox(100,100, g);
        drawBox(300,200,g);
        g.setColor(new Color(0x000000));
        g.fillRect(0,0,800,600);

        g.drawImage(img,x,y,null);
        x = x + vx;
        y = y + vy;
        if (vx > 0 && x>800)
            vx = -3;
        if (vx < 0 && x<0)
            vx= 3;
        if (vy > 0 && y>600)
            vy = -1;




        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();

    }

    private void drawBox(int x, int y, Graphics g) {

    }

    public static void main(String[] args) {
        Pong minGrafik = new Pong();
    }
}



