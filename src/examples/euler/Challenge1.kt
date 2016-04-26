package examples.euler

import kotlin.system.measureTimeMillis

/**
 *  Challenge: If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 *  The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 *
 *  Created by kenlanderson on 4/25/16.
 */

const internal val MAXC1 = 999

fun main(args: Array<String>) {

    val benchMark = measureTimeMillis {
        val numberList = (1..MAXC1).asSequence()
        val c = Challenge1()
        val answer = c.getSumOfMultiple(numberList, 3) + c.getSumOfMultiple(numberList, 5) - c.getSumOfMultiple(numberList, 15)
        println("The answer is $answer")
    }
    print("Process completed in $benchMark milliseconds")
}

class Challenge1 {

    fun getSumOfMultiple(list: Sequence<Int> , multiple: Int) : Int {
        return list.filter { it % multiple == 0 }.sum()
    }
}