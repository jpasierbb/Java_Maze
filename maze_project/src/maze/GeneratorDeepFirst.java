package maze;

import java.io.Serializable;
import java.util.*;

public class GeneratorDeepFirst implements Serializable {
    private Labyrinth labyrinth;
    private final Random random = new Random();
    private enum Directions{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    private Node nextNode;
    private int x;
    private Deque<Node> stack = new ArrayDeque<>();
    private Set<Node> beenThere = new HashSet<>();
    private List<Directions> directions = new ArrayList<>();
    private List<Directions> dir = Arrays.asList(Directions.values());

    public GeneratorDeepFirst(Labyrinth labyrinth){
        this.labyrinth = labyrinth;
        stack.addFirst(this.labyrinth.getBaseNode());
        RDF(this.labyrinth.getBaseNode());
        labyrinth.setOutNote(labyrinth.nodesToString[getLabyrinth().getWidth()-1][getLabyrinth().getHeight()-1]);
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    private void RDF(Node node){
        directions.removeAll(directions);
        directions.addAll(dir);
        while (true){
            if(directions.size()==0) {
                if (!stack.isEmpty()) {
                    RDF(stack.pop());
                    break;
                } else {
                    break;
                }
            }
            x = random.nextInt(100)%directions.size();
            switch (directions.get(x)){
                case UP -> {
                    if(node.getUpNext()!=null && !beenThere.contains(node.getUpNext()) ){
                        nextNode = node.getUpNext();
                        node.setUpWall(false);
                        nextNode.setDownWall(false);
                        stack.addFirst(nextNode);
                        beenThere.add(nextNode);
                        RDF(nextNode);
                        break;
                    }
                    else{
                        directions.remove(Directions.UP);
                    }
                }
                case DOWN -> {
                    if(node.getDownNext()!=null && !beenThere.contains(node.getDownNext())){
                        nextNode = node.getDownNext();
                        node.setDownWall(false);
                        nextNode.setUpWall(false);
                        stack.addFirst(nextNode);
                        beenThere.add(nextNode);
                        RDF(nextNode);
                        break;
                    }
                    else{
                        directions.remove(Directions.DOWN);
                    }
                }
                case LEFT -> {
                    if(node.getLeftNext()!=null && !beenThere.contains(node.getLeftNext())){
                        nextNode = node.getLeftNext();
                        node.setLeftWall(false);
                        nextNode.setRightWall(false);
                        stack.addFirst(nextNode);
                        beenThere.add(nextNode);
                        RDF(nextNode);
                        break;
                    }
                    else{
                        directions.remove(Directions.LEFT);
                    }

                }
                case RIGHT -> {
                    if(node.getRightNext()!=null && !beenThere.contains(node.getRightNext())){
                        nextNode = node.getRightNext();
                        node.setRightWall(false);
                        nextNode.setLeftWall(false);
                        stack.addFirst(nextNode);
                        beenThere.add(nextNode);
                        RDF(nextNode);
                        break;
                    }
                    else{
                        directions.remove(Directions.RIGHT);
                    }

                }

            }

        }
        }
        public static void main(String[] args){
            Labyrinth l1 = new Labyrinth(Labyrinth.Difficulty.EASY);
            GeneratorDeepFirst generatorDeepFirst = new GeneratorDeepFirst(l1);
            l1 = generatorDeepFirst.getLabyrinth();
            Labyrinth l2 = new Labyrinth(Labyrinth.Difficulty.MEDIUM);
            System.out.println(l1.getBaseNode());
            System.out.println(l1.getBaseNode().getRightNext());
            System.out.println(l1.getBaseNode().getDownNext());
            System.out.println(l1.getBaseNode().getDownNext().getRightNext());
        }
    }

