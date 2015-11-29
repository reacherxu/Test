package org.lc.dp;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 * @author Reacher
 *
 */
public class BestTimeBuySellStockIII {
	public int maxProfit(int[] prices,int start,int end) {
		if(prices.length == 0)
			return 0;
		
		int max = 0,minPrice = prices[start];
		prices[0] = 0;
		for (int i = start+1; i < end; i++) {
			int profit = prices[i] - minPrice;
			max = Math.max(max, profit);
			minPrice = Math.min(prices[i], minPrice);
		}
		return max;
	}

	public static void main(String[] args) {
		BestTimeBuySellStockIII ins = new BestTimeBuySellStockIII();
		int A[] = {2,1,5};
		System.out.println(ins.maxProfit(A,0,A.length));
	}
}
