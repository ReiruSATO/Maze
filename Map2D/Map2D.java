package Map2D;
import javax.swing.*;
import java.awt.*;

class maze2 extends JFrame {
    private static final int block_size=8;//block_size=8だとちょうどいい大きさ
    private static int mapsize=9;//設定した?
    private static int x=0;//プレイヤーのx座標
    private static int y=mapsize-2;//プレイヤーのy座標
    private static final int[][] maze={
        {1,1,1,1,1,1,1,1,1},
        {1,0,0,0,1,0,0,0,3},
        {1,0,1,0,1,1,1,0,1},
        {1,0,1,0,1,0,0,0,1},
        {1,0,1,1,1,0,1,1,1},
        {1,0,0,0,1,0,0,0,1},
        {1,0,1,0,1,1,1,0,1},
        {2,0,1,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1},
    };
   //2Dmapの部分
    class Map2D extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int y=0;y<mapsize;y++) {
                for (int x=0;x<mapsize;x++) {
                    if (maze[y][x]==1) {
                        g.setColor(Color.GRAY);
                        g.fillRect(x*block_size,y*block_size,block_size,block_size);
                        g.setColor(Color.BLACK);
                        g.drawRect(x*block_size,y*block_size,block_size,block_size);
                    }else if(maze[y][x]==3){ 
                        g.setColor(Color.RED);
                        g.fillRect(x*block_size,y*block_size,block_size,block_size);
                        g.setColor(Color.BLACK);
                        g.drawRect(x*block_size,y*block_size,block_size,block_size);
                    }else {
                        g.setColor(Color.WHITE);
                        g.fillRect(x*block_size,y*block_size,block_size,block_size);
                        g.setColor(Color.BLACK);
                        g.drawRect(x*block_size,y*block_size,block_size,block_size);
                    }
                }
            }
            g.setColor(Color.GREEN);
            g.fillOval(x*block_size,y*block_size,block_size,block_size);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(maze2::new);//3DViewのあとで貼り付け
    }
}
