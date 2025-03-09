package End;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class End extends JFrame implements ActionListener {
    private JLabel congratulationsLabel;
    private Timer timer;
    private float hue;

    public End() {
        hue = 0.0f; // 初期の色相

        //this.setBackground(Color.black);
        congratulationsLabel = new JLabel("Congratulations!!", JLabel.CENTER);
        congratulationsLabel.setFont(congratulationsLabel.getFont().deriveFont(24.0f)); // フォントサイズを設定
        add(congratulationsLabel);

        timer = new Timer(5, this); // タイマーを10ミリ秒ごとにアクションを実行
        timer.start();

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // ウィンドウを中央に配置
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hue = (hue + 0.01f) % 1.0f; // 色相を変更

        Color gradientColor = Color.getHSBColor(hue, 1.0f, 1.0f); // HSB色空間を使用して色を作成
        congratulationsLabel.setForeground(gradientColor);
    }

    public static void main(String[] args) {
        new End();
    }
}
