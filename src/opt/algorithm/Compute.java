package opt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import opt.Enums;
import opt.storage.Store;
import entities.GameObject;

public class Compute {

	public Compute() { }

	public void saveHtmls(List<String> urls, int type) {
		for (String url : urls) {
			try {
				URL link = new URL(url);
				BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));

				String html = "";
				String line;
				while ((line = in.readLine()) != null) {
					html += line;
				}
				in.close();

				if (!html.isEmpty() && !html.contains(Enums.ERROR_LINE)) {
					System.out.println("[+] Save url html: " + url);
					Store.createObject(url, html, type);
				}
			} catch (MalformedURLException e) {
				System.out.println("Malformed url: " + String.valueOf(url));
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("[-] Info not found, url: " + url);
			}
		}
	}
	
	public void addGameObjectLoot(GameObject gob) {
		//TODO
		Store.saveGameObject(gob);
	}
}
