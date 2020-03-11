import java.awt.*;

public class Player extends Sprite{

    public Player(Color color, int x, int y, int width, int height){
        super(color, x, y, width, height);

    }
    @Override
    public void paint(Graphics g ){
        g.setColor(getColor());
        g.fillOval(getxPos(),getyPos(),getWidth(),getHeight());
    }

}
