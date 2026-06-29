class Solution {

    public int myAtoi(String s) {
        int n = s.length();

        long ans = myAlgo(s, 0, 0, n, false, false, false);

        return (int) ans;
    }


    public long myAlgo(String s, int i, long ans, int n,
                       boolean negative, boolean started, boolean signTaken) {

        if(i == n) {
            return negative ? -ans : ans;
        }


        int asci = s.charAt(i);


        // leading spaces
        if(asci == 32 && !started && !signTaken) {
            return myAlgo(s, i+1, ans, n, negative, started, signTaken);
        }


        // sign (+ or -)
        if((asci == '+' || asci == '-') && !signTaken && !started) {

            return myAlgo(
                s,
                i+1,
                ans,
                n,
                asci == '-',
                started,
                true
            );
        }


        // digit
        if(asci >= '0' && asci <= '9') {

            started = true;

            ans = ans * 10 + (s.charAt(i)-'0');


            if(!negative && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(negative && ans > 2147483648L)
                return Integer.MIN_VALUE;


            return myAlgo(s, i+1, ans, n, negative, started, signTaken);
        }


        // invalid character stops conversion
        return negative ? -ans : ans;
    }
}