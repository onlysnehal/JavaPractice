package arrays;

//Practice code for LeetCode problem on BestTimeToBuyAndSellStock
// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0
public class BestTimeToBuySellStock {

    public static void main(String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};

        int min = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }

        System.out.println("Max profit : " + max);
    }
}
