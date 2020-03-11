import java.awt.*;

public abstract class Sprite {
 int xPos, yPos, width, height;
 double dx=-40,dy;
 Color color;
Board board;
boolean die=false, nextLevel;
public  int level;

    public Sprite(Color color, int x, int y, int width, int height){
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.level=1;

    }



    public void move(Board board){
        this.board= board;


        if(xPos <= 0){
            dx*=-1;
        }
        if(xPos >= board.getWidth() - getWidth()){
            dx*=-1;
        }
        xPos+=dx;
    }

    public void moveRight(){
        dx=-10;

            xPos -= dx;

    }
    public void moveLeft() {
        dx = -10;

            xPos += dx;

    }
    public void moveUp(){
        dy=10;

            yPos -= dy;

    }
    public void moveDown(){
        dy=10;

            yPos += dy;

    }

    public abstract void paint(Graphics g );

    public boolean collidesWith(Sprite other){
        return getBounds().intersects(other.getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos,width,height);
    }

    public void setDie(){
        die = true;
    }

    public void reset(){
        xPos = 0;
        yPos=0;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isDie() {
        return die;
    }

    public void setDie(boolean die) {
        this.die = die;
    }

    public  int getLevel() {
        return level;
    }

    public  void setLevel(int level) {
        this.level = level;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public boolean isNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(boolean nextLevel) {
        this.nextLevel = nextLevel;
    }

    public void updatelevel(){
        switch(level){
            case 1:
                setDx(-20);
                break;
            case 2:
                setDx(-30);
                break;
            case 3:
                setDx(-40);
                break;
        }
    }
}
