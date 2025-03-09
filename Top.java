import javax.swing.*;
import Player.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class Top extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    public Top() {
        this.setSize(800, 489);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        JLabel c = new JLabel("<html><img src='file:Picture/Back.jpg' width=800 height=489></html>", JLabel.CENTER);
        b1 = new JButton("Easy");
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setBackground(new Color(0,85,46));
        b1.setFont(new Font("Yrsa Light",Font.ITALIC,50));
        b2 = new JButton("Normal");
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Yrsa Light",Font.BOLD,50));
        b3 = new JButton("Hard");
        b3.setForeground(Color.white);
        b3.setOpaque(true);
        b3.setBackground(Color.red);
        b3.setFont(new Font("Kinnari",Font.BOLD,50));
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        JLabel l = new JLabel("迷路ゲーム",JLabel.CENTER);
        l.setForeground(Color.white);
        l.setOpaque(true);
        l.setBackground(Color.black);
        l.setFont(new Font("IPA Pゴシック",Font.BOLD,36));
        c.setBounds(0, 0, 800, 489);
        b1.setBounds(50, 200, 200, 100);
        b2.setBounds(300, 200, 200, 100);
        b3.setBounds(550, 200, 200, 100);
        l.setBounds(300, 50, 200, 100);
        this.add(c);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(l);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String mode="";
        try{
            File file=new File("Data/mode.dat");
            FileWriter fw=new FileWriter(file);
            if (e.getSource()==b1){
                fw.write("Easy");
            }
            else if (e.getSource()==b2){
                fw.write("Normal");
            }
            else if (e.getSource()==b3){
                fw.write("Hard");
            }
            fw.close();
        }catch(IOException exception){}
        this.dispose();
        try{
            int x=0,y=0,gx=0,gy=0;
            Path path=Paths.get("Data/mode.dat");
            mode=Files.readString(path);
            String str="Data/"+mode+".txt";
            System.out.println(str);
            File file=new File(str);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            int nums[][]=new int[200][200];
            int i=0,j=0;
            while((str=br.readLine())!=null){
                String[] nums2=str.split(" ");
                j=nums2.length;
                for(int k=0;k<j;k++){
                    nums[i][k]=Integer.parseInt(nums2[k]);
                    if(nums[i][k]==2){
                        x=i;
                        y=k+1;
                    }else if(nums[i][k]==3){
                        gx=i;
                        gy=k;
                    }
                }
                i+=1;
            }
            final int[][] maze=new int[i][j];
            for(int a=0;a<i;a++){
                for(int b=0;b<j;b++){
                    if(a==x&&b==y){
                        maze[a][b-1]=1;
                    }else{
                        maze[a][b]=nums[a][b];
                    }
                }
            }
            br.close();
            new Player(maze,x,y,gx,gy);
        }catch(IOException ioe){
            System.err.println("No Map Data.");
        }
    }
    public static void main(String argv[]) {
        try{
            File file=new File("Data/mode.dat");
            FileWriter fw=new FileWriter(file);
            fw.write("");
            fw.close();
            new Top();
        }catch(IOException exception){System.err.println("File Error.");}
    }
}