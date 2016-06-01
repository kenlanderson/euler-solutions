package examples.euler

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Created by kenlanderson on 6/1/16.
 */

const internal val MAXC9 = 1000

fun main(args: Array<String>) {
    val c9 = Challenge9();
    var benchMark = measureNanoTime {
        println("The answer is "+c9.solve(MAXC9));
    }
    print("Process completed in $benchMark nanoseconds")
}

class Challenge9 {
    //Triples computed by a = n^2 - m^2, b = 2nm, c = n^2 + m^2 where n>m

    fun solve(sum: Int): Int {
        var m = 3;
        var n = 4;
        var a = 0;
        var b = 0;
        var c = 0;
        var sumCheck = 0;
        while (n < sum && sumCheck != sum) {
            while ( m < n && sumCheck != sum) {
                a = computeA(n, m);
                b = computeB(n, m);
                c = computeC(n, m);
                sumCheck = a + b + c;
                m++;
            }
            m = 3;
            n++;
        }
        return (a * b * c);
    }

    fun computeA(n: Int, m: Int): Int {
        return (Math.pow(n.toDouble(), 2.toDouble()) - Math.pow(m.toDouble(), 2.toDouble())).toInt();
    }

    fun computeB(n: Int, m: Int): Int {
        return 2 * n * m;
    }

    fun computeC(n: Int, m: Int): Int {
        return (Math.pow(n.toDouble(), 2.toDouble()) + Math.pow(m.toDouble(), 2.toDouble())).toInt();
    }

}
