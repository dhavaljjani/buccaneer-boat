package items;

import textadventure.World;

public class Knife extends Item{
	
	public Knife(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		if(getWorld().getPlayer().getCurrentRoom().getName().equals("CAPTAINSROOM")) {
			World.print("You jump up from behind the table and use your knife to slash on the captain. The captain immedietly"
					+ " turns around and takes his sword out, your dull knife being no competition. He overpowers you and takes"
					+ " you down easily. 'Thought you could kill Captain Jack did ya lad?' Well. I'd hate to dull me sword"
					+ " so I guess ye can walk the plank by the sharks. How's that sound then?' \n\n"
					+ " GAME OVER ; You were forced to walk the plank and although no sharks found you, you died by drowning"
					+ " in the freezing Caribbean waters.");
			System.exit(0);
		} else if(getWorld().getPlayer().getCurrentRoom().getName().equals("DECK")) {
			World.print("You make your way to the back of the the giant ship's deck, where there's a small dinghy boat"
					+ " hanging off the side. You use the knife to cut the rope thats tied it and it falls to the still sea below"
					+ " you. Some oars would be pretty useful now....\n\n");
			getWorld().getPlayer().setIsBoatUnlocked(true);
		}
	}

}
