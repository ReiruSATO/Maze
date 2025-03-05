import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class maze extends JFrame {

    private static final int size = 30;
    private static int mapsize = 9;
    private static int px = 0;
    private static int py = mapsize - 2;
    private static int count = 0;

    private static final int[][] mazeMap = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 3},
        {1, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1},
        {2, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; 
    //道0,,壁1,スタート2,ゴール3,隠し通路4

    public maze() {
        setTitle("Maze");
        setSize(size * (mapsize + 1), size * (mapsize + 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                move(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        add(canvas);
        setVisible(true);
    }

    private void move(KeyEvent event) {
        count++;
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_UP && mazeMap[py - 1][px] != 1) {
            py = py - 1;
        }

        if (keyCode == KeyEvent.VK_DOWN && mazeMap[py + 1][px] != 1) {
            py = py + 1;
        }

        if (keyCode == KeyEvent.VK_LEFT && mazeMap[py][px - 1] != 1) {
            px = px - 1;
        }

        if (keyCode == KeyEvent.VK_RIGHT && mazeMap[py][px + 1] != 1) {
            px = px + 1;
        }

        repaint();

        if (mazeMap[py][px] == 3) {
            JOptionPane.showMessageDialog(this, "ゲームクリア\nキーを押した回数：" + count);
            dispose();
        }
    }

    class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int y = 0; y < mapsize; y++) {
                for (int x = 0; x < mapsize; x++) {
                    if (mazeMap[y][x] == 1 || mazeMap[y][x] == 4) {
                        g.setColor(Color.GRAY);
                        g.fillRect(x * size, y * size, size, size);//You can change the object
                        g.setColor(Color.BLACK);
                        g.drawRect(x * size, y * size, size, size);//You can change the object
                    }else if(mazeMap[y][x] == 3){ 
                        g.setColor(Color.RED);
                        g.fillRect(x * size, y * size, size, size);//You can change the object
                        g.setColor(Color.BLACK);
                        g.drawRect(x * size, y * size, size, size);//You can change the object
                    }else {
                        g.setColor(Color.WHITE);
                        g.fillRect(x * size, y * size, size, size);//You can change the object
                        g.setColor(Color.BLACK);
                        g.drawRect(x * size, y * size, size, size);//You can change the object
                    }
                }
            }

            g.setColor(Color.GREEN);
            g.fillOval(px * size, py * size, size, size);//You can change the object
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(maze::new);
    }
}