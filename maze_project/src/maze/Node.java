package maze;

class Node<I>{
    private Node<I> upNext;
    private Node<I> downNext;
    private Node<I> rightNext;
    private Node<I> leftNext;

    private I value;

    public Node(I value) {
        this.value = value;
        this.downNext = null;
        this.leftNext = null;
        this.upNext = null;
        this.rightNext = null;
    }

    public I getValue() {
        return value;
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
}