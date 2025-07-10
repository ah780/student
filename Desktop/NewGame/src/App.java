
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

        int boredWidth = 360;
        int boredHeight = 640;

        JFrame frame = new JFrame("Flupy Bired");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(boredWidth, boredHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        FlipyBird flipyBird = new FlipyBird();
        frame.add(flipyBird);
        frame.pack();
        flipyBird.requestFocus();
        frame.setVisible(true);

    }
}
