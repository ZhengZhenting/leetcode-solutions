	// push, pop(top), peek(top), isEmpty, size, search, for-each(bottom to top)
	// Stack<Integer> stack = new Stack<>();
	// Deque<Integer> stack = new ArrayDeque<>();
	
	class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(c==')' && top != '(') return false;
                if(c==']' && top != '[') return false;
                if(c=='}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}

	
	