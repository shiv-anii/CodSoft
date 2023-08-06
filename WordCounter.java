package codsoft;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
	
	public static int countWords(String input) {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		int count = 0;
		String[] words = input.split(" ");
		for(String word: words) {
			 if (!word.trim().isEmpty()) {
	                count++;
			 }
		}
		return count;
	}
	
	public static int countWordsFromFile(String filePath) {
        File file = new File(filePath);
        int count = 0;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                count += countWords(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return count;
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Hello, this is a word counter.");
		System.out.println("Enter your choice: \n(1)Provide Text \n(2)Provide File Path ");
		int choice = s.nextInt();
		switch (choice) {
			case 1:
				s.nextLine(); 
				System.out.println("Paste text here: ");
				String inputText = s.nextLine();
				int totalCount = countWords(inputText);
				System.out.println("Total number of words in the provided text are: " + totalCount);
				break;
			case 2:
				s.nextLine(); 
				System.out.println("Paste link here: ");
				String filePath = s.nextLine();
				int fileWordCount = countWordsFromFile(filePath);
				 System.out.println("Total number of words in the provided file are: " + fileWordCount);
				 
		s.close();
	}

}
}
