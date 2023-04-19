public class Variables {
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public Variables(){
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public void setUp(boolean in){
        up = in;
    }

    public void setDown(boolean in){
        down = in;
    }

    public void setLeft(boolean in){
        left = in;
    }

    public void setRight(boolean in){
        right = in;
    }

    public boolean getUp(){
        return up;
    }

    public boolean getDown(){
        return down;
    }

    public boolean getLeft(){
        return left;
    }

    public boolean getRight(){
        return right;
    }

}
