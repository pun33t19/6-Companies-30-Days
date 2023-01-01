package Microsoft;

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:

// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.

import java.util.Stack;

/**
 * ReversePolishNotation
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res = 0;

        // iterate through all the string tokens
        for (String s : tokens) {

            // if we find a operation we pop the last two elements, evaluate it and then put
            // it back on stack
            // else we push the curren element to stack.
            if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                int se = Integer.valueOf(stack.pop());
                int fi = Integer.valueOf(stack.pop());

                res = op(fi, se, s);

                stack.push(String.valueOf(res));
            } else
                stack.push(s);
        }

        if (!stack.isEmpty())
            return Integer.valueOf(stack.pop());

        return res;
    }

    // function just to perform the operation
    int op(int fi, int se, String s) {
        int res = 0;

        if (s.equals("+"))
            res = fi + se;
        else if (s.equals("-"))
            res = fi - se;
        else if (s.equals("*"))
            res = fi * se;
        else
            res = fi / se;

        return res;
    }
}

public class ReversePolishNotation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = { "4", "13", "5", "/", "+" };
        System.out.println(sol.evalRPN(arr));

    }

}