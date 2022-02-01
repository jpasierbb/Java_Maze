package maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import static java.lang.System.exit;

public class ButtonPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 300;
    public static final int WIDTH = 500;
    JButton bGenerate, bLoad, bSave, bSolve, bExit;

    public ButtonPanel() {
        bGenerate = new JButton("Generate MAZE");
        bLoad = new JButton("Load MAZE");
        bSave = new JButton(("Save MAZE"));
        bSolve = new JButton("Solve MAZE");
        bExit = new JButton("Exit");

        bGenerate.addActionListener(this);
        bLoad.addActionListener(this);
        bSave.addActionListener(this);
        bSolve.addActionListener(this);
        bExit.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(bGenerate);
        add(bLoad);
        add(bSave);
        add(bSolve);
        add(bExit);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bGenerate) {
            // metoda generująca labirynt
            System.out.println("Generowanie labiryntu...");
            Labyrinth L1 = new Labyrinth(10, 10);
            L1.toString();
            System.out.println("\n");
        }
        else if (source == bLoad) {
            // metoda wczytująca labirynt
            System.out.println("Wczytywanie labiryntu...");
            FileIn fi = new FileIn("obiekt2.sav");
            fi.getLab();

        }
        else if (source == bSave) {
            // metoda zapisująca labirynt
            System.out.println("Zapisywanie labiryntu...");
            FileOut fo = new FileOut("obiekt2.sav");

        }
        else if (source == bSolve) {
            // metoda rozwiązująca labirynt
            System.out.println("Rozwiązywanie labiryntu...");
        }
        else if (source == bExit) {
            // metoda kończąca działanie programu
            System.out.println("Wyjście z programu.");
            exit(0);
        }
    }
}