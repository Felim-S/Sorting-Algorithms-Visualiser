import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class Panel extends JPanel implements ActionListener {
    /** Singleton class **/
    private static Panel instance;

    public static Panel getInstance() {
        return instance;
    }

    public JComboBox<SortingAlgorithm> dropdown;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 550;
    public static final int GRID_SIZE = 10;
    public static final int ARRAY_SIZE = WIDTH / GRID_SIZE;
    Integer[] array = new Integer[ARRAY_SIZE];

    Bogosort bogosort = new Bogosort();
    BubbleSort bubbleSort = new BubbleSort();
    InsertionSort insertionSort = new InsertionSort();
    SelectionSort selectionSort = new SelectionSort();
    ShellSort shellSort = new ShellSort();
    SleepSort sleepSort = new SleepSort();

    public SortingAlgorithm[] algorithms;
    public SortingAlgorithm algorithm;

    public Panel() {
        instance = this;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(4, 4, 32));

        algorithms = new SortingAlgorithm[]{bubbleSort, insertionSort, selectionSort, shellSort, sleepSort};

        dropdown = new JComboBox<SortingAlgorithm>(algorithms);
        dropdown.addActionListener(this);
        dropdown.setSelectedIndex(0);
        this.add(dropdown);

        setup();
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
        algorithm.sorted = false;
        new Thread(() -> algorithm.sort(array, Comparator.comparing(Integer::intValue))).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 255, 255));
        if(algorithm.sorted){
            g2d.setColor(new Color(0, 128, 255));
        }
        for(int i = 0; i < ARRAY_SIZE; i++){
            g2d.fillRect(i * GRID_SIZE,HEIGHT - (array[i]) * GRID_SIZE,GRID_SIZE,(array[i]) * GRID_SIZE);
        }
    }

    public void reset() {
        if(algorithm.sorted){
            setup();
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
        // Fix error when selecting a new algorithm while it's running
        if(e.getSource() == dropdown) {
            algorithm = (SortingAlgorithm) dropdown.getSelectedItem();
            algorithm.sorted = true;
            reset();
            startSorting();
        }
    }
}
