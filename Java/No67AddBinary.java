/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */
class No67AddBinary {
    public String addBinary(String a, String b) {
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB);
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char[] res = new char[len];
        int mark = 0;
        int i = 0;
        for(; i<lenA && i<lenB; i++){
            int temp = mark + (int)(A[lenA-1-i] - '0') + (int)(B[lenB-1-i] - '0');
            mark = temp/2;
            temp = temp%2;
            res[len-1-i] = (char)(temp+'0');
        }
        while(i<lenA){
            int temp = mark + (int)(A[lenA-1-i] - '0');
            mark = temp/2;
            temp = temp%2;
            res[len-1-i] = (char)(temp+'0');
            i++;
        }
        while(i<lenB){
            int temp = mark + (int)(B[lenB-1-i] - '0');
            mark = temp/2;
            temp = temp%2;
            res[len-1-i] = (char)(temp+'0');
            i++;
        }
        if(mark==0) return new String(res);
        else return "1"+ new String(res);
    }
}

