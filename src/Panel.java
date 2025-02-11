import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.Random;

public class Panel extends JPanel {
    /** Singleton class **/
    private static Panel instance;

    public static Panel getInstance() {
        return instance;
    }

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int GRID_SIZE = 10;
    public static final int ARRAY_SIZE = WIDTH / GRID_SIZE;
    public static Random rand = new Random();
    Integer[] array = new Integer[ARRAY_SIZE];

    Bogosort bogosort = new Bogosort();
    BubbleSort bubbleSort = new BubbleSort();
    InsertionSort insertionSort = new InsertionSort();
    SelectionSort selectionSort = new SelectionSort();
    ShellSort shellSort = new ShellSort();

    /** Selected Sorting Algorithm **/
    public final SortingAlgorithm algorithm = shellSort;

    public Panel() {
        instance = this;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(4, 4, 32));
        setup();
        startSorting();

        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    reset();
                }
            }
        });
    }

    public void setup(){
        for(int i = 0; i < ARRAY_SIZE; i++){
            array[i] = i;
        }
        /* Shuffle array at the start */
        Util.arrayShuffle(array);
    }

    /* Start thread, sorting begins and is delayed at each step
     * (which step is delayed is dependent on the selected algorithm) */
    public void startSorting() {
        new Thread(() -> algorithm.sort(array, Comparator.comparing(Integer::intValue))).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 255, 255));
        for(int i = 0; i < ARRAY_SIZE; i++){
            g2d.fillRect(i * GRID_SIZE,HEIGHT - (array[i]) * GRID_SIZE,GRID_SIZE,(array[i]) * GRID_SIZE);
        }
        g2d.setColor(new Color(30, 255, 22));
        g2d.setFont(new Font("Arial", Font.PLAIN, 50));
        g2d.drawString(algorithm.getClass().getSimpleName(), 0, 40);
    }

    public void reset() {
        setup();
        startSorting();
        repaint();
    }
}
