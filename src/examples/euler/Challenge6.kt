package examples.euler;

import kotlin.system.measureTimeMillis

const internal val MAXC6 = 100

fun main(args: Array<String>) {
    var c6 = Challenge6();
    var benchMark = measureTimeMillis {
        var sumOfSquares = c6.sumOfSquares(MAXC6);
        var squareOfSum = c6.squareOfSum(MAXC6);
        println(squareOfSum - sumOfSquares);
    }
    print("Process completed in $benchMark milliseconds")
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