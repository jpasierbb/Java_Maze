package maze;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class FileOut {

    public static void main (String[] args) {
        Labyrinth l = new Labyrinth(30,30);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("obiekty.sav");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream p = null;
        try {
            p = new ObjectOutputStream(outputStream);
            p.writeInt(1);
            p.writeObject("Test");
            p.writeObject(new Date());
            p.writeObject(l);
            p.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // l.dispose();
    }
}
