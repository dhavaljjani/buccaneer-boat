package command;

import interfaces.Edible;
import items.Person;
import textadventure.World;

public class CommandEat extends Command{

	@Override
	public String[] getCommandWords() {
		return new String[] {"eat", "swallow", "devour", "consume"};
	}

	@Override
	public String getHelpDescription() {
		return "[item]";
	}
	
	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if(params.length != 1) {
			World.print("What do you want to eat? \n\n");
			return;
		}
		if(!world.getPlayer().hasItem(params[0])) {
			if(world.getPlayer().getCurrentRoom().getItem(params[0]) instanceof Person) {
				int random = (int)(Math.random() * 2);
				if(random == 0) {
					World.print("I know you're hungry but... \n\n");
				} else {
					World.print("I don't think they would like that.... \n\n");
				}
				return;
			}
			World.print("You don't have " + params[0] + ". \n\n");
			return;
		} else {
			if(!(world.getPlayer().getItem(params[0]) instanceof Edible)) {
				World.print("That's not edible! \n\n");
			} else {
				((Edible)world.getPlayer().getItem(params[0])).doEat();
			}
		}
	}

}
