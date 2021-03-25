package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawShape(int x, int y) {
        int radius = (int) frame.getConfigPanel().radiusField.getValue();
        int sides = (int) frame.getConfigPanel().sidesField.getValue();
        int stroke = (int) frame.getConfigPanel().strokeField.getValue();
        Color color;

        if (frame.getConfigPanel().colorCombo.getSelectedItem().toString().equals("Random")) {
            color = new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255), (int) (Math.random() * 200 + 50));
        }
        else {
            color = new Color(0, 0, 0);
        }

        graphics.setColor(color);
        graphics.setStroke(new BasicStroke(stroke));
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}

