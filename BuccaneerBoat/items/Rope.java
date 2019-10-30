package items;

import textadventure.World;

public class Rope extends Item{

	public Rope(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		if(getWorld().getPlayer().hasItem("small_string")) {
			((TradeableItem)getWorld().getPlayer().getCurrentRoom().getItem("golden_compass")).setTake(true);
			World.print("Carefully using the string, you pull the gorgeous golden compass from the adjacent cell into yours. \n\n");

		} else {
			World.print("You don't have that! \n\n");
		}
	}

}
