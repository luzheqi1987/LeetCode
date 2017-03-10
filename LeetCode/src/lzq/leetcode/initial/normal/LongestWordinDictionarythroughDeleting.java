package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {

	public String findLongestWord(String s, List<String> d) {
		char[] charNumber = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			charNumber[i] = s.charAt(i);
		}

		Collections.sort(d, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				return o1.compareTo(o2);
			}

		});

		for (String str : d) {
			int i = 0;
			int j = 0;
			for (; i < str.length(); i++) {
				for (; j < charNumber.length; j++) {
					if (str.charAt(i) == charNumber[j]) {
						j++;
						if (i == str.length() - 1) {
							return str;
						}
						break;
					}
				}
			}
		}

		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWordinDictionarythroughDeleting l = new LongestWordinDictionarythroughDeleting();
		List<String> strs = new ArrayList<String>();
//		strs.add("ale");
//		strs.add("apple");
//		strs.add("monkey");
//		strs.add("plea");
		strs.add("aaa");
		strs.add("aa");
		strs.add("a");
		//strs.add("awef");
		//strs.add("awefe");
		//strs.add("ewafeffewafewf");
		//strs.add("jpthiudqzzeugzwwsngebdeai");
		System.out.println(l.findLongestWord("wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi", strs));
	}

}
