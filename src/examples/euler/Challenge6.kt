package examples.euler;

import kotlin.system.measureNanoTime;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */


const internal val MAXC6 = 100

fun main(args: Array<String>) {
    var c6 = Challenge6();
    var benchMark = measureNanoTime {
        var sumOfSquares = c6.sumOfSquares(MAXC6);
        var squareOfSum = c6.squareOfSum(MAXC6);
        println(squareOfSum - sumOfSquares);
    }
    print("Process completed in $benchMark nanoseconds")
}

class Challenge6 {

    fun sumOfSquares(n: Int): Int {
        if (n == 0) {
            return 0;
        }
        return (n * n) + sumOfSquares(n - 1);
    }

    fun squareOfSum(n: Int): Int {
        val sum = sum(n);
        return sum * sum;
    }

    fun sum(n: Int): Int {
        if(n == 0){
            return 0;
        }
        return n + sum(n-1);
    }

}