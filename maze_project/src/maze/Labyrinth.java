package maze;

import java.lang.invoke.WrongMethodTypeException;

public class Labyrinth {
    private int height = 0;
    private int width = 0;
    private String difficulty = "";
    private String[] difficulties = {"hard","medium","easy"}; //Pre-defined difficulties
    private Node baseNode = null;
    private Node outNote = null;

    /**
     * Constructor to make the Labyrint with given height and width. Difficulty is being set according to size.
     * @param width
     * @param height
     */
    public Labyrinth(int width, int height) throws WrongSizeException{
        if(width<10 || height<10){
            throw new WrongSizeException("Too small size of the Labyrint",width,height);
        }
        this.height = height;
        this.width = width;
        int size = width*height;
        if(size>100){
            difficulty = difficulties[0];
        }
        else if(size>50){
            difficulty = difficulties[1];
        }
        else{
            difficulty = difficulties[2];
        }
    }

    /**
     * Constructor to make the Labyrint with given difficulty. Size is being set according to difficulty.
     * @param difficulty
     */
    public Labyrinth(String difficulty){
        if(difficulty.equals(difficulties[0])){
            height = 100;
            width = 100;
        }
        else if(difficulty.equals(difficulties[1])){
            height = 50;
            width = 50;
        }
        else if(difficulty.equals(difficulties[2])){
            height = 30;
            width = 30;
        }


    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Node getBaseNode() {
        return baseNode;
    }
    public Node getOutNote() {
        return outNote;
    }
    public void generate(){

    }

}
