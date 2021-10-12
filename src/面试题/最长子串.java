package 面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class 最长子串 {
    public static void main(String[] args) {
        String s="abcabedc";
        int num=lengthOfLongestSubstring(s);
        System.out.println(num);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (s == null || n <= 0) return 0;
        int start = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < n; end++) {
            char chart = s.charAt(end);
            if (map.containsKey(chart)) {
                start = Math.max(map.get(chart), start);
            }
            map.put(chart, end + 1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
