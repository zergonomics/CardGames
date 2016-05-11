package games;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GameWindow {

	private int numPlayers;
	
	private static Funemployed fun;
	private static SnakeOil snake;
	
	private static int x = 50;
	private static int width = 400;
	private static int offset = 10;
	
	List<PlayerWindow> playerWindows;
	
	public static void main(String [] args) {
		fun = new Funemployed();
		snake = new SnakeOil();
		
		new GameWindow();
		//window.f.dispose();
	}

	public void initialize() {		
		//--------- BASE FRAME AND INITALIZATION ----------------------
		
		String[] items = {"Snake Oil", "Funemployed"};
		JComboBox c = new JComboBox(items);
		JButton b = new JButton("Begin");
		JFrame f = new JFrame();
		SpinnerNumberModel spin = new SpinnerNumberModel(4, 0, 10, 1);
		JSpinner s = new JSpinner(spin);
		JLabel l = new JLabel("Players: ");
		JButton exit = new JButton("Exit");
        
		f.setLocation(x, 150);
        f.add(exit);
		f.setVisible(true);
		f.setSize(width, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.add(l);
		p.add(s);
		p.add(c);
		p.add(b);
		f.add(p);
        f.setLayout(new FlowLayout());
        
        //---------- FUNEMPLOYED PANELS
        
		JPanel funPanel = new JPanel();
		JButton gfj = new JButton("Generate jobs");
		JButton gft = new JButton("Generate traits");

		funPanel.add(gfj);
		funPanel.add(gft);
		funPanel.setVisible(false);
		f.add(funPanel);
				
		// --------- SNAKE OIL PANELS
		
		JPanel snakePanel = new JPanel();
		JLabel l2 = new JLabel("# Words ");
		JButton gsj = new JButton("Generate jobs");
		JButton gsn = new JButton("Generate nouns");
		SpinnerNumberModel snakeSpinModel = new SpinnerNumberModel(6, 1, 20, 1);
		JSpinner ss = new JSpinner(snakeSpinModel);

		JPanel allJobs = new JPanel();
		JButton job1 = new JButton();
		JButton job2 = new JButton();
		JLabel chosenJob = new JLabel();
		JButton showWords = new JButton("Show selected nouns");
		JButton showAll = new JButton("Show all nouns");
		
		chosenJob.setFont(new Font("Serif", Font.BOLD, 15));

		snakePanel.add(l2);
		snakePanel.add(ss);
		snakePanel.add(gsj);
		snakePanel.add(gsn);
		snakePanel.setVisible(false);
		f.add(snakePanel);

		allJobs.add(chosenJob);
		allJobs.add(job1);
		allJobs.add(job2);
		allJobs.add(showWords);
		allJobs.add(showAll);
		showAll.setVisible(false);
		showWords.setVisible(false);
		allJobs.setVisible(false);
		f.add(allJobs);

		f.revalidate();
		
		// --- Funemployed buttons
		
		
		
		// --- Snake oil buttons
		
		job1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenJob.setVisible(true);
				job1.setVisible(false);
				job2.setVisible(false);
				showWords.setVisible(true);
				chosenJob.setText(job1.getText());
			}
		});
		
		job2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenJob.setVisible(true);
				job1.setVisible(false);
				job2.setVisible(false);
				showWords.setVisible(true);
				chosenJob.setText(job2.getText());
			}
		});
		
		gsj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> jobs = snake.genJobs(2);
				job1.setText(jobs.get(0));
				job2.setText(jobs.get(1));
				chosenJob.setVisible(false);
				job1.setVisible(true);
				job2.setVisible(true);
				showWords.setVisible(false);
				showAll.setVisible(false);
				allJobs.setVisible(true);
			}
		});
		
		gsn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerWindow window : playerWindows) {
					window.refresh((int)ss.getValue());
					window.toFront();
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				if (playerWindows != null) {
					for (PlayerWindow window : playerWindows) {
						window.dispose();
					}
				}
			}
		});
		
		showWords.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerWindow window : playerWindows) {
					window.getSelected();
					window.toFront();
					window.highlightPanel.setVisible(false);
				}
				showWords.setVisible(false);
				showAll.setVisible(true);
			}
		});
		
		showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerWindow window : playerWindows) {
					window.reset();
				}
				showWords.setVisible(true);
				showAll.setVisible(false);
			}
		});
		
		// --- Base Buttons
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numPlayers = (int)s.getValue();

				switch(c.getSelectedItem().toString()) {
					case "Snake Oil":
						snakePanel.setVisible(true);
						funPanel.setVisible(false);
						secondary(snake);
						break;
					case "Funemployed":
						snakePanel.setVisible(false);
						allJobs.setVisible(false);
						funPanel.setVisible(true);
						secondary(fun);
						break;
					default:
						System.err.println("That's not a game mode!");
						break;
				}
			}
		});

	}
	
	public void secondary(Game game) {
		
		if (playerWindows != null) {
			for(PlayerWindow window : playerWindows) {
				window.dispose();
			}
		}
		
		playerWindows = new ArrayList<PlayerWindow>();
		
		for(int i = 0; i < numPlayers; i++) {
			PlayerWindow tempWindow = new PlayerWindow(i, game, x + width + offset);
			tempWindow.setVisible(true);
			playerWindows.add(tempWindow);
		}
	}
	
	public GameWindow() {
		initialize();
	}
}








