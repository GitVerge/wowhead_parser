package entities.misc;

import java.util.ArrayList;
import java.util.List;

public class Loot {

	private List<String> itemEntryL;
	
	public Loot() { 
		itemEntryL = new ArrayList<String>();
	}

	public List<String> getItemEntryL() {
		return itemEntryL;
	}

	public void setItemEntryL(List<String> itemEntryL) {
		this.itemEntryL = itemEntryL;
	}
	
	public void addItemToList(String entry) {
		itemEntryL.add(entry);
	}
}
