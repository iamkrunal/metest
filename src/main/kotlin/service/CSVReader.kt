package service

import model.Transaction
import model.TransactionType
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import util.toDate
import java.nio.file.Files
import java.nio.file.Paths

fun readCSV(transactionFilePath: String): List<Transaction> {

    println("path: $transactionFilePath");

    // read the file
    val reader = Files.newBufferedReader(Paths.get(transactionFilePath))

    // parse the file into csv values
    val csvParser = CSVParser(reader, CSVFormat.DEFAULT)
    val transactions = csvParser.fold(listOf<Transaction>()) {
            transactions, csvRecrod -> when(!csvRecrod.get(0).startsWith("transactionId")) {
            true -> transactions.plus(toTransaction(csvRecrod))
            else -> emptyList()
        }
    }

    transactions.forEach { trans ->
        println(trans)
    }

    return transactions
}

fun toTransaction(csvRecord: CSVRecord): Transaction {
    // Accessing Values by Column Index
    val transactionId = csvRecord.get(0).trim()
    val fromAccountId = csvRecord.get(1).trim()
    val toAccountId = csvRecord.get(2).trim()
    val createdAt = toDate(csvRecord.get(3))
    val amount = csvRecord.get(4).toFloat()
    val transactionType = TransactionType.valueOf(csvRecord.get(5).trim())
    val relatedTransaction = when(csvRecord.size() > 6) {
        true -> csvRecord.get(6).trim()
        else -> ""
    }

    return Transaction(transactionId, fromAccountId, toAccountId, createdAt, amount, transactionType, relatedTransaction)
}