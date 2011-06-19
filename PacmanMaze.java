import java.util.ArrayList;
/**
 * PacmanMaze is a kind of maze that keeps track of containing dots.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class PacmanMaze extends Maze
{
    private static final String GHOST_STRING = "G";
    private static final String PAC_STRING = "P";
    private static final String DOT = "D";
    
    /**
     * Initialize the dots and the count of dots left.
     */
    public PacmanMaze()
    {
        super();
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                grid[i][j] = new Dot();
            }
        }
        //adding walls for testing
        grid[1][1] = new Wall();
        grid[1][2] = new Wall();
        grid[1][3] = new Wall();
        grid[1][4] = new Wall();
        grid[2][4] = new Wall();
        grid[3][4] = new Wall();
        grid[4][4] = new Wall();
        
        //making monsters
        monsters = new ArrayList<Monster>();
        Monster m1 = new Monster(this); //create a mouse
        monsters.add(m1); //add it to the list
    }

    /**
     * "Resolves" the new state of the game.
     */
    public void resolve()
    {
        eat(p.getX(), p.getY());
        System.out.print("\f"); //form feed "clears" the console (at least on Mac).
        print("");
        System.out.print(COMMAND_REQUEST);
    }
    
    /**
     * Has Pacman eaten all the dots yet.
     * @return true if Pacman has eaten all the dots.
     */
    public boolean hasWon()
    {
        // if all dots are gone. (all grid are true)
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                if (grid[i][j] != null) {
                    if(grid[i][j].getLetter().equals("D"))
                    {
                        return false;
                    }
                }
            }
        }
        return true;          
    }
    
    /**
     * Removes a 'dot' indicated by the supplied coordinates from the Grid.
     */
    public void eat(int i, int j) 
    {
        grid[i][j] = null;
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
            return GHOST_STRING;
        }
        else if ((i == p.getX()) && (j == p.getY())) {
            return PAC_STRING;  //elephant has precendence over traps.
        }
        else if(grid[i][j] == null) {
            return EMPTY;
        }
        else return ""; //empty space
    }
}