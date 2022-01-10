package maze;


import java.sql.SQLOutput;
import java.util.*;

public class Labyrinth {
    private int height = 0;
    private int width = 0;
    private String difficulty = "";
    private String[] difficulties = {"hard","medium","easy"}; //Pre-defined difficulties
    private Node baseNode = null;
    private Node outNote = null;
    public enum Algorithm {
        RANDOMIZED_DEPTH__FIRST,
    }

    /**
     * Constructor to make the Labyrint with given height and width. Difficulty is being set according to size.
     * @param width
     * @param height
     */
    public Labyrinth(int width, int height){
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
        generateGrid();
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
        generateGrid();
    }
    private void generateGrid(){
        if(height<10 || width<10){
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
    public void generate(Algorithm algorithm){
        switch (algorithm){
            case RANDOMIZED_DEPTH__FIRST -> rdf_alg();
        }
    }

    private void rdf_alg(){
        Deque<Node> stack = new ArrayDeque<>();
        Node node = baseNode;
        Node nextNode = new Node();
        Random random = new Random();
        while (true){
            int num = random.nextInt(0,3);
            if(num==0){
                if(node.getUpNext() != null){
                    nextNode = node.getUpNext();
                }
            } else if(num==1){
                if(node.getRightNext() != null){
                    nextNode = node.getRightNext();
                }
            } else if(num==2){
                if(node.getDownNext() != null){
                    nextNode = node.getDownNext();
                }
            }
            else {
                if(node.getLeftNext() != null){
                    nextNode = node.getLeftNext();
                }
            }
            if(!stack.contains(nextNode)){
                if(num==0){
                    nextNode.setDownWall(false);
                    node.setUpWall(false);
                } else if(num==1){
                    nextNode.setLeftWall(false);
                    node.setRightWall(false);
                } else if(num==2) {
                    nextNode.setUpWall(false);
                    node.setDownWall(false);
                }
                else {
                    nextNode.setRightWall(false);
                    node.setLeftWall(false);
                }
                stack.addFirst(nextNode);
                node = nextNode;
            }
            else {
                node = stack.remove();
            }

        }
    }

    public static void main(String[] args) {
        Labyrinth L1 = new Labyrinth(10, 10);
        Labyrinth L2 = new Labyrinth("hard");
    }
}
