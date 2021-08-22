// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

fun Array<Int>.rotateLeftByOne() {
    var firstValue = this[0];
    for(i in 0..this.size-2) {
        this[i] = this[i+1]
    }
    this[this.size-1] = firstValue
}

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    for(i in 1..d) {
        a.rotateLeftByOne()
    }

    return a
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}

