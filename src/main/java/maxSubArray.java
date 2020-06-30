/**
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 动态方程：
 * dp[0]=nums[0];
 * dp[i]=max(dp[i-1]+nums[i],nums[i]);
 */
public class maxSubArray {
    public  static int result(int [] nums){
        int len=nums.length;
        int [] dp=new int[len];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums={2,1,-3,4,-1,2,1,-5,4};
        int result = result(nums);
        System.out.println(result);
    }
}
