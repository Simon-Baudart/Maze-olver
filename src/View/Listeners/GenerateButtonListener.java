package View.Listeners;

import Model.Maze;
import View.GenerateThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButtonListener implements ActionListener {
    Maze maze;

    public GenerateButtonListener(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GenerateThread thread = new GenerateThread(maze);
        thread.start();
    }
}
