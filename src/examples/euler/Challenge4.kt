package examples.euler

import kotlin.system.measureTimeMillis

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
 * 9009 = 91 × 99. Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Created by kenlanderson on 4/26/16.
 */

fun main(args: Array<String>) {

    val c4 = Challenge4()
    val benchMark = measureTimeMillis {
        println(c4.largestThreeDigitProductPalindrome())
    }
    print("Process completed in $benchMark milliseconds")
}

class Challenge4 {

    fun largestThreeDigitProductPalindrome(): Int {
        var lp = 0
        var a = 999
        while (a >= 100) {
            var b = 999
            while (b >= 100) {
                if (a * b <= lp) {
                    break;
                }
                if (isPalindrome(a * b)) {
                    lp = a * b
                }
                b--
            }
            a--
        }
        return lp
    }

    private fun isPalindrome(input: Int): Boolean {
        fun reverse(n: Int): Int {
            var reversed: Int = 0
            var copyN: Int = n
            while (copyN > 0) {
                reversed = 10 * reversed + copyN % 10
                copyN /= 10
            }
            return reversed
        }
        return input == reverse(input)
    }


}
