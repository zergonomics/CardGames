package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {
	
	protected static Random rand = new Random();
	
	protected static List<String> openFile(String path) {
		List<String> result = new ArrayList<String>();
		File file = new File(path);
		Scanner sc;
		try {
			sc = new Scanner(file);
					
			while (sc.hasNext()) {
				String temp = sc.nextLine();
				if (temp != "")
					result.add(temp);
			}
			
			sc.close();			
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}
		return result;
	}
	
	protected abstract List<String> getPlayerWords(int num);
	
	protected List<String> genWords(int number, List<String> lst) {
		List<String> words = new ArrayList<String>();
		List<Integer> nums = new ArrayList<Integer>();
		
		int maxiter = 1000;
		int iter = 0;
		
		int temp;
		int size = lst.size();
		
		if (size < number) {
			System.err.println("Requested more words than in the list! (why do you need so many?)");
			return null;
		}
		
		while(nums.size() < number && iter < maxiter) {
			temp = rand.nextInt(size);
			if (!nums.contains(temp)) {
				nums.add(temp);
				words.add(lst.get(temp));
			}
			
			iter++;
		}
		
		if (words.size() == 0) {
			try {
				for (int i = 0; i < number; i++)
					words.add(lst.get(i));
			} catch (IndexOutOfBoundsException e) {
				System.err.println("List smaller than requested number of words!");
			}
		}

		if (words.size() < number) {
			temp = nums.get(0);
			while (words.size() < number) {
				temp = (temp + 1) % size;
				if (!nums.contains(temp)) {
					nums.add(temp);
					words.add(lst.get(temp));
				}
			}
			System.err.println("Had to add non-random words to list!");
		}

		return words;
	}
}
