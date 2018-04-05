
public class WordChecker implements Runnable {
	private String content;
	private int index;
	private SpellChecker spellChecker;

	public WordChecker(String content, int index, SpellChecker spellChecker)
	{
		this.content = content;
		this.index = index;
		this.spellChecker = spellChecker;
		
	}

	@Override
	public void run() {
		boolean isSpelledCorrectly;
			if ((spellChecker.getDictionary()).contains(content))
			{
				isSpelledCorrectly = true;
			}
			else 
			{
				isSpelledCorrectly = false;
			}
			spellChecker.setResult(index, isSpelledCorrectly);
	}
}
