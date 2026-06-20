class Solution {
    static char validate(char c){
        if (Character.isDigit(c)) return c;
        if ('a' <= c && c <= 'z') return c;
        if ('A' <= c && c <= 'Z') return (char)(c + ' ');
        return '.';
    }

    public boolean isPalindrome(String s) {
        int n=s.length();
        int l=0, r=n-1;
        while(l<r){
            char cl=s.charAt(l), cr=s.charAt(r);
            cl=validate(cl); cr=validate(cr);
            if (cl=='.') l++;
            else if (cr=='.') r--;
            else{
                if (cl != cr) return false;
                l++;
                r--;
            }
        }
        return true;
    }
}
