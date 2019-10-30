package command;

import textadventure.World;

public class CommandWait extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[]{"wait", "rest"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		World.print("Time passes...\n");
		if(world.getPlayer().getDrunk()) {
			world.getPlayer().setDrunk(false);
			World.print("You are no longer drunk! \n\n");
		}
	}	

	@Override
	public String getHelpDescription() {
		return "";
	}
}
