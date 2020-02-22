import service.*
import java.io.File

val CSV_FILE_PATH = "src/main/resources/transactions.csv"

fun main(args: Array<String>) {
    // Load all the transactions from the csv in the resource folder
    val transactions = loadCSV(args)

    // Ask for the user input for AccountId and the date range to calculate the balance at the time
    val userInput = readCommandInput()

    // using the transactions data from the file and user input calculate the balance
    val balanceOutput = calculateBalance(transactions, userInput)
    printBalanceOutput(balanceOutput)
}

private fun loadCSV(args: Array<String>) = when(args.isNotEmpty()) {
    true -> {
        readCSV(args[0])
    }
    else -> {
        val file = File(CSV_FILE_PATH)
        val filePath = when(file.exists()){
            true -> CSV_FILE_PATH
            else -> findFile()
        }
        readCSV(filePath)
    }
}

// temporary measure to find the file which is placed in root of the project
private fun findFile(): String {
    File("./").walk().forEach { file ->
        when(file.absolutePath.endsWith("transactions.csv")){
            true -> return file.absolutePath
        }
    }
    return "";
}




