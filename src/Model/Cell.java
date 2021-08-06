package Model;

import java.awt.*;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

public class Cell {
    private Integer i, j;
    private Boolean[] walls;
    private Boolean visited, current, start, end;
    private Maze maze;

    public Cell(Integer i, Integer j, Maze maze) {
        this.i = i;
        this.j = j;
        this.maze = maze;
        this.walls = new Boolean[]{true, true, true, true};
        this.visited = false;
        this.current = false;
        this.start = false;
        this.end = false;
    }

    public void draw(Graphics g){
        int w = maze.getMazeWidth();
        if(!visited) g.setColor(new Color(41, 81, 166));
        else g.setColor(new Color(224, 150, 150));
        if(current) g.setColor(new Color(36, 157, 166));
        if(start) g.setColor(new Color(14, 194, 113));
        if(end) g.setColor(new Color(179, 16, 76));

        g.fillRect(i*w, j*w, w, w);
        g.setColor(new Color(0, 0, 0));
        if(walls[0]){
            g.fillRect(i*w, j*w, w, 1);
        }
        if(walls[1]){
            g.fillRect(i*w + w - 1, j*w, 1, w);
        }
        if(walls[2]){
            g.fillRect(i*w, j*w + w - 1, w, 1);
        }
        if(walls[3]){
            g.fillRect(i*w, j*w, 1, w);
        }
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Cell checkNeighbors(){
        Cell top;
        Cell right;
        Cell bottom;
        Cell left;
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        try{
            top = maze.getCells()[i][j-1];
        }
        catch (ArrayIndexOutOfBoundsException e){
            top = null;
        }
        try{
            right = maze.getCells()[i+1][j];
        }
        catch (ArrayIndexOutOfBoundsException e){
            right = null;
        }
        try{
            bottom = maze.getCells()[i][j+1];
        }
        catch (ArrayIndexOutOfBoundsException e){
            bottom = null;
        }
        try{
            left = maze.getCells()[i-1][j];
        }
        catch (ArrayIndexOutOfBoundsException e){
            left = null;
        }

        if(top != null && !top.visited) neighbors.add(top);
        if(right != null && !right.visited) neighbors.add(right);
        if(bottom != null && !bottom.visited) neighbors.add(bottom);
        if(left != null && !left.visited) neighbors.add(left);

        if(neighbors.size() > 0){
            int index = Util.randInt(0, neighbors.size()-1);
            return neighbors.get(index);
        }
        else{
            return null;
        }
    }

    public Integer getI() {
        return i;
    }

    public Integer getJ() {
        return j;
    }

    public Boolean[] getWalls() {
        return walls;
    }

    public Boolean getVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }
}
