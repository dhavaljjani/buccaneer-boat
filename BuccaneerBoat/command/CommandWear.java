package command;

import textadventure.World;

public class CommandWear extends Command{

	@Override
	public String[] getCommandWords() {
		return new String[] {"wear"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if(params[0].equals("eyepatch")) {
			world.getPlayer().removeItem(world.getPlayer().getItem("eyepatch"));
			world.getPlayer().setIsWearingEyepatch(true);
			World.print("You put the eyepatch over your eyes and wear it.\n\n");
		} else if(params[0].equals("bandana")) {
			world.getPlayer().removeItem(world.getPlayer().getItem("bandana"));
			world.getPlayer().setIsWearingBandana(true);
			World.print("You tie the bandana around your head and wear it.\n\n");
		} else {
			World.print("You can't wear that! \n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[clothing item]";
	}

}
