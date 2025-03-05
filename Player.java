import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import playerView.MazeView;

class Player extends MazeView{
    int maze[][];
    int[][] move=new int[4][2];
    int x,y;//Plater point
    int g_x,g_y;//Goal point
    int dir;//up: 0, right: 1, down: 2, left: 3
    public Player(final int[][] maze,int sx,int sy,int gx,int gy){
        super(maze);
        this.x=sx;
        this.y=sy;
        this.g_x=gx;
        this.g_y=gy;
        this.dir=0;
        move[0][0]=-1; move[0][1]=0;
        move[1][0]=0; move[1][1]=1;
        move[2][0]=1; move[2][1]=0;
        move[3][0]=0; move[3][1]=-1;
        super.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    dir=(dir+3)%4;
                    System.out.println(dir+" "+x+" "+y);//for test
                    break;
                case KeyEvent.VK_RIGHT:
                    dir=(dir+1)%4;
                    System.out.println(dir+" "+x+" "+y);//for test
                    break;
                case KeyEvent.VK_UP:
                    int new_x=x+move[dir][0];
                    int new_y=y+move[dir][1];
                    if(maze[new_x][new_y]==1||new_x<0||new_x>=maze.length||new_y<0||new_y>=maze[0].length){ //1:wall
                        //nothing
                        break;
                    }else if(new_x==g_x&&new_y==g_y){
                        System.out.println("Congratulations!!");
                    }else{
                        x+=move[dir][0];
                        y+=move[dir][1];
                    }
                    System.out.println(dir+" "+x+" "+y);//for test
                    break;
                case KeyEvent.VK_DOWN:
                    int new_x2=x+move[(dir+2)%4][0];
                    int new_y2=x+move[(dir+2)%4][1];
                    if(maze[new_x2][new_y2]==1||new_x2<0||new_x2>=maze.length||new_y2<0&&new_y2>=maze[0].length){
                        //nothing
                        break;
                    }else if(new_x2==g_x&&new_y2==g_y){
                        System.out.println("Congratulations!!");
                    }else{
                        x+=move[(dir+2)%4][0];
                        y+=move[(dir+2)%4][1];
                    }
                    System.out.println(dir+" "+x+" "+y);//for test
                    break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){}
            @Override
            public void keyTyped(KeyEvent e){}
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String args[]){
        try{//maze[][] setting
            int x=0,y=0,gx=0,gy=0;//start&goal point
            //int[][] maze = new int[][];
            File file=new File("Sample/sample.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String str;
            //String[][] nums = new String[200][200];
            int nums[][]=new int[200][200];
            int i=0,j=0;
            while((str=br.readLine())!=null){ //get array from file data
                //Scanner scan = new Scanner(str);
                String[] nums2=str.split(" ");
                //System.out.println(nums2.length);
                j=nums2.length; //width
                //j = 0; //after use 1
                    //nums[i] = new int[j];
                for(int k=0;k<j;k++){
                    nums[i][k]=Integer.parseInt(nums2[k]);
                    System.out.println(nums);
                    if(nums[i][k]==2){
                        x=i;
                        y=k;
                    }else if(nums[i][k]==3){
                        gx=i;
                        gy=k;
                    }
                }
                i+=1; //i:after use 2
            }
            final int[][] maze = new int[i][j];
            for(int a=0;a<i;a++){ //copying array
                for(int b=0;b<j;b++){
                    maze[a][b]=nums[a][b];
                }
            }
            new Player(maze,x,y,gx,gy);
            br.close();
            fr.close();
        }catch(IOException e){
            //nothing
        }
    }
}


