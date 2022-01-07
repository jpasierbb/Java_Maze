package maze;

public class WrongSizeException extends RuntimeException{
    private int height;
    private int width;
    public WrongSizeException(String message, int width, int height){
        super(message);
        this.height = height;
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth(){
        return width;
    }
}
