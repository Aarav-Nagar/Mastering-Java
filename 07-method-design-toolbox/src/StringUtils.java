import java.util.Locale;

public final class StringUtils {
    private StringUtils() {
    }

    public static String normalizeSpaces(String s) {
        if (s == null) {
            return "";
        }
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        boolean lastWasSpace = false;
        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);
            boolean isSpace = Character.isWhitespace(c);
            if (isSpace) {
                if (!lastWasSpace) {
                    out.append(' ');
                }
                lastWasSpace = true;
            } else {
                out.append(c);
                lastWasSpace = false;
            }
        }
        return out.toString();
    }

    public static int countOccurrences(String text, String needle) {
        return countOccurrences(text, needle, false);
    }

    public static int countOccurrences(String text, String needle, boolean ignoreCase) {
        if (text == null || needle == null) {
            return 0;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        String haystack = text;
        String target = needle;
        if (ignoreCase) {
            haystack = text.toLowerCase(Locale.ROOT);
            target = needle.toLowerCase(Locale.ROOT);
        }
        int count = 0;
        int from = 0;
        while (true) {
            int idx = haystack.indexOf(target, from);
            if (idx == -1) {
                return count;
            }
            count++;
            from = idx + target.length();
        }
    }

    public static boolean isPalindromeLettersOnly(String s) {
        if (s == null) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (!Character.isLetterOrDigit(a)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(b)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

