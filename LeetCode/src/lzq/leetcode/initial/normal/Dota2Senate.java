package lzq.leetcode.initial.normal;

public class Dota2Senate {
	public String predictPartyVictory(String senate) {
		char[] chars = senate.toCharArray();
		int rCount = 0;
		int dCount = 0;
		while (true) {
			boolean changed = false;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				if (c == 'D') {
					if (rCount > 0) {
						rCount--;
						changed = true;
						continue;
					} else {
						sb.append(c);
						dCount++;
					}
				} else {
					if (dCount > 0) {
						dCount--;
						changed = true;
						continue;
					} else {
						sb.append(c);
						rCount++;
					}
				}
			}
			if (changed) {
				chars = sb.toString().toCharArray();
			} else {
				return sb.charAt(0) == 'D' ? "Dire" : "Radiant";
			}
		}
	}

	public static void main(String[] args) {
		Dota2Senate d = new Dota2Senate();
		System.out.println(d.predictPartyVictory("DRDRDRRDR"));
	}

}
