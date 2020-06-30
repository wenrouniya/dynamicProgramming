/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 动态转移方程
 * dp[1]=1;
 * dp[2]=2;
 * dp[n]=dp[n-1]+dp[n-2];n>2
 */
public class climbStairs {
    private static int []  dp;
    public static  int result(int n){
        if(n<0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res=result(2);
        System.out.println(res);
    }

}
