package opt;

public class Enums {
	
	public static final String ERROR_LINE = "en nuestra base de datos.";
	
	/** Search **/
	public static final int MAX_CREATURE_ENTRY = 115000;
	public static final int MAX_GOB_ENTRY = 300000; //TODO
	public static final int MAX_QUEST_ENTRY = 150000; //TODO
	
	public static final int CREATURE_TYPE = 0;
	/*public static final int CREATURE_LOOT = 1;
	public static final int CREATURE_LOOT_M = 2;
	public static final int CREATURE_LOOT_HC = 3;*/
	public static final int GAMEOBJECT_TYPE = 4;
	public static final int QUEST_TYPE = 5;
	
	/*private static final String LOOT_TAG = "/#drops";
	private static final String LOOT_MODE_TAG = ":mode=";
	private static final String LOOT_MODE_M = "m";
	private static final String LOOT_MODE_HC = "heroic";*/
	
	/** Loot **/
	public static final String LOOT_START_TEXT = "LANG.tab_drops";
	public static final String LOOT_END_TEXT = "});";
	public static final String LOOT_ITEM_START = "\"id\":";
	public static final String LOOT_ITEM_END = ",";
	
	/** Quest **/
	public static final String QUEST_STARTER_TEXT = "x3Dquest_start";
	public static final String QUEST_ENDER_TEXT = "x3Dquest_end";
	public static final String QUEST_NPC_ENTRY = "x2Fnpc";
	public static final String QUEST_NPC_PRETEXT = "x3D"; //x3D3293 entry 3293
	public static final String quest_ = "]],\"id\":";
	
}
