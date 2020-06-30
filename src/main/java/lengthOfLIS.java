/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 可以是连续的也可以是非连续的
 *
 */
public class lengthOfLIS {
    public static  int result(int [] nums){
        int max=1;
        int len=nums.length;
        int [] dp=new int[len];
        dp[0]=1;
        for(int i=1;i<len;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i] > max) {

                max=dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int [] nums={10,9,2,5,3,7,101,18};
        int result = result(nums);
        System.out.println(result);
    }
}
