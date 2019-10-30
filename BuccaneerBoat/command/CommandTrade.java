package command;

import items.TradeableItem;
import textadventure.World;

public class CommandTrade extends Command{

	@Override
	public String[] getCommandWords() {
		return new String[] {"trade", "barter"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if(params[0].equals("silver_tooth")) {
			if(world.getPlayer().getItem(params[0]) instanceof TradeableItem) {
				((TradeableItem)world.getPlayer().getItem(params[0])).doTrade();
			} else {
				World.print("You can't trade that! \n\n");
			}
		} else if(params[0].equals("bag_of_sugar")) {
			if(world.getPlayer().getItem(params[0]) instanceof TradeableItem) {
				((TradeableItem)world.getPlayer().getItem(params[0])).doTrade();
			} else {
				World.print("You can't trade that! \n\n");
			}
		}  else if(params[0].equals("golden_compass")) {
			if(world.getPlayer().getItem(params[0]) instanceof TradeableItem) {
				((TradeableItem)world.getPlayer().getItem(params[0])).doTrade();
			} else {
				World.print("You can't trade that! \n\n");
			}
		} else {
			if(!world.getPlayer().hasItem(params[0])) {
				World.print("You don't have that item! Try taking it! \n\n");
				return;
			}
			World.print("I don't understand. \n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[item]";
	}

}
