package lzq.leetcode.initial.normal;

public class ValidateIPAddress {
	public String validIPAddress(String IP) {
		if (IP.length() > 50) {
			return "Neither";
		}
		//String ipv4Parten = "([([0-9])([(1[0-9]{1,2})])([(2[([0-4][0-9])][(5[0-5])])])]\\.){3}[0-9]+";
		//String ipv4Parten = "[0-9]+[\\.0-9]+[0-9]+";
		String ipv4Parten = "(((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
		String ipv6Parten = "[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}";

		if (IP.matches(ipv4Parten)) {			
			return "IPv4";
		} else if (IP.matches(ipv6Parten)) {
			String[] parts = IP.split(":");
			if (parts.length != 8) {
				return "Neither";
			}
			for (String part : parts) {
				//if (part.length() == 1 && !part.equals("0")) {
				//	return "Neither";
				//}
				if (part.length() <= 0 || part.length() > 4) {
					return "Neither";
				}
			}
			return "IPv6";
		}

		return "Neither";

	}

	public static void main(String[] args) {
		String s1 = "172.16.254.1";
		String s2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
		String s3 = "256.256.256.256";

		ValidateIPAddress validateIPAddress = new ValidateIPAddress();
		System.out.println(validateIPAddress.validIPAddress(s1));
		System.out.println(validateIPAddress.validIPAddress(s2));
		System.out.println(validateIPAddress.validIPAddress(s3));

	}

}
