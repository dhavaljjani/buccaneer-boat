package command;

import items.Beverage;
import textadventure.World;

public class CommandDrink extends Command{

	@Override
	public String[] getCommandWords() {
		return new String[] {"drink"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if(params.length > 1) {
			World.print("I don't understand. \n\n");
			return;
		} else if(params.length == 1){
			if(world.getPlayer().hasItem(params[0]) && world.getPlayer().getItem(params[0]) instanceof Beverage) {
				world.getPlayer().removeItem(world.getPlayer().getItem(params[0]));
				if(params[0].equals("bottle_of_rum")) {
					world.getPlayer().setDrunk(true);
					System.out.print("You drink the whole bottle of spiced rum, and slowly you feel a bit tipsy"
							+ " and unsteady, the world around you becoming confusing. \n\n");
					System.out.print("You are now drunk. \n\n");
				}
				return;
			} else {
				if(world.getPlayer().getCurrentRoom().hasItem(params[0]) && !world.getPlayer().hasItem(params[0])) {
					World.print("You don't have a(n) " + params[0] + " in your inventory to drink.\n\n");
					return;
				}
				World.print("You can't drink that! \n\n");
				return;
			}
		} else {
			World.print("What do you want to drink? \n\n");
			return;
		}
	}

	@Override
	public String getHelpDescription() {
		return "[beverage item]";
	}

}
