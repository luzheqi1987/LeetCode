package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL {
	private static String TINT_URLBASE = "http://tinyurl.com/";
	private static Map<String, String> URL_MAP = new HashMap<>();

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param length
	 * @return 随机字符串
	 */
	public String createRandomStreamUrl(int length) {
		String invitationCode = "";
		// String strTable = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";
		String strTable = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
		int len = strTable.length();
		boolean bDone = true;
		do {
			invitationCode = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				invitationCode += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return invitationCode;
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String tinyUrlTail = createRandomStreamUrl(8);
		while (URL_MAP.keySet().contains(tinyUrlTail)) {
			tinyUrlTail = createRandomStreamUrl(8);
		}
		URL_MAP.put(tinyUrlTail, longUrl);
		return TINT_URLBASE + tinyUrlTail;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int index = shortUrl.lastIndexOf("/");
		String tinyUrlTail = shortUrl.substring(index + 1);
		return URL_MAP.get(tinyUrlTail);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncodeandDecodeTinyURL codec = new EncodeandDecodeTinyURL();
		System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
	}

}
