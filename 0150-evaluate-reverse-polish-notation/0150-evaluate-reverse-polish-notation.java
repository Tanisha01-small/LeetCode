import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> eval = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int y = eval.pop();
                int x = eval.pop();
                int result;
                if (token.equals("+")) {
                    result = x + y;
                } else if (token.equals("-")) {
                    result = x - y;
                } else if (token.equals("*")) {
                    result = x * y;
                } else {
                    result = x / y;
                }
                eval.push(result);
            } else {
                eval.push(Integer.parseInt(token));
            }
        }
        return eval.pop();
    }
}
