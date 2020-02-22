package service

import util.toDate
import java.time.LocalDateTime
import java.util.*

data class UserInput(
    val accountId: String,
    val fromTime: LocalDateTime,
    val toTime: LocalDateTime
)

fun readCommandInput(): UserInput {
    val input = Scanner(System.`in`)
    print("Please enter the accountId: ")
    val accountId = input.nextLine()
    println("Account ID You entered: $accountId")

    print("Please enter from date/time: ")
    val fromTime = input.nextLine()
    println("From Time you entered: $fromTime")

    print("Please enter to date/time: ")
    val toTime = input.nextLine()
    println("To Time you entered: $toTime")

    return UserInput(accountId.trim(), toDate(fromTime.trim()), toDate(toTime.trim()))
}

fun printBalanceOutput(balanceOutput: BalanceOutput) {
    println("Relative balance for the period is: ${balanceOutput.balance}")
    println("Number of transactions included is: ${balanceOutput.numberOfTransactionsIncluded}")
}