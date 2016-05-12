package cards;

import java.util.ResourceBundle;
import java.util.Set;

/**
 * A Card
 * @author Sung-Hoon
 * 
 */
public abstract class Card {
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle myResources;
	
	private String name;
	public Card (String card) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + this.getClass().getSimpleName());
		// redundant
		name = card;
	}
	/**
	 * Get name of card
	 * @return name of card
	 */
	public String getName() {
		return name;
	}
	
	protected Set<String> getPropertyNames() {
		return myResources.keySet();
	}
	protected String getPropertyValue(String key) {
		return myResources.getString(key);
	}
	// one day cards will draw themselves or something (visually)
	
}
