package me.dvsgn.leetcode;

import java.util.Stack;

public class Jju_test06 {
    public static void main(String[] args) {
        Solution_test06 s = new Solution_test06();
    }
}


/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"

    Output: true

    Example 2:

    Input: s = "()[]{}"

    Output: true

    Example 3:

    Input: s = "(]"

    Output: false

    Example 4:

    Input: s = "([])"

    Output: true
*/

class Solution_test06 {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            //( { [
            if (c == '(') {
                stk.push(')');
            } else if (c == '{') {
                stk.push('}');
            } else if (c == '[') {
                stk.push(']');
            } else{
                if(stk.isEmpty()) {
                    return false;
                }
                if (c == ')') {
                    if (stk.peek() != ')') {
                        return false;
                    }
                } else if (c == '}') {
                    if (stk.peek() != '}') {
                        return false;
                    }
                } else if (c == ']') {
                    if (stk.peek() != ']') {
                        return false;
                    }
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}