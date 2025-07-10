import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class FlipyBird extends JPanel implements ActionListener, KeyListener {

    int boredWidth = 360;
    int boredHeight = 640;

    // images
    Image backGroundImage;
    Image birdImage;
    Image topPipeImage;
    Image bottomPipeImage;

    // Bird
    int birdx = boredWidth / 8;
    int birdy = boredHeight / 2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdx;
        int y = birdy;
        int width = birdWidth;
        int height = birdHeight;

        Image img;

        public Bird(Image img) {
            this.img = img;
        }

    }

    // Pipes
    int pipex = boredWidth;
    int pipey = 0;
    int pipeWidth = 64;
    int pipeHight = 512;

    class Pipe {

        int x = pipex;
        int y = pipey;
        int width = pipeWidth;
        int height = pipeHight;
        boolean pased = false;

        Image img;

        public Pipe(Image img) {
            this.img = img;
        }

    }

    // game logic
    Bird bird;
    int velocityx = -4;
    int velocity = 0;
    int gravity = 1;

    ArrayList<Pipe> Pipes;

    Timer gameLoop;
    Timer placePipeTimer;
    boolean gameOver = false;
    double score=0;

    Random random = new Random();

    public FlipyBird() {

        setPreferredSize(new Dimension(boredWidth, boredHeight));
        setFocusable(true);
        addKeyListener(this);

        // Load images
        backGroundImage = new ImageIcon(getClass().getResource("/flappybirdbg.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("/flappybird.png")).getImage();
        topPipeImage = new ImageIcon(getClass().getResource("/toppipe.png")).getImage();
        bottomPipeImage = new ImageIcon(getClass().getResource("/bottompipe.png")).getImage();

        // Bird
        bird = new Bird(birdImage);

        Pipes = new ArrayList<Pipe>();

        // place Pipe Timer
        placePipeTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });

        placePipeTimer.start();

        // game TImer
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

    }

    public void placePipes() {

        int randomPipeY = (int) (pipey - pipeHight / 4 - Math.random() * (pipeHight / 2));
        int opineningSpace = boredHeight / 4;

        Pipe topPipe = new Pipe(topPipeImage);
        topPipe.y = randomPipeY;
        Pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImage);
        bottomPipe.y = topPipe.y + pipeHight + opineningSpace;
        Pipes.add(bottomPipe);

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Draw(g);
    }

    public void Draw(Graphics g) {
        // Draw background
        g.drawImage(backGroundImage, 0, 0, boredWidth, boredHeight, null);
        // Draw bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
        // Draw pipes
        for (int i = 0; i < Pipes.size(); i++) {
            Pipe pipe = Pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }
        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        if(gameOver){
            g.drawString("Game Over! Score: " + String.valueOf((int)score), 10 , 35);
        }
        else{
            g.drawString(String.valueOf((int)score), 10, 35);
        }
    }

    public void move() {
        // Bird movement
        velocity += gravity;
        bird.y += velocity;
        bird.y = Math.max(bird.y, 0);
        // Pipes movement
        for (int i = 0; i < Pipes.size(); i++) {
            Pipe pipe = Pipes.get(i);
            pipe.x += velocityx;

            if(!pipe.pased && bird.x > pipe.x + pipe.width){
                pipe.pased = true;
                score+=0.5;
            }

            if(collision(bird, pipe)){
                gameOver = true;
            }

        }
        if (bird.y > boredHeight) {
            gameOver = true;
        }

    }

    boolean collision(Bird a, Pipe b) {
        return a.x < b.x + b.width && // a's top left corner doesn't reach b's top right corner
                a.x + a.width > b.x && // a's top right corner passes b's top left corner
                a.y < b.y + b.height && // a's top left corner doesn't reach b's bottom left corner
                a.y + a.height > b.y; // a's bottom left corner passes b's top left corner
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
            placePipeTimer.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocity = -9;
            if(gameOver){
                gameOver = false;
                Pipes.clear();
                bird.y = birdy;
                velocity = 0;
                score = 0;
                placePipeTimer.start();
                gameLoop.start();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
