package games;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HighlightButton extends JButton implements ActionListener{
	private boolean highlighted;
	
	public HighlightButton(String text) {
		super(text);
		setBorder(null);
		setOpaque(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(highlighted);
		if (highlighted) {
			setBackground(null);
		}
		else {
			setBackground(Color.yellow);
		}
		highlighted = !highlighted;
	}
}
