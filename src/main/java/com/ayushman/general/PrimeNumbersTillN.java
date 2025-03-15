package com.ayushman.general;

import java.util.Arrays;

/*
 * sieve of eratosthenes
 *
 * - mark all as prime -> true
 * - if prime mark all multiplications as false
 * */
public interface PrimeNumbersTillN {

    public static void main(String[] args) {
        sieveOfEratosthenes(50);
    }

    static void sieveOfEratosthenes(int number) {

        boolean[] primes = new boolean[number + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= number; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= number; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i <= number; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

}
