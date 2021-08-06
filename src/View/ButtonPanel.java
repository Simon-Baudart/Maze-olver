package View;

import Model.Maze;
import View.Listeners.GenerateButtonListener;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    JButton generateButton;
    Maze maze;

    public ButtonPanel(Maze maze) {
        generateButton = new JButton("Generate");
        GenerateButtonListener generateButtonListener = new GenerateButtonListener(maze);
        generateButton.addActionListener(generateButtonListener);

        this.setLayout(new FlowLayout());
        this.add(generateButton);
    }
}
