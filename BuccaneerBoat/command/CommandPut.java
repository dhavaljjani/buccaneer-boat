package command;

import items.Container;
import items.Item;
import items.Person;
import textadventure.World;

public class CommandPut extends Command{

	@Override
	public String[] getCommandWords() {
		return new String[]{"put"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if(!params[1].equals("in")) {
			World.print("I don't understand. The syntax is wrong. \n\n");
			return;
		}
		if(!world.getPlayer().hasItem(params[0]) && !world.getPlayer().getCurrentRoom().hasItem(params[0])) {
			World.print("You can't see any " + params[0] + " here. \n\n");
			return;
		}
		Container container;
		Item item;
		if(world.getPlayer().hasItem(params[0])) {
			item = world.getPlayer().getItem(params[0]);
		} else {
			item = world.getPlayer().getCurrentRoom().getItem(params[0]);
		}
		if(world.getPlayer().hasItem(params[2])) {
			container = (Container) world.getPlayer().getItem(params[2]);
		} else {
			container = (Container) world.getPlayer().getCurrentRoom().getItem(params[2]);
		}
		if((container instanceof Container) == false) {
			World.print("The " + params[2] + " cant hold things. \n\n");
			return;
		}
		if(container instanceof Person) {
			World.print("You can't put stuff in a person!\n\n");
			return;
		}
		if(params[0].equals(params[2])) {
			World.print("You can't put the " + params[0] + "into itself. \n\n");
			return;
		}
		if(world.getPlayer().hasItem(params[0])) {
			container.doPut(item, world.getPlayer());
		} else {
			container.doPut(item, world.getPlayer().getCurrentRoom());
		}
	}

	@Override
	public String getHelpDescription() {
		return "[item] in [container]";
	}

}
