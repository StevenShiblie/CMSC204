/*
 * @Author-Steven Shiblie
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MorseCodeConverter {
	
	private static MorseCodeTree mct = new MorseCodeTree();

	public static String convertToEnglish(String string) {
		StringBuilder result = new StringBuilder();
		String[] words = string.trim().split("\\s*/\\s*");
		
		for(int i = 0; i < words.length; i++) {
			String word = words[i].trim();
			
			if(word.length() == 0) {
				if(i < words.length - 1) {
					result.append(" ");
				}
				continue;
			}
			
			String[] letters = word.split("\\s+");
			for(String code : letters) {
				if(!code.equals("")) {
					result.append(mct.fetch(code));
				}
			}
			if(i < words.length - 1) {
				result.append(" ");
			}
		}
		return result.toString().trim();
	}

	public static String printTree() {
		ArrayList<String> list = mct.toArrayList();
		StringBuilder sb = new StringBuilder();
		
		for(String letter : list) {
			sb.append(letter).append(" ");
		}
		
		if(sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String convertToEnglish(File file) throws FileNotFoundException{
		Scanner scan = new Scanner(file);
		StringBuilder sb = new StringBuilder();
		
		while(scan.hasNextLine()) {
			sb.append(scan.nextLine());
			if(scan.hasNextLine()) {
				sb.append(" ");
			}
		}
		scan.close();
		return convertToEnglish(sb.toString());
	}

}
