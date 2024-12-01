import org.apache.commons.codec.digest.DigestUtils;

public class umshash {
	public static String getHashCode(String s)
	{
		return DigestUtils.sha256Hex(s);
	}

}
