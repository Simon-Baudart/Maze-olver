package View;

import Model.Cell;
import Model.Maze;

public class GenerateThread extends Thread{

    private Maze maze;

    public GenerateThread(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void run() {
        while (maze.isStillUnvisitedCells()){
            try {
                Thread.sleep(10);
                maze.generate();
                maze.repaint();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        maze.getCurrent().setCurrent(false);
        maze.setStart(0,0);
        maze.setEnd(maze.getCols()-1,maze.getRows()-1);
    }
}
