package quests;

import opt.Enums;
import opt.HtmlObject;

public class Quest extends HtmlObject{

	private String entry;
	private QuestCreatureLink creatureLink;

	public Quest() {
		this.creatureLink = new QuestCreatureLink();
	}

	public Quest(String entry) {
		this.entry = entry;
		this.creatureLink = new QuestCreatureLink();
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public QuestCreatureLink getCreatureLink() {
		return creatureLink;
	}

	public void setCreatureLink(QuestCreatureLink creatureLink) {
		this.creatureLink = creatureLink;
	}

	public void searchQuestLink() {

		String html = this.getHtmlCode();
		int st = html.indexOf("\"point\":\"start\"");
		int ed = html.indexOf("\"point\":\"end\"");
		int fin = html.indexOf("/html>");

		if (st != -1 && ed != -1 && fin != -1) {
			char ch  = html.charAt(st-2);
			char chend = html.charAt(ed - 2);
			System.out.println("ch " + ch + " chend " + chend);
			
			if (ch == '1' && chend == '1') {
				String questStart = this.getHtmlCode().substring(st, ed);
				String questEnd = this.getHtmlCode().substring(ed, fin);

				st = questStart.indexOf(Enums.LOOT_ITEM_START);
				ed = questEnd.indexOf(Enums.LOOT_ITEM_START);

				String entryS = questStart.split(Enums.LOOT_ITEM_START)[1];
				entryS = entryS.substring(0, entryS.indexOf(","));
				entryS = entryS.replace("}", "");
				entryS = entryS.replace("]", "");

				String entryE = questEnd.split(Enums.LOOT_ITEM_START)[1];
				entryE = entryE.substring(0, entryE.indexOf(","));
				entryE = entryE.replace("}", "");
				entryE = entryE.replace("]", "");

				creatureLink.setCreatureStart(entryS);
				System.out.println("  Start npc: " + creatureLink.getCreatureStart());

				creatureLink.setCreatureEnd(entryE);
				System.out.println("  End npc: " + creatureLink.getCreatureEnd());
			}
		}
	}
}
