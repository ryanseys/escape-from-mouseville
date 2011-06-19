/**
 * The Elephant is a creature that has coordinates
 * in a maze It can move in that maze (up, down, 
 * left, right), and it also has a limited number 
 * of mousetraps that it can drop in the maze. 
 * (the elephant is indeed terrified of the deadly mice!)
 * 
 * @author Ryan Seys
 * @version 1.1
 */
public class Elephant extends Player
{
    private int mousetraps;
    private static final int DEFAULT_MOUSETRAPS = 3;
    private static final String INVALID_CMD = "Invalid command";
    private static final String QUIT_RESPONSE = "You have quit.";
    private static final String NO_MTRAPS = "You don't have any more mousetraps left.";
    
    /**
     * Assign the maze and set the coordinates to the ones supplied by the parameters
     */
    public Elephant(int x, int y, Maze m)
    {
        super(x, y, m);
        mousetraps = DEFAULT_MOUSETRAPS;
    }
    
    /**
     * Assign the maze, and give an initial position (0, 0)
     */
    public Elephant(Maze m)
    {
        // initialise instance variables
        super(m);
        mousetraps = DEFAULT_MOUSETRAPS;
    }
    
    /**
     * Get how many mousetraps are left to use.
     * 
     * @return The amount of mousetraps the elephant still has.
     */
    public int inventory()
    {
        return mousetraps;
    }
    
    /**
     * Drop a mousetrap at the current coordiante 
     * update the inventory accordingly!
     */
    public void dropMousetrap()
    {
        if (inventory() > 0)
        {
            maze.grid[getX()][getY()] = new Mousetrap();
            mousetraps = inventory() - 1;
        }
        else System.out.println(NO_MTRAPS);
    }
    
    /**
     * Process user input: character 
     * 'w' means move up character 
     * 'z' means move down character
     * 'a' means move left character 
     * 's' means move right character
     * 'm' means drop a mousetrap
     */
    public void processCommand(char c) 
    {
        if (c == 'w')
        {
            moveUp();
        }
        else if (c == 'z')
        {
            moveDown();
        }
        else if (c == 'a')
        {
            moveLeft();
        }
        else if (c == 's')
        {
            moveRight();
        }
        else if (c == 'm')
        {
            dropMousetrap();
        }
        else if (c == 'q')
        {
            System.out.print("\f"); //form feed "clears" the display (At least on Mac).
            System.out.println(QUIT_RESPONSE);
            System.exit(0);
        }
        else
        {
            System.out.println(INVALID_CMD);
        }
    }
}