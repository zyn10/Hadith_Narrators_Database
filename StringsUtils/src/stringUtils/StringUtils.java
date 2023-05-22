package stringUtils;
import java.nio.charset.Charset;
public class StringUtils {
	public boolean isUpperCase(String s) {
		boolean result = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}

	public boolean isLowerCase(String s) {

		boolean result = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}

	public boolean isEmpty(String s) {
		boolean result = false;

		if (s == null || s.length() == 0) {
			result = true;
		} else {
			return false;
		}
		return result;
	}

	public boolean hasNumber(String s) {
		boolean result = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 0 && s.charAt(i) <= 9) {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}
	
	 public boolean isPureAscii(String v) {
		    return Charset.forName("US-ASCII").newEncoder().canEncode(v);
		  }
//	 
//
//	public boolean hasSpecial(String s) {
//		boolean result = false;
//		for (int i = 0; i < s.length(); i++) {
//			if (isPureAscii(s.charAt(i))) {
//				result = true;
//			} else {
//				return false;
//			}
//		}
//		return result;
//	}
//	
//public boolean checkcheck(String s) {
//	boolean result = false;
//	if (s == null ||s.length()==0)
//		result = true;
//   boolean hasUppercase = isUpperCase(s);
//   if (hasUppercase) {
//     bool hasDigits = hasNumbers(s);
//     if (!hasDigits) {
//       bool hasLowercase = isLowerCase(s);
//       if (!hasLowercase) {
//         bool hasSpecialCharacters =
//     ;
//         return hasSpecialCharacters;
//       }
//     }
//   }
//
//   return false;
// }
}
