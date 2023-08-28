class Solution {
    public String removeOuterParentheses(String A) {
        StringBuilder s = new StringBuilder();
        int count = 0;

        for (char c : A.toCharArray()) {
            if (c == '(') {
                if (count > 0) {
                    s.append(c);
                }
                count++;
            } else if (c == ')') {
                count--;
                if (count > 0) {
                    s.append(c);
                }
            }
        }

        return s.toString();
    }
}
