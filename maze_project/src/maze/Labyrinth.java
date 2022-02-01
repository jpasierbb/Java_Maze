package maze;


import javax.imageio.plugins.bmp.BMPImageWriteParam;
import javax.lang.model.element.UnknownAnnotationValueException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.*;

public class Labyrinth implements Serializable {
    protected int height = 0;
    protected int width = 0;
    private Difficulty difficulty;
    protected Node baseNode = null;
    private Node outNote = null;
    protected Node[][] nodesToString;
    public enum Difficulty {
        HARD,
        MEDIUM,
        EASY
    }
    /**
     * Constructor to make the Labyrint with given height and width. Difficulty is being set according to size.
     * @param width
     * @param height
     */
    public Labyrinth(int width, int height){
        if(width<5 || height<5){
            throw new WrongSizeException("Too small size of the Labyrint",width,height);
        }
        this.height = height;
        this.width = width;
        int size = width*height;
        if(size>=400){
            difficulty = Difficulty.HARD;
        }
        else if(size>=100){
            difficulty = Difficulty.MEDIUM;
        }
        else{
            difficulty = Difficulty.EASY;
        }
        generateGrid();
    }


    /**
     * Constructor to make the Labyrint with given difficulty. Size is being set according to difficulty.
     * @param difficulty
     */
    public Labyrinth(Difficulty difficulty){
        switch (difficulty){
            case HARD ->{
                height=20;
                width=20;
            }
            case MEDIUM -> {
                height = 10;
                width = 10;
            }
            case EASY -> {
                height = 5;
                width = 5;
            }
        }
        generateGrid();
    }
    private Node[][]  generateGrid(){
        if(height<5 || width<5){
            throw new WrongSizeException("Too small size of the Labyrint",width,height);
        }
        baseNode = new Node();
        Node node = baseNode;
        Node[][] Nodes = new Node[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(i == 0 && j == 0) Nodes[i][j] = node;
                else Nodes[i][j] = new Node();
            }
        }
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(i == 0){
                    if(j == 0){
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                    else if(j == (height - 1)){
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                    }
                    else{
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                }
                else if(i == (width - 1)){
                    if(j == 0){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                    else if(j == (height - 1)){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                    }
                    else{
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                }
                else{
                    if(j == 0){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                    }
                    else if(j == (height - 1)){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                    }
                    else{
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                    }
                }
            }
        }
        //Nodes[7][8].setDownWall(false);
        return nodesToString = Nodes;
    }

    @Override
    public String toString() {
        for(int h=0;h<height;h++){
            for(int w=0;w<width;w++){
                if(nodesToString[w][h].isUpWall()){
                    System.out.print("*---*");
                }else System.out.print("*   *");
            }
            System.out.print("\n");
            for(int w=0;w<width;w++){
                if(nodesToString[w][h].isRightWall() && nodesToString[w][h].isLeftWall()){
                    if(nodesToString[w][h]==baseNode || nodesToString[w][h]==outNote){
                        System.out.print("| X |");
                    }else System.out.print("|   |");

                }
                else if(nodesToString[w][h].isRightWall()){
                    if(nodesToString[w][h]==baseNode || nodesToString[w][h]==outNote){
                        System.out.print("  X |");
                    }else System.out.print("    |");

                }
                else if(nodesToString[w][h].isLeftWall()){
                    if(nodesToString[w][h]==baseNode || nodesToString[w][h]==outNote){
                        System.out.print("| X  ");
                    }else System.out.print("|    ");

                }
                else {
                    if(nodesToString[w][h]==baseNode || nodesToString[w][h]==outNote){
                        System.out.print("  X  ");
                    }else System.out.print("     ");
                }
            }
            System.out.print("\n");
            for(int w=0;w<width;w++){
                if(nodesToString[w][h].isDownWall()){
                    System.out.print("*---*");
                }
                else System.out.print("*   *");
            }
            System.out.print("\n");
        }
        return "";
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Node getBaseNode() {
        return baseNode;
    }
    public void setBaseNode(Node baseNode){
        this.baseNode = baseNode;
    }
    public Node getOutNote() {
        return outNote;
    }

    public void setOutNote(Node outNote) {
        this.outNote = outNote;
    }
    // Raczej idziemy w strone klasy zagniezdzonej generator z wlasnym stackiem i wywolaniem rekurencyjnym algorytmu



    public static void main(String[] args) {
        Labyrinth L1 = new Labyrinth(6, 6);
        Labyrinth L2 = new Labyrinth(6,6); //Stack overflow >50x50
        GeneratorDeepFirst generatorDeepFirst = new GeneratorDeepFirst(L2);
        GeneratorAldusBroder generatorAldusBroder = new GeneratorAldusBroder(L1);
        L2 = generatorDeepFirst.getLabyrinth();
        System.out.println(L2);
        System.out.print(L1);
        System.out.println("\n");
        File.save(L1,"lab1");
        File.load(L2,"lab1");

    }
}
