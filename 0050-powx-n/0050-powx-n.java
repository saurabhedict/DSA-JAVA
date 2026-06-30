// class Solution {
//     public double myPow(double x, int n) {
//         if(n==0) return 1;
//         double cal = 1;
//         if(n>0)  cal = x * myPow(x, n-1);
//         if(n<0)  cal = (1/x)*(myPow(x,n+1));
//        return cal;
//     }
// }



class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double cal = 1;
        double ans = myPow(x, n/2);
        if(n>0)  {
            if(n%2 == 0){
                cal = ans*ans;
            }
            else cal = ans*ans*x;
        }
        if(n<0)  {
            if(n%2 == 0){
                cal = ans*ans;
            }
            else cal = ans*ans*(1/x);
        }
       return cal;
    }
}