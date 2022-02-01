package maze;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class FileIn {
    private Labyrinth lab;
    private String path = "obiekty.sav";
    public FileIn(String path) {
        FileInputStream inputStream = null;
        String text = "";
        Date date = null;
        int i=0;
        Labyrinth lab = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream p;
        try {
            p = new ObjectInputStream(inputStream);
            i = p.readInt();
            try {
                text = (String) p.readObject();
                date = (Date) p.readObject();
                lab = (Labyrinth) p.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lab.toString();
    }

    public Labyrinth getLab() {
        return lab;
    }
}
