
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {
    Game game;
    Timer timer;
    ArrayList<Sprite> Things ;
    Stats meStats = new Stats();


    Board(Game game){
        this.game= game;
        setPreferredSize(new Dimension(1500,800));
        setBackground(Color.BLACK);

        timer = new Timer(1000/60, this);
        timer.start();

    }

    public void setup(){
        Things = new ArrayList<Sprite>();
        Things.add(new Player(Color.RED,0,0,40,40));
        for(int i =0; i<meStats.getNumn0(); i++ ){
            Things.add(new Obstacle(Color.white,0,(int)(Math.random() *((meStats.getSafeZone()-meStats.getEndZone())+1) + meStats.getEndZone()) ,200,30));
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
    for( int i=1; i < Things.size(); i++ ){
        Things.get(i).move(this);
    }
    if(game.isUpPressed()){
        Things.get(0).moveUp();
    }
    if(game.isDownPressed()){
        Things.get(0).moveDown();
    }
    if(game.isLeftPressed()){
        Things.get(0).moveLeft();
    }
    if(game.isRightPressed()){
        Things.get(0).moveRight();
    }
    repaint();
    }

    public void checkCollisions(){
        for(int i=1; i<Things.size(); i++) {
            if (Things.get(0).collidesWith(Things.get(i))) {
                Things.get(0).setDie();
            }
        }



        if(Things.get(0).isDie()){
            System.out.println("bruh");
            Things.get(0).setDie(false);
        }

        if(Things.get(0).getyPos() >=meStats.getEndZone()){
            System.out.print("You win");
            Things.get(0).setNextLevel(true);

        }

        if(Things.get(0).isNextLevel()){
            Things.get(0).setNextLevel(false);
            Things.get(0).reset();
        }

        for(int i = 1; i < Things.size(); i++) {
            if(Things.get(0).collidesWith(Things.get(i))){
                System.out.print("You died bruh");
                Things.get(0).reset();
            }
        }
    }


    public void paintComponent(Graphics g ){
        super.paintComponent(g);
        for(Sprite index : Things){
            index.paint(g);
        }
    }
}
