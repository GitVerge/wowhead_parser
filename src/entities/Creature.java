package entities;

import entities.misc.Loot;
import opt.Enums;
import opt.HtmlObject;
import opt.storage.Store;

public class Creature extends HtmlObject{

	private String entry;
	private Loot loot;

	public Creature() { }

	public Creature(String entry) {
		this.entry = entry;
	}

	public void addCreatureLoot() {
		String lootText = getOnlyLootText(getHtmlCode());

		if (lootText != null) {
			String[] itemsText = lootText.split(Enums.LOOT_ITEM_START);
			createLoot();

			for (int i = 1; i < itemsText.length; ++i) {
				String item = itemsText[i];
				item = item.substring(0, item.indexOf(Enums.LOOT_ITEM_END));
				addItemToLoot(item);
				System.out.println("[+] Loot, add item " + item + " to npc " + getEntry());
			}
			Store.saveCreature(this);
		}
	}
	
	public String getOnlyLootText(String html) {
		String loot = null;

		if (html.contains(Enums.LOOT_START_TEXT)) {
			loot = html.substring(html.indexOf(Enums.LOOT_START_TEXT));
			loot = loot.substring(0, loot.indexOf(Enums.LOOT_END_TEXT));
		}

		return loot;
	}
	
	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public Loot getLoot() {
		return loot;
	}

	public void setLoot(Loot loot) {
		this.loot = loot;
	}

	public void createLoot() {
		if (loot == null) {
			this.loot = new Loot();
		}
	}

	public void addItemToLoot(String itemEntry) {
		loot.addItemToList(itemEntry);
	}

}
