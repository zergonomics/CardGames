package games;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Games {

	private static SnakeOil snake =  new SnakeOil();;
	private static Funemployed fun = new Funemployed();
	private static int numSnakeWords = 6;
	private static int numFunWords = 6;
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
		drawStart(f);
	}
	
	private static void drawStart(JFrame f) {
		f.removeAll();
		JButton snakebutton = new JButton("Snake oil");
		JButton funbutton = new JButton("Funemployed");
		f.add(snakebutton);
		f.add(funbutton);
        f.pack();

		snakebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawsnake(f);
			}
		});
		
		funbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawfun(f);
			}	
		});
	}
	
	private static void drawsnake(JFrame f) {
        f.pack();
	}
	
	private static void drawfun(JFrame f) {
		f.removeAll();
		JButton createwords = new JButton("Words");
		JPanel wordpanel = new JPanel();
		f.add(createwords);
		f.add(wordpanel);
		
		createwords.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				wordpanel.removeAll();
				List<String> words = fun.genJobs(numFunWords);
				for(int i = 0; i < numFunWords; i++) {
					wordpanel.add(new JLabel(words.get(i)));
				}
			}
		});
        f.pack();
	}
}
