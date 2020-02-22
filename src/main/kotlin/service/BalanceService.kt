package service

import model.Transaction
import model.TransactionType

data class BalanceOutput(
    val balance: Float,
    val numberOfTransactionsIncluded: Int
)

fun calculateBalance(transactions: List<Transaction>, userInput: UserInput) : BalanceOutput {

    val list = transactions.filter{ transaction ->
        (transaction.fromAccountId == userInput.accountId || transaction.toAccountId == userInput.accountId)
                && userInput.fromTime <= transaction.createdAt && userInput.toTime >= transaction.createdAt
    }.fold(listOf<Float>()) { list, transaction -> when(transaction.fromAccountId == userInput.accountId) {
             true -> when(transaction.transactionType == TransactionType.PAYMENT){
                 true -> list.plus(-1*transaction.amount)
                 else -> list.plus(transaction.amount)
             }
            else -> when(transaction.transactionType == TransactionType.PAYMENT){
                true -> list.plus(transaction.amount)
                else -> list.plus(-1*transaction.amount)
            }
        }
    }

    return BalanceOutput(list.sum(), list.size)
}