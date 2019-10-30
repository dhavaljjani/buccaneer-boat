package items;

import textadventure.World;

public class MapItem extends Item{

	public MapItem(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		this.readMap();
	}

	private void readMap() {
		System.out.print("                       The Buccaneer Boat Layout                      \n");
		System.out.print("    _________________________________________________________________  \n");
		System.out.print("   /                |               |^Upstairs  |                    \\  \n");
		System.out.print("  /                 |               |   to Deck^|                    |  \n");
		System.out.print(" /                  |               |           |                    |  \n");
		System.out.print("/                   |               |           |                    |  \n");
		System.out.print("|   Captain's Cabin | Storage Room  |  Kitchen  |     Prison Cells   |  \n");
		System.out.print("\\                   |               |           |                    | \n");
		System.out.print(" \\                  |               |           |                    | \n");
		System.out.print("  \\                 |               |           |                    | \n");
		System.out.print("   \\________________|_______________|___________|____________________/  \n");
	}

}
