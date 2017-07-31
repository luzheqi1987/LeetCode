package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZumaGame {
	public int findMinStep(String board, String hand) {
		if (hand == null || hand.equals("")) {
			return -1;
		}

		char[] boards = board.toCharArray();
		List<Character> boardChars = new ArrayList<>();
		
		Map<Character,Integer> handMap = new HashMap<>();
        handMap.put('R',0);
        handMap.put('Y',0);
        handMap.put('B',0);
        handMap.put('G',0);
        handMap.put('W',0);
        for (char h : hand.toCharArray()) {
            handMap.put(h, handMap.get(h) + 1);
        }

		for (char c : boards) {
			boardChars.add(c);
		}

		return findMin(boardChars, handMap);
	}

	private int findMin(List<Character> currentBoards, Map<Character, Integer> currentHands) {
		
		boolean isFind = true;
		while (isFind) {
			isFind = false;
			for (int i = 0; i < currentBoards.size() - 2; i++) {
				if (currentBoards.get(i) == currentBoards.get(i + 1)
						&& currentBoards.get(i + 1) == currentBoards.get(i + 2)) {
					int j = i + 2;
					while (j + 1 < currentBoards.size() && currentBoards.get(i) == currentBoards.get(j + 1)) {
						j++;
					}
					for (int m = j; m >= i; m--) {
						currentBoards.remove(m);
					}
					isFind = true;
					break;
				}
			}
		}

		if (currentBoards.isEmpty()) {
			return 0;
		}

		if (isHandEmpty(currentHands)) {
			return -1;
		}
		int count = 0;
        int min = Integer.MAX_VALUE;
        
		for (int i = 0; i < currentBoards.size(); i++) {
			char c = currentBoards.get(i);
			count++;
			
			if (i == currentBoards.size() - 1 || currentBoards.get(i+1) != c) {
                int missing = 3 - count;
                if (currentHands.get(c) >= missing) {
                	currentHands.put(c, currentHands.get(c) - missing);
                    List<Character> smallerBoard = new ArrayList<>(currentBoards);
                    for (int j = 0; j<count; j++) {
                        smallerBoard.remove(i-j);
                    }
                    int smallerFind = findMin(smallerBoard, currentHands);
                    if ( smallerFind != -1 ) {
                        min = Math.min(smallerFind + missing, min);
                    }
                    currentHands.put(c, currentHands.get(c) + missing);
                }
                count = 0;
            }
		}
		return (min == Integer.MAX_VALUE) ? -1 : min;
	}
	
	private boolean isHandEmpty(Map<Character,Integer> hand) {
        for (int val : hand.values()) {
            if (val > 0) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		String board = "WWRRBBWW";
		String hand = "WRBRW";

		ZumaGame z = new ZumaGame();
		System.out.println(z.findMinStep(board, hand));
	}

}
