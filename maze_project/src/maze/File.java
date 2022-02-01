package maze;

import java.io.*;
import java.util.Date;

public class File{
    public static void load(Labyrinth lab,String name){
        FileInputStream inputStream = null;
        String text = "";
        Date date = null;
        int i=0;
        try {
            inputStream = new FileInputStream(name);
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
    public static void save(Labyrinth l,String name) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(name);
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
    public static void main(String[] args) {

    }
}
