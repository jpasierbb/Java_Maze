package maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static java.lang.System.exit;

public class ButtonPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 300;
    public static final int WIDTH = 500;
    JButton bGenerateAB, bGenerateDF, bLoad, bSave, bSolve, bExit, bGenerateSmall, bGenerateMedium, bGenerateBig;
    Labyrinth L1 = new Labyrinth(Labyrinth.Difficulty.MEDIUM);
    public ButtonPanel() {
        bGenerateAB = new JButton("Print MAZE by AB");
        bGenerateDF = new JButton("Print MAZE by DF");
        bGenerateSmall = new JButton(("Generate Small MAZE"));
        bGenerateMedium = new JButton(("Generate Medium MAZE"));
        bGenerateBig = new JButton(("Generate Big MAZE"));
        bLoad = new JButton("Load MAZE");
        bSave = new JButton(("Save MAZE"));
        bSolve = new JButton("Solve MAZE");
        bExit = new JButton("Exit");

        bGenerateAB.addActionListener(this);
        bGenerateDF.addActionListener(this);
        bLoad.addActionListener(this);
        bSave.addActionListener(this);
        bSolve.addActionListener(this);
        bExit.addActionListener(this);
        bGenerateSmall.addActionListener(this);
        bGenerateMedium.addActionListener(this);
        bGenerateBig.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(bGenerateAB);
        add(bGenerateDF);
        add(bLoad);
        add(bSave);
        add(bSolve);
        add(bExit);
        add(bGenerateSmall);
        add(bGenerateMedium);
        add(bGenerateBig);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();



        if (source == bGenerateSmall) {
            System.out.println("Generowanie małego labiryntu");
            L1 = new Labyrinth((Labyrinth.Difficulty.EASY));
        }
        else if (source == bGenerateMedium) {
            System.out.println("Generowanie małego labiryntu");
            L1 = new Labyrinth((Labyrinth.Difficulty.MEDIUM));
        }
        else if (source == bGenerateBig) {
            System.out.println("Generowanie małego labiryntu");
            L1 = new Labyrinth((Labyrinth.Difficulty.HARD));
        }

        else if (source == bGenerateAB) {
            // metoda generująca labirynt
            System.out.println("PRINTING AB...");
            GeneratorAldusBroder GL1 = new GeneratorAldusBroder(L1);
            L1 = GL1.getLabyrinth();
            L1.toString();
            System.out.println("\n");
        }
        else if (source == bGenerateDF) {
            // metoda generująca labirynt
            System.out.println("PRINTING DF...");
            GeneratorDeepFirst GL1 = new GeneratorDeepFirst(L1);
            L1 = GL1.getLabyrinth();
            L1.toString();
            System.out.println("\n");
        }

        else if (source == bLoad) {
            // metoda wczytująca labirynt
            System.out.println("Wczytywanie labiryntu...");
            File.load(L1, "maze.sav");

        }
        else if (source == bSave) {
            // metoda zapisująca labirynt
            System.out.println("Zapisywanie labiryntu...");
            File.save(L1, "maze.sav");

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