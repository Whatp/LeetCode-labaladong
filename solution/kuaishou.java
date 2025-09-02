public class kuaishou {

    public static int maxContinuousParentheses(String s) {
        int n = s.length();
        int current = 0;
        int maxCount = 0;
        int i = 0;
        while (i < n - 1) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                current++;
                if (current > maxCount) {
                    maxCount = current;
                }
                i += 2; // 跳过两个字符
            } else {
                current = 0;
                i++;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s1 = "()()(())()()()((((()))))";
        String s2 = "()()(())()";
        String s3 = "()()()";
        String s4 = "(())()()";

        System.out.println(maxContinuousParentheses(s1)); // 输出: 3
        System.out.println(maxContinuousParentheses(s2)); // 输出: 2
        System.out.println(maxContinuousParentheses(s3)); // 输出: 3
        System.out.println(maxContinuousParentheses(s4)); // 输出: 2
    }
}

