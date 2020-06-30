/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 思路分析：
 * 小偷偷盗至每一个房间时 都先思考一下 这个房间需不需要偷  投这个房间收益大还是前一个收益大
 * 动态方程：
 * dp[i]=Math.max(dp[i-1],dp[i-2]+dp[i])
 * 空间优化：小偷不会回去偷盗原来的房间 所以只要向后计算 即前面的数据不再访问 直接将前面的数组当成db即可
 */
public class rob {
    public static int result(int [] nums){
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        if(len ==2){
            return Math.max(nums[0],nums[1]);
        }
        nums[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            nums[i]=Math.max(nums[i-1],nums[i-2]+nums[i]);
        }
        return nums[len-1];
    }

    public static void main(String[] args) {
        int [] nums={9,1,1,10};
        int result = result(nums);
        System.out.println(result);
    }
}
