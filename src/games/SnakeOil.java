package games;

import java.util.ArrayList;
import java.util.List;

public class SnakeOil extends Game {
	
	public static final List<String> jobs = openFile("C:/Users/kjjha_000/Desktop/Coding/CardBoardGames/src/Jobs");
	public static final List<String> nouns = openFile("C:/Users/kjjha_000/Desktop/Coding/CardBoardGames/src/Nouns");
	
	private List<String> butWait;

	public SnakeOil() {
		butWait = new ArrayList<String>();
	}
	
	public List<String> getPlayerWords(int number) {
		return genNouns(number);
	}
	
	public List<String> genJobs(int number) {
		return super.genWords(number, jobs);
	}
	
	public List<String> genNouns(int number) {
		return super.genWords(number, nouns);
	}
	
	public void fixSpaces() {
		for (String noun : nouns) {
			System.out.println(noun.substring(3));
		}
	}
	
	private String butWaitTheresMore() {
		return butWait.get(rand.nextInt(butWait.size()));
	}

	private String bwtm() {
		return butWaitTheresMore();
	}

}
