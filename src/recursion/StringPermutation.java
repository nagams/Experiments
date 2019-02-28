package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all permutations of a string where all characters in the given string are unique
 *
 * @author Nagaraja Settra
 */
public class StringPermutation {
    public static void main(String[] args) {
        List<String> rl = permute("abc");
        System.out.println("Found " + rl.size() + " combinations for input str: abc");
        System.out.println(rl);

        List<String> rl2 = permute("abcd");
        System.out.println("Found " + rl2.size() + " combinations for input str: abc");
        System.out.println(rl2);
    }

    static List<String> permute(String str) {
        if (str.length() == 1) {
            return Arrays.asList(str);
        }

        return addOneChar(permute(str.substring(0, str.length()-1)), str.charAt(str.length()-1));
    }

    static List<String> addOneChar(List<String> strList, char ch) {
        List<String> newList = new ArrayList<>();

        for (String str : strList) {
            newList.addAll(addOneCharHelper(str, ch));
        }

        return newList;
    }

    static List<String> addOneCharHelper(String str, char ch) {
        List<String> combs = new ArrayList<>();

        for (int i=0; i<str.length()+1; i++) {
            StringBuilder sb = new StringBuilder(str);
            combs.add(sb.insert(i, ch).toString());
        }

        return combs;
    }
}
