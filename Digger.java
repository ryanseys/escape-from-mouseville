import java.util.Random;
import java.util.ArrayList;
/**
 * Dig holes to be awarded points. If you get winning amount of points, you win.
 * Watch out for monsters and kill them all by setting a bomb! But it costs
 * points to use bombs so don't use them too often.
 * 
 * @author Ryan Seys
 * @version 1
 */
public class Digger extends Maze
{
    // instance variables - replace the example below with your own
    public static final String MONSTER_STRING = "M";
    public static final String DIGGER_STRING = "P";
    private int points = 1000; //initial points set to 1000
    private ArrayList<Hole> holes;
    private static final int WINNING_POINTS = 2000; // you need 2000 points to win!
    /**
     * Constructor for objects of class Digger
     */
    public Digger() 
    {
        super("Digger");
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                grid[i][j] = null;
            }
        }
        //initialize some holes.
        grid[2][3] = new Hole();
        grid[4][1] = new Hole();
        grid[1][0] = new Hole();
        grid[3][4] = new Hole();
    }
    
    /**
     * "Resolves" the new state of the game.
     */
    public void resolve()
    {
        System.out.print("\f"); //form feed "clears" the console (at least on Mac).
        print("Score : " + points);
        System.out.print(COMMAND_REQUEST);
    }
    
    /**
     * Has the elephant reached the exit yet.
     * @return true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        if(points >= WINNING_POINTS) {
            return true;
        }
        else return false;
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
            return MONSTER_STRING;
        }
        else if ((i == p.getX()) && (j == p.getY())) {
            return DIGGER_STRING;  //elephant has precendence over traps.
        }
        else if(grid[i][j] == null) {
            return EMPTY;
        }
        else return ""; //empty space
    }
    
    /**
     * Adds points to the player's points.
     */
    public void addPoints(int amount)
    {
        points += amount;
    }
    
    /**
     * Add a hole (X) to the game board.\
     * Hole is an Item.
     */
    public void addHole(int x, int y) {
        grid[x][y] = new Hole();
    }
    
    /**
     * Get how many holes are on the game board.
     * As you dig more holes, more are produced
     * to keep the game going!
     */
    public int getHolesCount() {
        int count = 0;
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                if(grid[i][j] instanceof Hole) {
                    count +=1;
                }
            }
        }
        return count;
        }
}