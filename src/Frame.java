import javax.swing.*;

public class Frame extends JFrame {
    Panel panel;
    public Frame() {
        panel = new Panel();
        this.add(panel);
        this.setTitle("Sorting Algorithms Visualiser");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
