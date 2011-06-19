import java.util.Scanner;
/**
 * This class basically "runs" the game through its play() method.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Game
{
    private Maze maze;

    /**
     * Constructor for objects of class Game
     */
    public Game(Maze m)
    {
        maze = m;
    }

    /**
     * Outputs the current state of the maze - 
     * Gets console input from the user to determine the elephant's next move.
     * (keys to move, "m" to drop a mousetrap, "q" to quit)
     * Until game is won or lost or the user quit.
     */
    public void play()
    {
        char command;
        boolean done = false;
        maze.resolve();
        while(!done)
        {
            Scanner s = new Scanner(System.in);
            try {
                command = s.nextLine().charAt(0);
            }
            catch (StringIndexOutOfBoundsException e) {
                command = '*';
            }
            maze.p.processCommand(command);
            //move all the mice.
            maze.resolve();
            for (Monster m : maze.getMonsters())
            {
                m.move(); //comment this out if you want to test the game winnability.
            }
            maze.resolve();
            if (maze.hasLost())
            {
                System.out.println("YOU LOST!");
                done = true;
            }
            else if (maze.hasWon())
            {
                System.out.println("YOU WON!");
                done = true;
            }
        }
    }
    
    /**
     * Launches the game by instantiating a new game and calling play() on it.
     * 
     * With the main function you can input the name of the game as an argument to an
     * array of strings. 
     * Names can be seen below and are pretty straightforward for what game they represent.
     */
    public static void main(String[] args)
    {
        Maze m = null;
        
        if(args[0].equals("Mouseville")) {
            m = new Mouseville();
        }
        else if(args[0].equals("Pacman")) {
            m = new PacmanMaze();
        }
        else if(args[0].equals("Digger")) {
            m = new Digger();
        }
        //default if nothing is given as the parameter
        else
            m = new Mouseville();
        
        Game g = new Game(m);
        g.play();
    }
}