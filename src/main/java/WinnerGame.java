import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * Alice 和 Bob 两个人轮流玩一个游戏，Alice 先手。
 *
 * 一开始，有 n 个石子堆在一起。每个人轮流操作，正在操作的玩家可以从石子堆里拿走 任意 非零 平方数 个石子。
 *
 * 如果石子堆里没有石子了，则无法操作的玩家输掉游戏。
 *思路分析：当没有石子拿的时候就变成了必输状态 当后手玩家是必输状态是 先手玩家必胜
 * 动态规划： 从dp【0】开始向后计算 标记 当前是必胜还是必输状态 向后推理
**/
public class WinnerGame {

    public static  boolean  result(int n){
       boolean [] dp= new boolean [n+1];//初始默认值为false
        for(int i=1;i<=n;i++){
            for(int k=1;k*k<=i;k++){
                if(dp[i-k*k]== false){ //如果拿了k个之后的石子是必输状态 那么当前i个石子就是必胜状态
                    dp[i] =true;
                    break; //有一种拿法可以使我必胜即可 找到后退出循环
                }
            }
        }
       return dp[n];

    }

    public static void main(String[] args) {
        boolean result = result(5);
        System.out.println(result);
    }
}
