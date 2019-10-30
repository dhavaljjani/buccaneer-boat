package items;

import interfaces.Tradeable;
import textadventure.World;

public class TradeableItem extends Item implements Tradeable{
	
	String name;
	boolean takeable = false;
	
	public TradeableItem(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
		this.name = name;
		this.takeable = takeable;
	}
	
	public boolean getTakeable() {
		return this.takeable;
	}
	
	public void setTake(boolean state) {
		this.takeable = state;
		setTakeable(state);
	}
	
	@Override
	public void doUse() {
		World.print("This item is not useable, althought it is tradeable...\n\n");
	}

	@Override
	public void doTrade() {
		if(this.getName().equals("silver_tooth")) {
			World.print("You show the guard your newly acquired silver tooth, to which you see his eyes widen with greed."
					+ " 'Oh yes lad, that could definetly fetch me something decent by the ports in Tortuga.'You toss the"
					+ " silver tooth to the guard, who looks pleased with this trade. He quickly unlocks your cellar while"
					+ " none of the other prisoners look, and you slip of the cell. \n\n");
			getWorld().getRoom("KITCHEN").doUnlock();
			getWorld().getPlayer().removeItem(this.getName());
			World.print("The kitchen is now unlocked. \n\n");
		} else if(this.getName().equals("golden_compass") && getWorld().getPlayer().getCurrentRoom().getName().equals("CAPTAINSROOM")) {
			if(getWorld().getPlayer().getTalkedToGuard() && getWorld().getPlayer().getExaminedCompass()) {
				World.print("You get up from the behind the table, and the captain quickly turns around. 'And aren't ye the"
						+ " prisoner I caught up by Port Blair? You were trying to stop my boys from looting that bank, tryna"
						+ " be a hero eh?' He moves towards you but as he does so, you realise something. \n"
						+ " 'Jack? You're Captain Jack right?' \n"
						+ " 'Yeah so?' \n"
						+ " You pull out the shimmering golden compass and show the gleaming letters 'For Jack'\n"
						+ " 'Holy crap fella that's me mother's compass. I thought I lost it with her, but you, you've found it lad!' \n"
						+ " 'Looking giddy as a schoolkid, he takes the compass and looks so grateful to you, his menacing grimace washing away...\n"
						+ " YOU WIN ; You did it! The captain let you leave the ship due to you retriving such an important piece of memerobilia for him! Finally"
						+ " you were able to end your journey on the seas as a prisoner! You're a true buccaneer!");
				System.exit(0);
			} else {
				World.print("What would you do with the compass here? Maybe try figuring out who Jack is...\n\n");
			}
		} else if(this.getName().equals("bag_of_sugar")) {
			if(getWorld().getPlayer().getCurrentRoom().getName().equals("DECK")) {
				World.print("You make your way over to the merchant holding th bag od sugar for him."
						+ "'Oh now there's something useful, that bag of sugar could get me a good amount from"
						+ " some of the Spanish sailors by the port in Tortuga. And as promised, here's an"
						+ " oar. I'm sure you'll find a use for it...\n\n");
				World.print("Check your inventory! You now have a second oar! \n\n");
				getWorld().getPlayer().removeItem(getWorld().getPlayer().getItem("bag_of_sugar"));
				getWorld().getPlayer().addItem(new Oar(getWorld(), "oar2", 4, Item.TAKEABLE, "Another simple wooden oar."));
			}
		}
	}

	public String getName() {
		return name;
	}
}
