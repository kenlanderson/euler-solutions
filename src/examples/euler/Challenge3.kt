package examples.euler

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/**
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143 ?
 *
 * Created by kenlanderson on 4/26/16.
 */

fun main(args: Array<String>) {

    val largeNum: Long = 600851475143L
    var x: Long = largeNum
    var factor = 2
    val benchMark = measureNanoTime {
        while (factor < x) {
            if (x % factor == 0L) {
                x /= factor
                factor--
            }
            factor++
        }
        println("The largest prime factor is $factor")
    }
    print("Process completed in $benchMark nanoseconds")
}