package View;
import java.awt.*;
import javax.swing.*;

public class MazeView extends JFrame {
    private String strl="",strc="",strr="";
    private int[][] view=new int[3][3];
    private int[][] maze;
    private int len=0;
    private JLabel labelL,labelC,labelR;
    private ImageIcon imgl,imgc,imgr;
    private int px,py;
    public MazeView(final int[][] maze, int sx, int sy){
        this.setTitle("3DMaze");
        this.setSize(800,487); //drawable by(800,450)
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); //default(diswritable)
        len=maze[0].length;
        this.maze=maze;
        System.out.println("x:"+sx+",y:"+sy);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((sx-1+j<0)||(sy+2-i<0)||(sx-1+j>=len)||(sy+2-i>=len)){
                    this.view[i][j]=1;
                }
                else{
                    this.view[i][j]=maze[sx-1+j][sy+2-i];
                }
            }
        }
        this.setView(view,sx,sy);
    }
    public void setView(int[][] view,int x,int y){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(view[i][j]+" ");
                //if(view[i][j]==3) view[i][j]=1;
            }
            System.out.println();
        }
        this.px=x; this.py=y;

        if(view[2][0]!=0) strl=""+view[2][0];
        else strl=""+view[0][0]+view[1][0]+view[2][0];
        if(view[1][1]!=0) strc=""+view[1][1];
        else strc=""+view[0][0]+view[1][0]+"_"+view[0][1]+view[1][1]+"_"+view[0][2]+view[1][2];
        if(view[2][2]!=0) strr=""+view[2][2];
        else strr=""+view[0][2]+view[1][2]+view[2][2];

        imgl=new ImageIcon("Picture/pic_left"+strl+".png");
        imgc=new ImageIcon("Picture/pic_center"+strc+".png");
        imgr=new ImageIcon("Picture/pic_right"+strr+".png");

        if(labelL==null){
            labelL=new JLabel(imgl);
            labelL.setBounds(0,0,250,450);
            this.add(labelL);
        }
        else labelL.setIcon(imgl);
        if(labelC==null){
            labelC=new JLabel(imgc);
            labelC.setBounds(250,0,300,450);
            this.add(labelC);
        }
        else labelC.setIcon(imgc);
        if(labelR==null){
            labelR=new JLabel(imgr);
            labelR.setBounds(550,0,250,450);
            this.add(labelR);
        }
        else labelR.setIcon(imgr);
        ViewPanel vp=new ViewPanel();
        vp.setLocation(new Point(0,0));
        this.add(vp);
        this.setVisible(true);
    }
    class ViewPanel extends JPanel {
        private static final int block_size=8;//block_size=8だとちょうどいい大きさ
        private int mapsize=maze[0].length;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("MapSize:"+mapsize);
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
            g.fillOval(px*block_size,py*block_size,block_size,block_size);
        }
    }
    public static void main(String argv[]) {
        int[][] maze={
            {0,0,1},
            {1,1,1},
            {0,0,1}
        };
        new MazeView(maze,1,2);
    }
}
