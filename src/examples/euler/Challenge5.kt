package examples.euler

import kotlin.system.measureTimeMillis

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Created by kenlanderson on 4/27/16.
 */

const internal val MAXC5 = 20

fun main(args: Array<String>) {

    val c5 = Challenge5()
    val benchMark = measureTimeMillis {
        println(c5.answer(MAXC5).toString())
    }
    print("Process completed in $benchMark milliseconds")
}

class Challenge5 {

    fun answer(num: Int): Long {
        val seq = (2..num step 1).asIterable().reversed()
        var i: Long = num.toLong()
        var answerFound = false
        while (!answerFound) {
            for (n in seq) {
                if (i % n != 0L) {
                    answerFound = false
                    break;
                }
                answerFound = true
            }
            i++
        }
        return i - 1
    }

}