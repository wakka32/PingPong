import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

class  GrafikV3 extends Canvas {
    int x,y;
    int x1 = 400;
    int y1 = 300;
    double angle = 0;
    int width = 800;
    int height= 600;
    BufferStrategy bs;

    public GrafikV3() {
        setSize(width,height);
        JFrame frame = new JFrame("Grafik");
        frame.add(this);
        frame.addKeyListener(new KL());
        frame.addMouseListener(new ML());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    // Funkar inte utan måste petas på för att starta
    public void paint(Graphics g) {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            return;
        }
        draw(g);
        g.dispose();
        bs.show();
        repaint();
    }

    public void draw(Graphics g) {
        drawHouse(400,400,g);
        drawHouse(460,400,g);
        drawHouse(520,400,g);
        x = 200 + (int)(100*Math.cos(angle));
        y = 200 + (int)(100*Math.sin(angle));
        angle += 2*Math.PI/720;
        drawHouse(x,y,g);
        g.setColor(new Color(0x00FF00));
        g.fillOval(x1,y1,40,40);
    }

    private void drawHouse(int x, int y, Graphics g) {
        g.setColor(new Color(0xAA1111));
        g.fillRect(x,y,50,50);
        g.setColor(new Color(0x444444));
        int[] xcoords = {x,x+25,x+50};
        int[] ycoords = {y,y-50,y};
        g.fillPolygon(xcoords,ycoords,3);
    }

    private void drawBox(int x, int y, Graphics g) {
        g.setColor(new Color(0x55FF00FF));
        g.drawRect(x,y,300,200);
    }

    public static void main(String[] args) {
        GrafikV3 minGrafik = new GrafikV3();
    }

    private class KL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar()=='a') {
                x1-=5;
            } else if (keyEvent.getKeyChar()=='d') {
                x1+=5;
            } else if (keyEvent.getKeyChar()=='w') {
                y1-=5;
            } else if (keyEvent.getKeyChar()=='s') {
                y1+=5;
            }

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }

    private class ML implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            x1 = mouseEvent.getX();
            y1 = mouseEvent.getY();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

            x1 = mouseEvent.getX();
            y1 = mouseEvent.getY();
            System.out.println(x1 + ", " + y1);

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
