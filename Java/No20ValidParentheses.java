import java.util.Stack;

class No20ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()) {
      if(stack.isEmpty() || c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        char top = stack.pop();
        if(c == ')' && top != '(') return false;
        if(c == ']' && top != '[') return false;
        if(c == '}' && top != '{') return false;
      }
    }
    return stack.isEmpty();
  }
}