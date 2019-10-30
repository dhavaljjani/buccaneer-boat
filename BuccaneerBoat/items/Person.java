package items;

import interfaces.Edible;
import textadventure.World;

public class Person extends Container{

	public Person(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		World.print("Use? I think you mean (talk to) or (talk with) or (speak to) or (speak with)... \n\n");
	}

	public void addItem(Item item) {
		items.put(item.getName(), item);
	}
}
