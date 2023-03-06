public class TSprites {
    private int x;
    private int y;

    public TSprites(){
          int x = (int)(Math.random()*1800+1500);
          int y = (int)(Math.random()*900);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
