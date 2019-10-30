package items;

import textadventure.World;

public class Clothing extends Item{

	public Clothing(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		World.print("You can't use the " + this.getName() + ", but you can wear it...\n\n");
	}

}
