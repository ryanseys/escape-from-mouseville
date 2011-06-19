/**
 * To Test Pacman Class
 *
 * @author  Ryan Seys
 * @version 1.0
 */
public class PacmanMazeTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class PacmanMazeTest
     */
    public PacmanMazeTest()
    {
    }

	public void testDots()
	{
		PacmanMaze pacmanMa1 = new PacmanMaze();
		Player player1 = pacmanMa1.getPlayer();
		assertEquals(true, (pacmanMa1.grid[0][1] instanceof Dot));
		pacmanMa1.eat(0, 1);
		assertEquals(true, (pacmanMa1.grid[0][1] == null));
	}
}