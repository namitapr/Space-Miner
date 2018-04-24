package ProjectPackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	private static String hashString(String message, String Algorithm) throws HashException {
		try {
			MessageDigest digest = MessageDigest.getInstance(Algorithm);
			byte[] bytes = digest.digest(message.getBytes("UTF-8"));
			return convert(bytes);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new HashException("Could not generate hash from string", e);
		}
	}
	private static String convert(byte[] bytes) {
		StringBuffer stringBuff = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuff.append(Integer.toString((bytes[i] & 0xff)+0x100, 16).substring(1));
		}
		return stringBuff.toString();
	}
	public static String SHA512(String message) throws HashException {
		return hashString(message, "SHA-512");
	}
}
