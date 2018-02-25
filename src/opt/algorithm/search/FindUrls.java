package opt.algorithm.search;

import java.util.ArrayList;
import java.util.List;

import opt.Enums;

public class FindUrls {
	
	public static List<String> generateUrls(int type, Integer[] ids) {
		String url = "http://wowhead.com/";
		int maxIds = 0;
		
		switch(type) {
			case Enums.CREATURE_TYPE:
				url += "npc";
				maxIds = Enums.MAX_CREATURE_ENTRY;
				break;
			case Enums.GAMEOBJECT_TYPE:
				url += "object";
				maxIds = Enums.MAX_GOB_ENTRY;
				break;
			case Enums.QUEST_TYPE:
				url += "quest";
				maxIds = Enums.MAX_QUEST_ENTRY;
				break;
			default:
				System.out.println("[FindUrls] Wrong url type");
				System.exit(1);
				break;
		}
		
		List<String> resultUrls = new ArrayList<String>();
		/*for (int i = 1; i < maxIds; ++i) {
			resultUrls.add(url + "=" + String.valueOf(i));
		}*/

		for (Integer i : ids) {
			resultUrls.add(url + "=" + String.valueOf(i));
		}
		return resultUrls;
	}
}
