package Player;
import End.End;
import View.MazeView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends MazeView implements KeyListener{
    int maze[][];
    private int[][] move = {
        {-1, 0},
        { 0, 1},
        { 1, 0},
        { 0,-1}
    };
    private int view[][] = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };
    private String direction[]={"up","right","down","left"};
    int x, y;//プレイヤーの座標
    int g_x ,g_y;//ゴールの座標
    int dir = 1;//up: 0, right: 1, down: 2, left: 3
    int len=0;

    public Player(final int[][] maze, int sx, int sy, int gx, int gy){
        super(maze,sx,sy);
        this.maze=maze;
        this.x = sx;
        this.y = sy;
        this.g_x = gx;
        this.g_y = gy;
        this.len=this.maze[0].length;
        this.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dir = (dir + 3) % 4;
                break;
            case KeyEvent.VK_RIGHT:
                dir = (dir + 1) % 4;
                break;
            case KeyEvent.VK_UP:
                int new_x = x + this.move[dir][0];
                int new_y = y + this.move[dir][1];
                if(new_x < 0 || new_x >= len || new_y < 0 || new_y >= len){
                    return;
                }else if(maze[new_x][new_y] == 1){
                    return;
                }else if(new_x == g_x && new_y == g_y){
                    System.out.println("Congratulations!!");
                    new End();
                }else{
                    x += move[dir][0];
                    y += move[dir][1];
                }
                break;
            case KeyEvent.VK_DOWN:
                int new_x2 = x + move[(dir + 2) % 4][0];
                int new_y2 = y + move[(dir + 2) % 4][1];
                if(new_x2 < 0 || new_x2 >= len || new_y2 < 0 || new_y2 >= len){
                    return;
                }else if(maze[new_x2][new_y2] == 1){
                    return;
                }else if(new_x2 == g_x && new_y2 == g_y){
                    System.out.println("Congratulations!!");
                    new End();
                }else{
                    x += move[(dir + 2) % 4][0];
                    y += move[(dir + 2) % 4][1];
                }
                break;
        }
        System.out.println("dir:"+direction[dir]+",x:"+x+",y:"+y);
        this.loadview();
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void loadview(){
        int i, j, vx, vy;
        switch(this.dir){
            case 0:
                for(i=0;i<3;i++){
                    vx=this.x-2+i;
                    for(j=0;j<3;j++){
                        vy=this.y-1+j;
                        if(vx<0||vx>=len||vy<0||vy>=len) this.view[i][j]=1;
                        else this.view[i][j]=this.maze[vx][vy];
                    }
                }
                break;
            case 1:
                for(i=0;i<3;i++){
                    vy=this.y+2-i;
                    for(j=0;j<3;j++){
                        vx=this.x-1+j;
                        if(vx<0||vx>=len||vy<0||vy>=len) this.view[i][j]=1;
                        else this.view[i][j]=this.maze[vx][vy];
                    }
                }
                break;
            case 2:
                for(i=0;i<3;i++){
                    vx=this.x+2-i;
                    for(j=0;j<3;j++){
                        vy=this.y+1-j;
                        if(vx<0||vx>=len||vy<0||vy>=len) this.view[i][j]=1;
                        else this.view[i][j]=this.maze[vx][vy];
                    }
                }
                break;
            case 3:
                for(i=0;i<3;i++){
                    vy=this.y-2+i;
                    for(j=0;j<3;j++){
                        vx=this.x+1-j;
                        if(vx<0||vx>=len||vy<0||vy>=len) this.view[i][j]=1;
                        else this.view[i][j]=this.maze[vx][vy];
                    }
                }
                break;
        }
        this.setView(view,x,y);
    }
}


