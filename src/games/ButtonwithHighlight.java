package games;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class ButtonwithHighlight extends JToggleButton {
	public final JLabel highlight;
	private boolean visible;
	
	public ButtonwithHighlight(String name) {
		super(name);
		highlight = new JLabel(".");
		visible = false;
		setHighlight();
	}
	
	public void toggleHighlight() {
		visible = !visible;
		setHighlight();
	}
	
	private void setHighlight() {
		this.highlight.setVisible(visible);
	}
	
	public void reset() {
		visible = false;
		setHighlight();
	}
}
