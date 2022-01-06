package maze;

class Node<I>{
    private Node<I> upNext;
    private Node<I> downNext;
    private Node<I> rightNext;
    private Node<I> leftNext;

    private boolean upWall;
    private boolean downWall;
    private boolean rightWall;
    private boolean leftWall;

    public Node(I value) {
        this.downNext = null;
        this.leftNext = null;
        this.upNext = null;
        this.rightNext = null;
        this.upWall = true;
        this.downWall = true;
        this.rightWall = true;
        this.leftWall = true;
    }

    public Node<I> getUpNext() {
        return upNext;
    }

    public void setUpNext(Node<I> upNext) {
        this.upNext = upNext;
    }

    public Node<I> getDownNext() {
        return downNext;
    }

    public void setDownNext(Node<I> downNext) {
        this.downNext = downNext;
    }

    public Node<I> getRightNext() {
        return rightNext;
    }

    public void setRightNext(Node<I> rightNext) {
        this.rightNext = rightNext;
    }

    public Node<I> getLeftNext() {
        return leftNext;
    }

    public void setLeftNext(Node<I> leftNext) {
        this.leftNext = leftNext;
    }

    public boolean isUpWall() {
        return upWall;
    }

    public void setUpWall(boolean upWall) {
        this.upWall = upWall;
    }

    public boolean isDownWall() {
        return downWall;
    }

    public void setDownWall(boolean downWall) {
        this.downWall = downWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    @Override
    public String toString() {
        return "Node{" +
                "upWall=" + upWall +
                ", downWall=" + downWall +
                ", rightWall=" + rightWall +
                ", leftWall=" + leftWall +
                '}';
    }
}