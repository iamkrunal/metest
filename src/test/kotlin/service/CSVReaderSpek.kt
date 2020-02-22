package service

import model.TransactionType
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.Assert

class CSVReaderSpek : Spek({
    describe("in readCSV") {
        context("using a file in resources folder under test") {
            val filePath = "src/test/resources/transactions.csv"

            val transactions = readCSV(filePath)

            it("it has 5 records") {
                Assert.assertEquals(5, transactions.size)
            }

            it("first record's account id is ACC334455") {
                Assert.assertEquals("ACC334455", transactions[0].fromAccountId)
            }

            it("first record's relatedTransactionId is blank") {
                Assert.assertEquals("", transactions[0].relatedTransaction)
            }

            it("third record's transaction type is PAYMENT") {
                Assert.assertEquals(TransactionType.PAYMENT, transactions[2].transactionType)
            }

            it("fourth record's transaction type is REVERSAL") {
                Assert.assertEquals(TransactionType.REVERSAL, transactions[3].transactionType)
            }

            it("fifth record's amount is 7.25") {
                Assert.assertEquals(7.25F, transactions[4].amount)
            }

        }
    }
})