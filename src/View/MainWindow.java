package View;



import Model.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainWindow extends JFrame {

    private Container mainContainer;

    public MainWindow(){
        super("Maze'olver");

        setBounds(10, 10, 1100, 750);

        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });




        mainContainer = this.getContentPane();

        this.setLayout(new BorderLayout());
        Maze maze = new Maze(21, 13, 50);
        mainContainer.add(maze, BorderLayout.CENTER);
        mainContainer.add(new ButtonPanel(maze), BorderLayout.SOUTH);

        //setResizable(false);
        setVisible(true);
    }
}
