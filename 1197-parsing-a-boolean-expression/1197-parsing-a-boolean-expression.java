class Solution {
    public boolean parseBoolExpr(String e) {
        //using stack
      Stack<Character> st = new Stack<>();
        for (char c : e.toCharArray()) {
            if (c == ',' || c == '(') continue;
            if (c == 't' || c == 'f' || c == '!' || c == '&' || c == '|') {
                st.push(c);
            } else if (c == ')') {
                boolean hasT = false, hasF = false;
                while (st.peek() != '!' && st.peek() != '&' && st.peek() != '|') {
                    char val = st.pop();
                    if (val == 't') hasT = true;
                    if (val == 'f') hasF = true;
                }
                char op = st.pop();
                if (op == '!') st.push(hasT ? 'f' : 't');
                else if (op == '&') st.push(hasF ? 'f' : 't');
                else if (op == '|') st.push(hasT ? 't' : 'f');
            }
        }
        return st.pop() == 't';
    }
}