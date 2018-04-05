import java.util.ArrayList;
import java.io.*;

public class Dictionary {
	private ArrayList<String> words;

	public Dictionary()
	{
		this.words = new ArrayList<String>();
		
	}	
	
	public void populate(String filePath)
	{
		try {
			FileReader input = new FileReader(filePath);
			BufferedReader inputReader = new BufferedReader(input);
			
			String s = inputReader.readLine();
		//	System.out.println(s);
			
			while (s != null)
			{
				words.add(s);
			//	System.out.println("Adding to words: " + s);
				
				s = inputReader.readLine();
			}

			for (String string : words)
			{
		//		System.out.println(string);
			}
				
			inputReader.close();
			input.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// checks if word is contained in this object's list of words
	public boolean contains(String word)
	{
		if (words.contains(word))
		{
			return true;
		}
		return false;
	}

}
