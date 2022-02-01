package maze;

public class GeneratorKruskal {
    protected static class Wall_vertical{
        protected Node up;
        protected Node down;
        public Wall_vertical(Node up, Node down){
            this.down = down;
            this.up = up;
        }
    }
    protected static class Wall_horizont{
        protected Node left;
        protected Node right;
        public Wall_horizont(Node left, Node right){
            this.left = left;
            this.right = right;
        }
    }
}
