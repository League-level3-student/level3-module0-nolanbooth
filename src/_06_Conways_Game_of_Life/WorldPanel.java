package _06_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
    private static final long serialVersionUID = 1L;
    private int cellsPerRow;
    private int cellSize;

    private Timer timer;
    Random ran = new Random();
    // 1. Create a 2D array of Cells. Do not initialize it.
    Cell[][] cells;
    
    public WorldPanel(int w, int h, int cpr) {
        setPreferredSize(new Dimension(w, h));
        addMouseListener(this);
        timer = new Timer(500, this);
        this.cellsPerRow = cpr;

        // 2. Calculate the cell size.
        
       cellSize = ConwaysGameOfLife.WIDTH / ConwaysGameOfLife.CELLS_PER_ROW;
       System.out.println(cellSize);
        // 3a. Initialize the cell array to the appropriate size.
        cells = new Cell[ConwaysGameOfLife.CELLS_PER_ROW][ConwaysGameOfLife.CELLS_PER_ROW];
        
        // 3b. Iterate through the array and initialize each cell.
        for(int i = 0; i < cells.length; i++) {
        	for(int j = 0; j < cells[i].length; j++) {
        		cells[i][j] = new Cell(i,j,cellSize);
        	}
        }
        //    Don't forget to consider the cell's dimensions when 
        //    passing in the location.
        
    }

    public void randomizeCells() {
       boolean isLive;
    	if(ran.nextInt(1) == 1) {
        	isLive = true;
        }else {
        	isLive = false;
        }
    	// 4. Iterate through each cell and randomly set each
        //    cell's isAlive memeber to true or false
    	 for(int i = 0; i < cells.length; i++) {
         	for(int j = 0; j < cells[i].length; j++) {
         		cells[i][j].isAlive = isLive;
         	}
         }
        repaint();
    }

    public void clearCells() {
        // 5. Iterate through the cells and set them all to dead.
    	 for(int i = 0; i < cells.length; i++) {
          	for(int j = 0; j < cells[i].length; j++) {
          		cells[i][j].isAlive = false;
          	}
          }
        repaint();
    }

    public void startAnimation() {
        timer.start();
    }

    public void stopAnimation() {
        timer.stop();
    }

    public void setAnimationDelay(int sp) {
        timer.setDelay(sp);
    }

    @Override
    public void paintComponent(Graphics g) {
        // 6. Iterate through the cells and draw them all
    	System.out.println(cellSize);
    	g.setColor(Color.black);
    	for(int i = 0; i < cells.length; i++) {
          	for(int j = 0; j < cells[i].length; j++) {
          		if(cells[i][j].isAlive == false) {
/*change the last two variables to i and j, makes it look strange*/	g.drawRect(cells[i][j].getX()*10, cells[i][j].getY()*10, cellSize, cellSize);
          		}else {
          			g.fillRect(cells[i][j].getX()*10, cells[i][j].getY()*10, cellSize, cellSize);
          		}
          	}
          }
    	
    	
        // Draw the perimeter of the grid
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    // Advances world one step
    public void step() {
        // 7. iterate through cells and fill in the livingNeighbors array
        //    using the getLivingNeighbors method.
    	 for(int i = 0; i < cells.length; i++) {
           	for(int j = 0; j < cells[i].length; j++) {
           		cells[i][j].liveOrDie(getLivingNeighbors(cells, i, j));
           	}
           }
       // int[][] livingNeighbors = new int[cellsPerRow][cellsPerRow];
       
        // 8. check if each cell should live or die
        
           
        repaint();
    }

    // The method below gets the number of living neighbors around a
    // particular cell in the 2D array. A cell can have up to 8 neighbors.
    //        1   2    3
    //        4  cell  5
    //        6   7    8
    public int getLivingNeighbors(Cell[][] cells, int cellRow, int cellCol){
        int livingNeighbors = 0;
        
        if(cellRow != 0) {
            if(cells[cellRow - 1][cellCol].isAlive) livingNeighbors++;
        }
        
        if(cellRow != cellsPerRow - 1) {
            if(cells[cellRow + 1][cellCol].isAlive) livingNeighbors++;
        }
        if(cellCol != 0) {
            if(cells[cellRow][cellCol - 1].isAlive) livingNeighbors++;
        }
        if(cellCol != cellsPerRow - 1) {
            if(cells[cellRow][cellCol + 1].isAlive) livingNeighbors++;
        }
        if(cellRow != 0 && cellCol != 0) {
            if(cells[cellRow - 1][cellCol - 1].isAlive) livingNeighbors++;
        }
        if(cellRow != cellsPerRow - 1 && cellCol != cellsPerRow - 1) {
            if(cells[cellRow + 1][cellCol + 1].isAlive) livingNeighbors++;
        }
        if(cellRow != 0 && cellCol != cellsPerRow - 1) {
            if(cells[cellRow - 1][cellCol + 1].isAlive) livingNeighbors++;
        }
        if(cellRow != cellsPerRow - 1 && cellCol != 0) {
            if(cells[cellRow + 1][cellCol - 1].isAlive) livingNeighbors++;
        }
        
        return livingNeighbors;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 9. Use e.getX() and e.getY() to get the mouse PIXEL (not cell)
        //    location that was clicked. Each cell is a square with a length of
        //    cellSize, meaning it's possible to click inside of a cell. You
        //    have to determine the cell that was clicked from the pixel
        //    location and toggle the 'isAlive' variable for that cell.

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }
}
