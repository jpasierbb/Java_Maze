package maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    private JButton generate;
    private JButton load;
    private JButton exit;

    public ButtonPanel() {
        generate = new JButton("Generate MAZE");
        load = new JButton("Load MAZE");
        exit = new JButton("Exit");

        generate.addActionListener(this);
        load.addActionListener(this);
        exit.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(generate);
        add(load);
        add(exit);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == generate)
            // metoda generująca labirynt
            System.out.println("generowanie labiryntu");

        else if(source == load)
            // metoda wczytująca labirynt
            System.out.println("wczytywanie labiryntu");
        else if(source == exit)
            // metoda kończąca działanie programu
            System.out.println("wyjście z programu");
    }
}