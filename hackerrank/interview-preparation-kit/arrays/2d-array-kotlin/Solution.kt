// https://www.hackerrank.com/challenges/2d-array/problem
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

fun hourglassSum(arr: Array<Array<Int>>, startRow: Int, startCol: Int): Int {
    var sum = 0;
    for (col in startCol..startCol+2) {
        sum += arr[startRow][col] + arr[startRow+2][col]
    }

    return sum + arr[startRow+1][startCol+1]
}

fun getHighestHourglassSum(arr: Array<Array<Int>>): Int {
    var highestSum = Integer.MIN_VALUE
    for (col in 0..3) {
        for (row in 0..3) {
            val curSum = hourglassSum(arr, row, col)
            highestSum = if (curSum > highestSum) curSum else highestSum
        }
    }

    return highestSum
}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = getHighestHourglassSum(arr)

    println(result)
}
