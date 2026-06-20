class Solution {
    String toPattern(String s){
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups=new HashMap<>();
        for(String str:strs){
            String pattern=toPattern(str);
            groups.putIfAbsent(pattern, new ArrayList<>());
            groups.get(pattern).add(str);
        }
        return new ArrayList(groups.values());
    }
}
