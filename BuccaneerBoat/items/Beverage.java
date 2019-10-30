package items;

import textadventure.World;

public class Beverage extends Item{

	public Beverage(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		World.print("I think you mean drink... \n\n");
	}

}
