package command;

import items.*;
import textadventure.World;

public class CommandTake extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[]{"take", "get", "grab", "hold"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if (params.length == 1) {
			String itemName = params[0];
			if(world.getPlayer().getCurrentRoom().getItem(itemName) instanceof Person) {
				World.print("I'm not sure how you expect to take a person, let alone why you want to do it...\n\n");
				return;
			}
			if (world.getPlayer().getCurrentRoom().hasItem(itemName)) {
				if(world.getPlayer().getCurrentRoom().getItem(itemName).getName().equals("silver_tooth")) {
					World.print("You can take the silver tooh from the old man....\n\n");
					return;
				}
				if(world.getPlayer().getCurrentRoom().getItem(itemName).getName().equals("golden_compass")) {
					if(!((TradeableItem)world.getPlayer().getCurrentRoom().getItem(itemName)).getTakeable()) {
						World.print("The golden compass is in the cell adjacent to yours, but you can't reach it with just your hand. \n\n");
						return;
					}
				}
				Item item = world.getPlayer().getCurrentRoom().getItem(itemName);
				item.doTake(world.getPlayer().getCurrentRoom());
			} else if (world.getPlayer().hasItem(itemName))
				World.print("You already have that!\n\n");
			else
				World.print("You can't see any " + itemName + " here.\n\n");
		}
		else if(params.length == 3){
			if(!params[1].equals("from")) {
				World.print("I don't understand. \n\n");
				return;
			}
			Item container = null;
			if(world.getPlayer().hasItem(params[2])) {
				container = world.getPlayer().getItem(params[2]);
			} else {
				container = world.getPlayer().getCurrentRoom().getItem(params[2]);
			}
			if(params[2] == null || params[2].equals("")) {
				World.print("You can't see any " + params[2] + " here. \n\n");
				return;
			}
			if((container instanceof Container) == false) {
				World.print("The " + params[2] + " can't hold things! \n\n");
				return;
			}
			if(!((Container) container).hasItem(params[0])) {
				World.print("The " + params[2] + " doesn't have a " + params[0] + ". \n\n");
				return;
			}
			Item i = ((Container) container).getItem(params[0]);
			World.print("Desperate for something, you yank the old man's tooth out of his mouth through the bars. He exclaims"
					+ " and shouts at you, but he can't do anything to you behind his bars. Surely this silver tooth is"
					+ " worth something... \n\n");
			//((Container)world.getPlayer()).addItem(world.getPlayer().getCurrentRoom().getItem(params[0]));
			//world.getPlayer().getCurrentRoom().removeItem(params[0]);
			World.print("The silver_tooth has been added to your inventory, \n\n");
			((Container)container).doTake(i);
			return;
			} else {
			World.print("I don't understand.\n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[item] or [item] from [container]";
	}

}
