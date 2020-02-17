import java.util.List;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @seb129 Sydney Ballard
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {

		myWords = new String[size];
		for (int i=0 ; i < size ; i++) {
			myWords[i] = source[start+i];
		}

		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns number of words in myWords String[]
	 * @return num word in myWords
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Overrides .equals() method to compare word gram objects
	 * @param o
	 * @return Boolean -- T if o is instance of WordGram / F if not or null value
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram oWord = (WordGram) o;
		// Check lengths
		if (oWord.length() != this.length()) {
			return false;
		}
		// Check letter equivalency
		for (int i=0 ; i < oWord.length(); i++) {
			if (!oWord.myWords[i].equals(this.myWords[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		// Create hash code
		myHash = this.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Shifts word gram object and places new word in last index
	 * @param last is last String of returned WordGram
	 * @return new word gram objects, shifted
	 */
	public WordGram shiftAdd(String last) {

		WordGram wg = new WordGram(myWords,0,myWords.length);

		for (int i=1 ; i<myWords.length ; i++) {
			wg.myWords[i-1] = wg.myWords[i];
		}
		// Make final idx equal to String, last
		wg.myWords[wg.myWords.length - 1] = last;
		return wg;

	}

	@Override
	public String toString(){
		// Create String from  myWords array with space between each word
		myToString = String.join(" ", myWords);

		return myToString;
	}
}
