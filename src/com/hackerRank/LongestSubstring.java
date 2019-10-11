package hackerRank;

public class LongestSubstring {
    public static void main(String args[]) {
        String s = "pwwkew";
        String a = "au";
        String b = "dvdf";
        String c = "";
//        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstring(a));
//        System.out.println(lengthOfLongestSubstring(b));
        System.out.println(lengthOfLongestSubstring(c));

}
    public static int lengthOfLongestSubstring(String str){
        final int NO_OF_CHARS = 256;
        int n = str.length();
        int cur_len = 1;
        int max_len = 1;
        int prev_index;
        int visited[] = new int[NO_OF_CHARS];
        if(str.length() == 0){
            return 0;
        }
        for (int i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }
        visited[str.charAt(0)] = 0;
        for (int i = 1; i < n; i++) {
            prev_index = visited[str.charAt(i)];
            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else {
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }
            visited[str.charAt(i)] = i;
        }
        if (cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }
}
