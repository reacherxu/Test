package org.lc.dp;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author Reacher
 *
 */
public class BestTimeBuySellStock {
	public int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		int max = 0,minPrice = prices[0];
		prices[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - minPrice;
			max = Math.max(max, profit);
			minPrice = Math.min(prices[i], minPrice);
		}
		return max;
	}

	public static void main(String[] args) {
		BestTimeBuySellStock ins = new BestTimeBuySellStock();
		int A[] = {2,1,5};
		System.out.println(ins.maxProfit(A));
	}
}
