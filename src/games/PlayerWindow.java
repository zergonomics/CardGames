package games;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;

public class PlayerWindow extends JFrame {
	public final int id;
	public Game game;
	
	private JPanel wordPanel;
	private JPanel buttonPanel;
	public final JPanel highlightPanel;
	private JButton hide;
	private JButton show;
	
	private List<JToggleButton> wordList;
	
	public PlayerWindow(int id, Game game, int x) {
		this.id = id;
		this.game = game;
		wordPanel = new JPanel();
		wordPanel.setVisible(false);
		
		highlightPanel = new JPanel();
		highlightPanel.setVisible(false);

		JLabel idLabel = new JLabel("Player " + Integer.toString(id + 1));
		
		buttonPanel = new JPanel();
		show = new JButton("Show words");
		hide = new JButton("Hide words");
		show.setVisible(true);
		hide.setVisible(false);
		
		wordList = new ArrayList<JToggleButton>();
		
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wordPanel.setVisible(true);
				highlightPanel.setVisible(false);
				show.setVisible(false);
				hide.setVisible(true);
				pack();
			}
		});
		
		hide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wordPanel.setVisible(false);
				highlightPanel.setVisible(true);
				show.setVisible(true);
				hide.setVisible(false);
				pack();
			}
		});
		
		buttonPanel.add(show);
		buttonPanel.add(hide);
		
		add(idLabel);
		add(buttonPanel);
		add(highlightPanel);
		add(wordPanel);
		
		setLayout(new FlowLayout());
		setLocation(x, (int) ((id + 0.5) * 110));
		Random rand = new Random();
		buttonPanel.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		setTitle("Player " + Integer.toString(id + 1));
		
		pack();
	}
	
	public void refresh(int num) {
		List<String> words = game.getPlayerWords(num);
		wordList.clear();
		wordPanel.removeAll();
		highlightPanel.removeAll();
		ButtonwithHighlight tempButton;
		for (int i = 0; i < num; i++) {
			String word = words.get(i);
			tempButton = new ButtonwithHighlight(word);
			highlightPanel.add(tempButton.highlight);
			tempButton.setBorder(null);
			tempButton.setBackground(Color.lightGray);
			tempButton.setUI(new MetalToggleButtonUI() {
			    @Override
			    protected Color getSelectColor() {
			        return Color.WHITE;
			    }
			    @Override
			    protected Color getDisabledTextColor() {
			    	return Color.YELLOW;
			    }
			});
			tempButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					((ButtonwithHighlight) e.getSource()).toggleHighlight();
				}
			});
			wordList.add(tempButton);
			wordPanel.add(tempButton);
		}
		hide.setVisible(false);
		show.setVisible(true);
		wordPanel.setVisible(false);
		pack();
	}

	public void getSelected() {
		for (JToggleButton button : wordList) {
			if (!button.isSelected()) {
				button.setVisible(false);
			}
		}
		hide.setVisible(true);
		show.setVisible(false);
		wordPanel.setVisible(true);
		pack();
	}
	
	public void reset() {
		for (JToggleButton button : wordList) {
			button.setVisible(true);
		}
		pack();
	}
}
