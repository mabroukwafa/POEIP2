package utils;

public class Utils {
    public static final int MAX = 26;
    public static String generateRandomString(int length){
        {
            char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u',
                    'v', 'w', 'x', 'y', 'z' };

            String res = "";
            for (int i = 0; i < length; i++)
                res += alphabet[(int) (Math.random() * 100 % MAX)];

            return res;
        }
    }
    public static String generateRandomEmail(int lengthBeforeAt, int lengthAfterAt){
        return generateRandomString(lengthBeforeAt) + "@" + generateRandomString(lengthAfterAt) + ".com";
    }
}
