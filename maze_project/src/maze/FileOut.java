package maze;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class FileOut {
    private Labyrinth lab;
    private String path= "obiekty.sav";
    public FileOut(String path) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream p = null;
        try {
            p = new ObjectOutputStream(outputStream);
            p.writeInt(1);
            p.writeObject("Test");
            p.writeObject(new Date());
            p.writeObject(lab);
            p.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // l.dispose();
    }

    public Labyrinth getLab() {
        return lab;
    }
}
