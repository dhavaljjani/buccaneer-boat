package command;

import items.Person;
import textadventure.World;

public class CommandTalk extends Command{

	@Override
	public String[] getCommandWords() {
		return new String[]{"talk", "speak"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if(params[0].equals("to") || params[0].equals("with")) {
			if((world.getPlayer().getCurrentRoom().getItem(params[1]) instanceof Person)) {
				if(params[1].equals("old_man")) {
					if(world.getPlayer().hasItem("silver_tooth")) {
						 World.print("The old man grunts at you and looks away, clearly not in the mood for any kind"
						 		+ " of discussion");
					} else {
						World.print("You motion to talk to the old man, who just grunts at you and turns his head,"
							+ " giving you a split-second where you see his shimmering silver tooth again. \n\n");
					}
				} else if(params[1].equals("guard")) {
					if(world.getPlayer().hasLeftPrison()) {
						World.print("'What do you want now lad? Unless you wanna be locked up again, I'd advise"
								+ " ye to run off then...' \n\n");
					} else {
						World.print("You yell at the guard to let you out, and he just laughs at you." +
								" 'I aint letting you out here boy, I'm loyal to captain Jack and captain Jack only...That is" +
								" unless you got something for me, maybe then I can arrange something...' \n\n");
						world.getPlayer().setTalkedToGuard(true);
					}
				} else if(params[1].equals("merchant")) {
					World.print("You walk towards one of the masts where you see the merchant, who looks about as lost as you."
							+ " 'Alright then? I'm just a merchant here, not a pirate crewman. Tell you what, if you're looking"
							+ " to escape this horrible hellhole of a boat, I've got a little something that could help. Although,"
							+ " I'll need something of course, I am a merchant! I hear that spice and sugar prices are quite high"
							+ " 'round the seas right now though....' \n\n");
				}
			} else {
				World.print("Talk to who? \n\n");
			}
		} else {
			World.print("I don't understand.\n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "to/with [person]";
	}

}
