package items;

import textadventure.World;
//this is a boat, pronounced bo-at
public class Boat extends Item{

	public Boat(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		if(getWorld().getPlayer().getIsBoatUnlocked()) {
			if(!(getWorld().getPlayer().hasItem("oar1") || getWorld().getPlayer().hasItem("oar2"))) {
				World.print("You're gonna need two oars for this boat....\n\n");
			} else {
				if(getWorld().getPlayer().getIsWearingEyepatch() && getWorld().getPlayer().getIsWearingBandana()) {
					World.print("You lower yourself down the sides of the giant ship to the small dinghy boat."
							+ " You grab your two oarss and start paddling away towards a distant port you see,"
							+ " raising no suspicion due to your eyepatch and bandana. You paddle away as the sun"
							+ " sets, away from the daunting ship you were stuck on for " + getWorld().getDay() + " days.\n"
							+ " YOU WIN ; You did it, now you're a true buccaneer!");
					System.exit(0);
				} else {
					World.print("As you lower yourself onto the boat, and begin to paddle away, you notice that"
							+ " some crewman on the ship are watching you over the deck, along with Captain Jack."
							+ " He sends his men on another small boat, and before you know it, you're caught and"
							+ " forced to walk the plank. You try to 'invoke the right of parley' but instead the"
							+ " pirates just laugh at you and tell you that's not a thing. If only you had some pirate"
							+ " attire to not raise so much suspicion.... \n"
							+ " GAME OVER ; You were fed to the sharks.");
					System.exit(0);
				}
			}
		} else {
			World.print("This boat is surrounded and tied up by a rope. If only you had something to cut it"
					+ " with....\n\n");
		}
	}

}
