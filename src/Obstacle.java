import java.awt.*;

public class Obstacle extends Sprite {

    public Obstacle(Color color, int x, int y, int width, int height){
        super(color, x, y, width, height);

    }
    @Override
    public void paint(Graphics g ){
        g.setColor(getColor());
        g.fillRect(getxPos(),getyPos(),getWidth(),getHeight());
    }

}
