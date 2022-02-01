package maze;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class FileIn {

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        String text = "";
        Date date = null;
        int i=0;
        Labyrinth lab = null;
        try {
            inputStream = new FileInputStream("obiekty.sav");
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
}
