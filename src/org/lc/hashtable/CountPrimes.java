package org.lc.hashtable;


/**
 * Count the number of prime numbers less than a non-negative number, n

References:
How Many Primes Are There?

Sieve of Eratosthenes
 * @author Reacher
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {
		if(n <= 2 ) //less than
			return 0;
		
		boolean primes[] = new boolean[n+1];
		for (long i = 2; i <= n/2+1; i++) {
			if(primes[(int) i] == false) {
				for (long j = 2; j*i <= n; j++) {
					primes[(int) (j*i)] = true;
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i < n; i++) {
			if(primes[i] == false)
				count++;
		}
		return count;
	}
	
	@SuppressWarnings("unused")
	private boolean isPrime(long i) {
		boolean flag = true;
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if( i%j == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountPrimes ins = new CountPrimes();
		System.out.println(ins.countPrimes(4));
	}

}
