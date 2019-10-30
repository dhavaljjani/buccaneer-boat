package items;

import interfaces.Edible;
import textadventure.World;

public class Food extends Item implements Edible{

	public Food(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doEat() {
		World.print("You take a big chomp of the" + this.getName() + " and it feel great....for a few"
				+ " seconds before your stomach starts to hurt. What was in that " + this.getName() + "? \n\n");
		World.print("GAME OVER ;  As it turns out, you were infected by dysentary from it, and suffer through vomiting and bloody stool before yout unfortunate death.");
		getWorld().getPlayer().removeItem(this.getName());
		System.exit(0);
	}

	@Override
	public void doUse() {
		doEat();
	}

}
