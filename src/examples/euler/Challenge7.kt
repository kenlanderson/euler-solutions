package examples.euler

import kotlin.system.measureTimeMillis

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * Created by kenlanderson on 5/1/16.
 */

const internal val MAXC7 = 10001

fun main(args: Array<String>) {
    val chal = Challenge7()
    val benchMark = measureTimeMillis {
        val answer = chal.solve(MAXC7)
        println(answer)
    }
    print("Process completed in $benchMark milliseconds")
}

class Challenge7 {

    fun solve(primeLength: Int): Int {

        var primeList = arrayListOf<Int>()
        primeList.add(2)
        //Rosser's Theorem https://en.wikipedia.org/wiki/Rosser%27s_theorem
        val upperBound = primeLength * Math.log(primeLength.toDouble()) + primeLength * Math.log(Math.log(primeLength.toDouble()))
        var candidates = (3..upperBound.toInt() step 2).toList()
        var primesFound = 1
        var c: Int
        while (primeList.size < primeLength) {
            c = candidates.get(primesFound-1)
            if (isPrime(c)) {
                primeList.add(c)
                candidates = candidates.filter { it % c != 0 }
            }
        }
        return primeList.last()
    }

    fun isPrime(n: Int): Boolean {
        val limit = Math.floor(Math.sqrt(n.toDouble())).toInt()
        var index = 2;
        while (index <= limit) {
            if (n % index == 0) {
                return false;
            }
            index++
        }
        return true;
    }

}