import javax.swing.*;

class TestView extends JFrame {
    public TestView(int[][] maze){
        this.setTitle("3DMaze");
        this.setSize(800,487); //drawable by(800,450)
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); //default(diswritable)

        String strl="",strc="",strr="";
        if(maze[2][0]==1) strl="1";
        else strl=""+maze[0][0]+maze[1][0]+maze[2][0];
        if(maze[1][1]==1) strc="1";
        else strc=""+maze[0][0]+maze[1][0]+"_"+maze[0][1]+maze[1][1]+"_"+maze[0][2]+maze[1][2];
        if(maze[2][2]==1) strr="1";
        else strr=""+maze[0][2]+maze[1][2]+maze[2][2];

        JLabel labelL = new JLabel("<html><img src='file:Picture/pic_left"+strl+".png' width=250 height=450></html>",JLabel.CENTER);
        labelL.setBounds(0,0,250,450);
        this.add(labelL);
        JLabel labelC = new JLabel("<html><img src='file:Picture/pic_center"+strc+".png' width=300 height=450></html>",JLabel.CENTER);
        labelC.setBounds(250,0,300,450);
        this.add(labelC);
        JLabel labelR = new JLabel("<html><img src='file:Picture/pic_right"+strr+".png' width=250 height=450></html>",JLabel.CENTER);
        labelR.setBounds(550,0,250,450);
        this.add(labelR);

        this.setVisible(true);
    }
    public static void main(String argv[]) {
        int[][] maze={
            {1,0,1},
            {1,1,1},
            {0,0,1}
        };
        new TestView(maze);
    }
}
