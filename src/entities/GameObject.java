package entities;

import opt.HtmlObject;

public class GameObject extends HtmlObject{

	private String entry;

	public GameObject() { }
	
	public GameObject(String entry) {
		this.entry = entry;
	}
	
	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}
	
}
