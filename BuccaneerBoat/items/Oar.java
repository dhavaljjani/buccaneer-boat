package items;

import textadventure.World;

public class Oar extends Item{

	public Oar(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		World.print("You wave the oar around frantically to no avail. What are you trying to do? \n\n");
	}

}
