package com.ayushman.search.binary;

/**
 * <a
 * href="https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/">Leetcode
 * Link</a> 2064. Minimized Maximum of Products Distributed to Any Store
 *
 * <p>You are given an integer n indicating there are n specialty retail stores. There are m product
 * types of varying amounts, which are given as a 0-indexed integer array quantities, where
 * quantities[i] represents the number of products of the ith product type.
 *
 * <p>You need to distribute all products to the retail stores following these rules:
 *
 * <p>A store can only be given at most one product type but can be given any amount of it. After
 * distribution, each store will have been given some number of products (possibly 0). Let x
 * represent the maximum number of products given to any store. You want x to be as small as
 * possible, i.e., you want to minimize the maximum number of products that are given to any store.
 * Return the minimum possible x.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 6, quantities = [11,6] Output: 3 Explanation: One optimal way is: - The 11 products
 * of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3 - The 6 products
 * of type 1 are distributed to the other two stores in these amounts: 3, 3 The maximum number of
 * products given to any store is max(2, 3, 3, 3, 3, 3) = 3. Example 2:
 *
 * <p>Input: n = 7, quantities = [15,10,10] Output: 5 Explanation: One optimal way is: - The 15
 * products of type 0 are distributed to the first three stores in these amounts: 5, 5, 5 - The 10
 * products of type 1 are distributed to the next two stores in these amounts: 5, 5 - The 10
 * products of type 2 are distributed to the last two stores in these amounts: 5, 5 The maximum
 * number of products given to any store is max(5, 5, 5, 5, 5, 5, 5) = 5. Example 3:
 *
 * <p>Input: n = 1, quantities = [100000] Output: 100000 Explanation: The only optimal way is: - The
 * 100000 products of type 0 are distributed to the only store. The maximum number of products given
 * to any store is max(100000) = 100000.
 *
 * <p>Constraints:
 *
 * <p>m == quantities.length 1 <= m <= n <= 105 1 <= quantities[i] <= 105
 */
public class MinimizedMaximumOfProductDistribution {

  public int minimizedMaximum(int n, int[] quantities) {
    int start = 1, end = Integer.MIN_VALUE, mid, res = -1;

    for (int q : quantities) {
      if (q > end) {
        end = q;
      }
    }

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (isDistributionPossible(quantities, mid, n)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return res;
  }

  boolean isDistributionPossible(int[] quantities, int maxProduct, int maxStores) {
    int stores = 0;
    for (int i = 0; i < quantities.length; i++) {
      stores += quantities[i] / maxProduct;
      if (quantities[i] % maxProduct != 0) {
        stores += 1;
      }
      if (stores > maxStores) {
        return false;
      }
    }
    return true;
  }
}
