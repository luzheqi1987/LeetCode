package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> allWords = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(String word : words){
        	allWords.add(word);
        }
        
        for(String word : words){
        	if(checkConcatenated(word, 0, allWords, 0)){
        		result.add(word);
        	}
        }
        return result;
    }
    
    private boolean checkConcatenated(String word, int index, Set<String> words, int currentWordNum){
    	if(index >= word.length() && currentWordNum >= 2){
    		return true;
    	}
    	for(int i = index; i < word.length(); i++){
    		if(words.contains(word.substring(index, i + 1))){
    			if(checkConcatenated(word, i + 1, words, currentWordNum + 1)){
    				return true;
    			}
    		}
    	}
    	return false;
    }

	public static void main(String[] args) {
		String[] strs = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		ConcatenatedWords concatenatedWords = new ConcatenatedWords();
		
		List<String> result = concatenatedWords.findAllConcatenatedWordsInADict(strs);
		for(String s : result){
			System.out.print(s + " ");
		}
		System.out.println();
	}

}
