class Solution {
    public boolean isValid(String s) {
        List<Character> stk=new ArrayList<>();
        for(char c:s.toCharArray()){
            boolean add=true;
            if (!stk.isEmpty()){
                char last=stk.getLast();
                if(
                    last=='(' && c==')' ||
                    last=='[' && c==']' ||
                    last=='{' && c=='}'
                ) {
                    stk.removeLast();
                    add=false;
                }
            }
            if (add) stk.add(c);
        }
        return stk.isEmpty();
    }
}
