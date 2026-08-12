class Solution {
    String[] num2letter=new String[]{
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };
    StringBuilder path=new StringBuilder();
    List<String> paths=new ArrayList<>();
    char[] digits;
    void backtrack(int idx){
        if(idx==digits.length){
            paths.add(path.toString());
            return;
        }
        int len=path.length();
        for(char c:num2letter[digits[idx] - '0'].toCharArray()){
            path.append(c);
            backtrack(idx+1);
            path.setLength(len);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))return paths;
        this.digits=digits.toCharArray();
        backtrack(0);
        return paths;
    }
}
