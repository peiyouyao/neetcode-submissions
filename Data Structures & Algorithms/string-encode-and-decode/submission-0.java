class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            int l=str.length();
            sb.append(String.valueOf(l));
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int i=0;
        char[] s=str.toCharArray();
        while(i<s.length){
            if(!Character.isDigit(s[i])) return null; // exception
            int l=0;
            while(i<s.length && s[i]!='#'){
                l *= 10;
                l += s[i]-'0';
                i++;
            }
            i++; // ship #
            int ni=i+l;
            StringBuilder sb=new StringBuilder();
            while(i<ni){
                sb.append(s[i]);
                i++;
            }
            res.add(sb.toString());
        }
        return res;
    }
}
