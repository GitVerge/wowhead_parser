package opt.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import opt.Enums;
import quests.Quest;
import entities.Creature;
import entities.GameObject;

public class Store {

	private static Map<String, Creature> creatureL = new HashMap<String, Creature>();
	private static Map<String, GameObject> gameObjectL = new HashMap<String, GameObject>();
	private static Map<String, Quest> questL = new HashMap<String, Quest>();

	public static void saveCreature(Creature npc) {
		if (npc != null) {
			synchronized(creatureL) {
				creatureL.put(npc.getEntry(), npc);
			}
		}
	}

	public static void saveGameObject(GameObject gob) {
		if (gob != null) {
			synchronized(gameObjectL) {
				gameObjectL.put(gob.getEntry(), gob);
			}
		}
	}

	public static void saveQuest(Quest quest) {
		if (quest != null) {
			synchronized(questL) {
				questL.put(quest.getEntry(), quest);
			}
		}
	}

	public static void createObject(String url, String html, int type) {
		String entry = url.substring(url.indexOf("="));

		switch(type) {
			case Enums.CREATURE_TYPE:
				Creature c = new Creature(entry);
				c.setHtmlCode(html);
				c.addCreatureLoot();
				saveCreature(c);
				break;
			case Enums.GAMEOBJECT_TYPE:
				GameObject g = new GameObject(entry);
				g.setHtmlCode(html);
				saveGameObject(g);
				break;
			case Enums.QUEST_TYPE:
				Quest q = new Quest(entry);
				q.setHtmlCode(html);
				q.searchQuestLink();
				if (q.getCreatureLink().getCreatureStart() != null) {
					saveQuest(q);
				}
				break;
			default:
				System.out.println("[FindUrls] Wrong url type");
				System.exit(1);
				break;
		}
	}

	public static Set<String> getCreaturesEntries() {
		return creatureL.keySet();
	}
	public static Set<String> getGameObjectsEntries() {
		return gameObjectL.keySet();
	}
	public static Set<String> getQuestsEntries() {
		return questL.keySet();
	}

	public static Collection<Creature> getCreatures() {
		return creatureL.values();
	}
	public static Collection<GameObject> getGameObjects() {
		return gameObjectL.values();
	}
	public static Collection<Quest> getQuests() {
		return questL.values();
	}

	public static Creature getCreature(String entry) {
		return creatureL.get(entry);
	}
	public static GameObject getGameObject(String entry) {
		return gameObjectL.get(entry);
	}
	public static Quest getQuest(String entry) {
		return questL.get(entry);
	}

	public static int getCreaturesSize() {
		return creatureL.size();
	}
	public static int getGameObjectsSize() {
		return gameObjectL.size();
	}
	public static int getQuestSize() {
		return questL.size();
	}

	public static void clearAll() {
		creatureL.clear();
		gameObjectL.clear();
		questL.clear();
	}
}
