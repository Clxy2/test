package cn.clxy.tools.core.common;

/**
 * Utils for operating string.
 * @author clxy
 */
public final class StringUtil {

	/**
	 * Return true when Null or length = 0.
	 * @param string
	 * @return
	 */
	public static boolean isBlank(String string) {

		boolean result = string == null || string.length() == 0;
		return result;
	}

	private StringUtil() {
	}
}
