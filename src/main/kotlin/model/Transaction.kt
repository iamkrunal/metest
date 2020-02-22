package model

import java.time.LocalDateTime

enum class TransactionType {
    PAYMENT, REVERSAL
}

public data class Transaction (
    val transactionId: String,
    val fromAccountId: String,
    val toAccountId: String,
    val createdAt: LocalDateTime,
    val amount: Float,
    val transactionType: TransactionType,
    val relatedTransaction: String
)