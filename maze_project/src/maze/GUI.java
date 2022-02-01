package maze;

import java.awt.EventQueue;

class GUI {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActionFrame();
            }
        });
    }
}