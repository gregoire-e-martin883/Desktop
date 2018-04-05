import java.io.*;
import java.util.ArrayList;

public class LMCodingTest {

	public static void main(String[] args) {
		
		if (args.length != 2)
		{
			System.out.println("User input cannot be resolved");
			System.out.println("Usage: java LMCodingTest <dictionary> <text input>> ");
		}
		
		Dictionary dictionary = new Dictionary();
		dictionary.populate(args[0]);
		
		ArrayList<String> inputText = new ArrayList<String>();
		
		SpellChecker spellChecker;
	
		
		try {
			FileReader input = new FileReader(args[1]);
			
			BufferedReader inputReader = new BufferedReader(input);
			
			String s = inputReader.readLine();
			while (s != null)
			{
				String temp[] = s.split("\\s+");
				for (int i = 0; i < temp.length; i++)
				{
					inputText.add(temp[i]);
				//	System.out.println("Adding to words: " + temp[i]);
				}
				
				s = inputReader.readLine();
			}

		//	for (String string : inputText)
		//	{
		//		System.out.println(string);
		//	}

			
			inputReader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error opening file");
			e.printStackTrace();
		}
		
		spellChecker = new SpellChecker(dictionary, inputText);
		spellChecker.runSpellCheck();
	}

}
