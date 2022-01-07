package maze;


import java.util.*;

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
        baseNode = new Node();
        /*
        Generate grid of nodes in loop
         */
        Node node = baseNode;
        Node nextHeightNode = new Node();
        Node nextWidthNode = new Node();
        List<Node> nodes = new ArrayList<>();
        List<Node> nextNodes = new ArrayList<>();
        nodes.add(baseNode);
        for(int i=1;i<width;i++){
            for (int n = 1;n<height;n++){
                node.setDownNext(nextHeightNode);
                nextHeightNode.setUpNext(node);
                if(!nodes.isEmpty()){
                    Node leftNode = nodes.get(n);
                    nextHeightNode.setLeftNext(leftNode);
                    leftNode.setRightNext(nextHeightNode);
                }
                nextNodes.add(nextHeightNode);
            }



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
