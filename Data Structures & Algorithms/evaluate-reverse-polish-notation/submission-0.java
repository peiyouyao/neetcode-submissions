class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> numStk=new ArrayList<>();
        for(String token:tokens){
            int res=0;
            try{
                res = Integer.parseInt(token);
            }catch(Exception e){
                int second=numStk.removeLast(), first=numStk.removeLast();
                switch(token.charAt(0)){
                case '+': res=first+second; break;
                case '-': res=first-second; break;
                case '*': res=first*second; break;
                case '/': res=first/second; break;
                }
            }
            numStk.add(res);
        }
        return numStk.get(0);
    }
}
