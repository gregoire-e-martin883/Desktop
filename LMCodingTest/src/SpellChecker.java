import java.util.ArrayList;

public class SpellChecker {
	private Dictionary dictionary;
	private ArrayList<String> input;
	private boolean results[];
	
	private Object lock = new Object();
	
	public SpellChecker(Dictionary dictionary, ArrayList<String> input)
	{
		this.dictionary = dictionary;
		this.input = input;
		
		this.results = new boolean[input.size()];
	}
	
	public void runSpellCheck()
	{
		for (int i = 0; i < input.size(); i++)
		{
			checkSpellingOfWord(input.get(i), i);
		 }
		
		for (int i = 0; i < input.size(); i++)
		{
			printResult(i);
		}
		
	}
	
	private void checkSpellingOfWord(String s, int i)
	{		
		(new WordChecker(s, i, this)).run();
	}
	
	public Dictionary getDictionary()
	{
		return dictionary;
	}
	
	public void setResult(int i, boolean result)
	{
		synchronized (lock) {
			results[i] = result;
		}
	}
	
	public boolean getResult(int i)
	{
		boolean result;
		synchronized (lock) {
			result = results[i];
		}
		return result;
	}
	
	public void printResult(int i)
	{
		synchronized (lock) {
			System.out.println("Result[" + i + "]: " + results[i]);
		}
	}
}
