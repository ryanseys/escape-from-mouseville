import java.awt.*; // The Point class needs this.
import java.util.ArrayList;
/**
 * Mouseville is essentially a grid containing the elephant, 
 * an exit, and potentially a few mousetraps if dropped by the elephant.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Mouseville extends Maze
{
    // instance variables
    public static final String MOUSE_STRING = "M";
    public static final String TRAP_STRING = "T";
    public static final String ELEPHANT_STRING = "E";
    /**
     * Initialize the elephant, the mice, the grid, and the exit (middle of the grid).
     * - the grid is an array of booleans, where "true" means there's a mousetrap.
     * - the mice are stored in an arraylist (you can create a few here).
     * - the exit is a Point (from the java.awt package), used to represent coordinates.
     */
    public Mouseville()
    {
        //initialized a grid full of false values
        super("Mouseville");
        grid[DEFAULT_EXIT_X][DEFAULT_EXIT_Y] = new Exit(); 
        // exit is given an set point. this can be changed later.
        
        //adding walls for testing
        grid[1][1] = new Wall();
        grid[1][2] = new Wall();
        grid[1][3] = new Wall();
        grid[1][4] = new Wall();
        grid[2][4] = new Wall();
        grid[3][4] = new Wall();
        grid[4][4] = new Wall();
        //makin monster
        monsters = new ArrayList<Monster>();
        Monster m1 = new Monster(this); //create a mouse
        monsters.add(m1); //add it to the list
    }

    /**
     * "Resolves" the new state of the game.
     */
    public void resolve()
    {
        int index = 0;
        boolean toRemove = false;
        for (Monster m : monsters)
        {
             if (grid[m.getX()][m.getY()] == null);
             else if (grid[m.getX()][m.getY()].getLetter().equals("T"))
             {
                 grid[m.getX()][m.getY()] = null; //remove trap from grid.
                 index = monsters.indexOf(m); //remove mouse from list.
                 toRemove = true;
             }
        }
        if (toRemove)
        {
            monsters.remove(index); //works only with 1 value right now
        }
        
        System.out.print("\f"); //form feed "clears" the console (at least on Mac).
        print("");
        System.out.print(COMMAND_REQUEST);
    }
    
    /**
     * Set a mousetrap at the indicated coordinate.
     * @param  x   x-coordinate to set the trap at.
     * @param  y   y-coordinate to set the trap at.
     */
    public void setMousetrap(int x, int y) 
    {
        grid[x][y] = new Mousetrap();
    }
    
    /**
     * Has the elephant reached the exit yet.
     * @return true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        if(grid[p.getX()][p.getY()] != null) {
            if(grid[p.getX()][p.getY()].getLetter().equals("X")) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * A new function added such that if the game board 
     * contains a null Object (no Item there), then
     * continue to check for specific objects like monster
     * or player.
     * 
     * Including a function like this simplified toString a lot!
     **/
    public String gridNull(int i, int j) {
        if (hasMonster(i,j)) {
            return MOUSE_STRING;
        }
        else if ((i == p.getX()) && (j == p.getY())) {
            return ELEPHANT_STRING;  //elephant has precendence over traps.
        }
        else if(grid[i][j] == null) {
            return EMPTY;
        }
        else return ""; //empty space
    }
}