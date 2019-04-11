import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pong extends Canvas {
    BufferedImage img = null;

    public Pong() {
        setSize(800,600);
        JFrame frame = new JFrame("Grafik");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        try {
            img = ImageIO.read(new File("Pong.jpg"));
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void paint(Graphics g) {
        drawBox(100,100, g);
        drawBox(300,200,g);
        g.setColor(new Color(0x5500FFFF));
        g.drawImage(img,0,0,null);
    }

    private void drawBox(int x, int y, Graphics g) {

    }

    public static void main(String[] args) {
        Pong minGrafik = new Pong();
    }
}



