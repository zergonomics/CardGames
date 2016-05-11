package games;

import java.util.List;

public class Funemployed extends Game {
	public static final List<String> jobs = openFile("C:/Users/kjjha_000/Desktop/Coding/CardBoardGames/src/Jobs");
	public static final List<String> traits = openFile("C:/Users/kjjha_000/Desktop/Coding/CardBoardGames/src/Traits and Items");
	
	public Funemployed() {
	}
	
	public List<String> getPlayerWords(int number) {
		return genTraits(number);
	}
	
	public List<String> genJobs(int number) {
		return super.genWords(number, jobs);
	}
	
	public List<String> genTraits(int number) {
		return super.genWords(number, traits);
	}
}
