package Model;

import View.GenerateThread;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Maze extends JPanel {
    Cell cells[][];
    Integer cols, rows, width, iStack;
    Cell current;
    Stack stack;


    public Maze(Integer cols, Integer rows, Integer width) {
        this.cols = cols;
        this.rows = rows;
        this.width = width;
        this.cells = new Cell[cols][rows];
        this.stack = new Stack();
        this.iStack = 0;

        for (int i = 0 ; i<cols ; i++){
            for (int j = 0 ; j < rows ; j++){
                cells[i][j] = new Cell(i, j, this);
            }
        }

        current = cells[0][0];

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0 ; i < cols ; i++){
            for (int j = 0 ; j < rows ; j++){
                cells[i][j].draw(g);
            }
        }
    }

    public void repaint(Graphics g){
        for (int i = 0 ; i < cols ; i++){
            for (int j = 0 ; j < rows ; j++){
                cells[i][j].draw(g);
            }
        }
    }

    public void generate(){

        current.setVisited(true);
        current.setCurrent(true);
        Cell next = current.checkNeighbors();
        if(next != null){
            next.setVisited(true);

            stack.push(current);
            iStack++;

            removeWalls(current, next);

            current.setCurrent(false);
            current = next;
            current.setCurrent(true);
        }
        else if(iStack > 0){
            Cell cell = (Cell) stack.pop();
            current.setCurrent(false);
            current = cell;
            current.setCurrent(true);
            iStack--;
        }
    }

    public void removeWalls(Cell a, Cell b){
        int x = a.getI() - b.getI();
        if(x == 1){
            a.getWalls()[3] = false;
            b.getWalls()[1] = false;
        }
        else if(x == -1){
            a.getWalls()[1] = false;
            b.getWalls()[3] = false;
        }
        int y = a.getJ() - b.getJ();
        if(y == 1){
            a.getWalls()[0] = false;
            b.getWalls()[2] = false;
        }
        else if(y == -1){
            a.getWalls()[2] = false;
            b.getWalls()[0] = false;
        }

    }

    public boolean isStillUnvisitedCells(){
        for (int i = 0 ; i < cols ; i++){
            for (int j = 0 ; j < rows ; j++){
                if(!cells[i][j].getVisited()) return true;
            }
        }
        return false;
    }

    public int getMazeWidth(){
        return width;
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getRows() {
        return rows;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCurrent(Cell current) {
        this.current = current;
    }

    public Cell getCurrent() {
        return current;
    }

    public void setStart(int i, int j){
        cells[i][j].setStart(true);
    }

    public void setEnd(int i, int j){
        cells[i][j].setEnd(true);
    }
    
}
