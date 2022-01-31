package maze;

import java.util.*;

public class Generator {
    private Labyrinth labyrinth;
    private final Random random = new Random();
    private enum Directions{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    private Deque<Node> stack = new ArrayDeque<>();

    public Generator(Labyrinth labyrinth){
        this.labyrinth = labyrinth;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void RDF(Node node){
        List<Directions> directions = Arrays.asList(Directions.values());
        Node nextNode;
        while (true){
            if(directions.size()==0){
                if(!stack.isEmpty()){
                    RDF(stack.pop());
                }
                else break;
            }
            switch (directions.get(random.nextInt(directions.size()-1))){
                case UP -> {
                    if(node.getUpNext()!=null && !stack.contains(node.getUpNext()) ){
                        nextNode = node.getUpNext();
                        node.setUpWall(false);
                        nextNode.setDownWall(false);
                        stack.addFirst(nextNode);
                        RDF(nextNode);
                    }
                    else{
                        directions.remove(Directions.UP);
                    }
                }
                case DOWN -> {
                    if(node.getDownNext()!=null && !stack.contains(node.getDownNext())){
                        nextNode = node.getDownNext();
                        node.setDownWall(false);
                        nextNode.setUpWall(false);
                        stack.addFirst(nextNode);
                        RDF(nextNode);
                    }
                    else{
                        directions.remove(Directions.DOWN);
                    }
                }
                case LEFT -> {
                    if(node.getLeftNext()!=null && !stack.contains(node.getLeftNext())){
                        nextNode = node.getLeftNext();
                        node.setLeftWall(false);
                        nextNode.setRightWall(false);
                        stack.addFirst(nextNode);
                        RDF(nextNode);
                    }

                }
                case RIGHT -> {
                    if(node.getRightNext()!=null && !stack.contains(node.getRightNext())){
                        nextNode = node.getRightNext();
                        node.setRightWall(false);
                        nextNode.setLeftWall(false);
                        stack.addFirst(nextNode);
                        RDF(nextNode);
                    }

                }

            }

        }
        }
    }

