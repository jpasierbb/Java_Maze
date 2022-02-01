package maze;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneratorAldusBroder {
    private final Labyrinth labyrinth;
    private Set<Node> beenThere;
    private final int size;
    Random random = new Random();
    private enum Directions{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    public GeneratorAldusBroder(Labyrinth labyrinth){
        this.labyrinth = labyrinth;
        size = labyrinth.getHeight()* labyrinth.getWidth();
        beenThere = new HashSet<>();
        //Pick random starting node:
        Node startNode = labyrinth.nodesToString[random.nextInt(labyrinth.getWidth()-1)][labyrinth.getHeight()-1];
        ABA(startNode);
        labyrinth.setOutNote(labyrinth.nodesToString[getLabyrinth().getWidth()-1][getLabyrinth().getHeight()-1]);

    }
    private void ABA(Node node){
        Node nextNode;
        Directions[] directions = Directions.values();
        int i = 0;
        while (i<1000){
            if(beenThere.size()>=size){
                break;
            }
            switch (directions[random.nextInt(100)&3]){
                case UP -> {
                    if(node.getUpNext()!=null){
                        nextNode = node.getUpNext();
                        if(!beenThere.contains(nextNode)){
                            node.setUpWall(false);
                            nextNode.setDownWall(false);
                            beenThere.add(nextNode);
                        }
                        node = nextNode;
                    }
                }
                case DOWN -> {
                    if(node.getDownNext()!=null){
                        nextNode = node.getDownNext();
                        if(!beenThere.contains(nextNode)){
                            node.setDownWall(false);
                            nextNode.setUpWall(false);
                            beenThere.add(nextNode);
                        }
                        node = nextNode;
                    }
                }
                case RIGHT -> {
                    if(node.getRightNext()!=null){
                        nextNode = node.getRightNext();
                        if(!beenThere.contains(nextNode)){
                            node.setRightWall(false);
                            nextNode.setLeftWall(false);
                            beenThere.add(nextNode);
                        }
                        node = nextNode;
                    }
                }
                case LEFT -> {
                    if(node.getLeftNext()!=null){
                        nextNode = node.getLeftNext();
                        if(!beenThere.contains(nextNode)){
                            node.setLeftWall(false);
                            nextNode.setRightWall(false);
                            beenThere.add(nextNode);
                        }
                        node = nextNode;
                    }
                }
            }
        }
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public static void main(String[] args){
        Labyrinth L1 = new Labyrinth(Labyrinth.Difficulty.MEDIUM);
        GeneratorAldusBroder generatorAldusBroder = new GeneratorAldusBroder(L1);
        L1 = generatorAldusBroder.getLabyrinth();
        System.out.println(L1);
    }
}
