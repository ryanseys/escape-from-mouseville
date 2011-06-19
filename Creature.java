/**
 * Creature represents anything that moves in the maze.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Creature
{
    protected int x;
    protected int y;
    protected Maze maze;

    /**
     * Assign the maze, and give an initial position (0, 0)
     */
    public Creature(Maze m)
    {
        x = 0;
        y = 0;
        maze = m;
    }
    
    /**
     * Assign the maze and set the coordinates to the ones supplied by the parameters
     */
    public Creature(int x, int y, Maze m)
    {
        this.x = x;
        this.y = y;
        maze = m;
    }
    
    /**
     * @return The x-coordinate of the creature.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return The y-coordinate of the creature.
     */
    public int getY()
    {
        return y;
    }

    /**
     * Tests to see if the move is valid: can't go outside the bounds, 
     * and can't jump or move diagonally.
     * 
     * @param i The x value of where you want the creature to go.
     * @param j The y value of where you want the creature to go.
     * @return true if the creature can move there.
     */
    public boolean canGoTo(int i, int j)
    {
        //you can subtract or add from one or the other of the two coordinates but not both. (4 cases)
        if (getY() == j)
        {
            //check x
            if ((getX() - 1) == i)
            {
                if ((i <= (maze.SIZE - 1)) && (i >= 0)) //not out of bounds
                {
                    if(maze.grid[i][j] == null) {
                        return true;
                    }
                    else if(maze.grid[i][j].getLetter() != "W") {
                        return true;
                    }
                }
            }
            else if ((getX() + 1) == i)
            {
                if ((i <= (maze.SIZE - 1)) && (i >= 0)) //not out of bounds
                {
                    if(maze.grid[i][j] == null) {
                        return true;
                    }
                    else if(maze.grid[i][j].getLetter() != "W") {
                        return true;
                    }
                }
            }
        }
        else if (getX() == i)
        {
            if ((getY() - 1) == j)
            {
                if ((j <= (maze.SIZE - 1)) && (j >= 0)) //not out of bounds
                {
                    if(maze.grid[i][j] == null) {
                        return true;
                    }
                    else if(maze.grid[i][j].getLetter() != "W") {
                        return true;
                    }
                }
            }
            else if ((getY() + 1) == j)
            {
                if ((j <= (maze.SIZE - 1)) && (j >= 0)) //not out of bounds
                {
                    if(maze.grid[i][j] == null) {
                        return true;
                    }
                    else if(maze.grid[i][j].getLetter() != "W") {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}