/**
 * To Test the Class Monster
 *
 * @author  Ryan Seys
 * @version 1.0
 */
public class MonsterTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class MonsterTest
     */
    public MonsterTest()
    {
    }

	public void testMonsterWin()
	{
		Mouseville mousevil1 = new Mouseville();
		Player player1 = mousevil1.getPlayer();
		player1.moveUp();
		player1.moveUp();
		player1.moveUp();
		player1.moveLeft();
		player1.moveLeft();
		assertEquals(true, mousevil1.hasMonster(0, 0));
		java.util.ArrayList<Monster> arrayLis1 = mousevil1.getMonsters();
		Monster monster1 = (Monster)arrayLis1.get(0);
		monster1.move();
		monster1.move();
		assertEquals(true, mousevil1.hasLost());
	}
}