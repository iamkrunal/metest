package service

import CSV_FILE_PATH
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert
import util.toDate

class BalanceServiceSpek : Spek({

    val transactions = readCSV(CSV_FILE_PATH)

    describe("In Calaculate Balance") {

        data class Scenario(
            val accountId: String,
            val fromTime: String,
            val toTime: String,
            val expectedBalance: Float,
            val expectedNumberOfTransactionIncluded: Int
        )

        listOf(
            Scenario("ACC334455","20/10/2018 12:00:00","20/10/2018 19:00:00",
                -35.5F, 2),
            Scenario("ACC334455","20/10/2018 12:00:00","20/10/2018 19:45:00",
                -25.0F, 3),
            Scenario("ACC334455","20/10/2018 12:00:00","21/10/2018 09:30:00",
                -32.25F, 4),
            Scenario("ACC778899","20/10/2018 12:00:00","20/10/2018 12:50:00",
                25.0F, 1),
            Scenario("ACC778899","20/10/2018 12:00:00","20/10/2018 18:00:00",
                30.0F, 2),
            Scenario("ACC778899","20/10/2018 12:00:00","21/10/2018 12:50:00",
                37.25F, 3),
            Scenario("ACC998877","20/10/2018 12:00:00","20/10/2018 12:50:00",
                0.0F, 0),
            Scenario("ACC998877","20/10/2018 12:00:00","20/10/2018 17:50:00",
                10.5F, 1),
            Scenario("ACC998877","20/10/2018 12:00:00","20/10/2018 18:50:00",
                5.5F, 2),
            Scenario("ACC998877","20/10/2018 12:00:00","20/10/2018 19:50:00",
                -5.0F, 3)
        ).forEach { scenario ->
            context("when provided with accountId: ${scenario.accountId} | from: ${scenario.fromTime} " +
                    "| to: ${scenario.toTime}"){

                val userInput = UserInput(
                    scenario.accountId,
                    toDate(scenario.fromTime),
                    toDate(scenario.toTime))

                val actual = calculateBalance(transactions, userInput)

                it("returns balance as ${scenario.expectedBalance}") {
                    Assert.assertEquals(scenario.expectedBalance, actual.balance)
                }

                it("returns number of transactions included " +
                        "as ${scenario.expectedNumberOfTransactionIncluded}") {
                    Assert.assertEquals(scenario.expectedNumberOfTransactionIncluded,
                        actual.numberOfTransactionsIncluded)
                }
            }
        }

    }
})