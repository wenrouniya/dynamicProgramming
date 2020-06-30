/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积.
 *
 */
public class integerBreak {

    public  static  int result(int n){
        if(n ==1) return 0;//不能拆分成整数的不符合规范的输入
        int [] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                //第一个max是比较历次拆分相乘的最大值  第二个max是比较当前j的值大还是将j再拆分得到的乘积大
                dp[i]=Math.max(dp[i],Math.max(j,dp[j])*(i-j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int result = result(7);
        System.out.println(result);
    }
}
