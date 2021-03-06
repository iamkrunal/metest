# metest
This application is about loading a csv transactions file and output the balance according the input provided by the user

# Technology stack used in this project
1. kotlin 1.3.61
2. Java 1.8 (AdaptOpenJdk)
3. Gradle 6.2 (build)
4. JUnit 5.6.2 (Unit testing)
5. Spek Framework 1.1.5 (Unit testing)
6. IntelliJ IDEA (Editor)
7. Spek plugin (Official IntelliJ IDEA plugin) installed on IntelliJ to help running test from IDE

# Project explained
* Main.kt               - This file used to orchestrate the whole process of loading the file, receiving the input and presenting the
* CSVReader.kt          - Loading the transactions file
* CommandLineService.kt - Handles the commandling input and output to the users
* BalanceService.kt     - According the users input provided it searches the transactions for the relative time and produces the output
* DateUtils.kt          - This class currently used to convert any formated string to date
* Transaction.kt        - Data class to hold the data for a transaction
* UserInput.kt          - Data class to hold the user input provided through command line

# Unit Tests
BDD test has been used
* CSCReaderSpek.kt      - Tests to make sure if the file presents then it loads all the records
                      - Checks to see if the values are loaded as expected for each field
* DateUtilsSpek.kt      - Tests that the valid date string provided has been converted as expected and checks all part of date
                      - Also if the date string is not in valid format then it throws expected exception
* BalanceServiceSpek.kt - Tests all the scenario which is for all account id and different date ranges to make sure it returns 
                        the correct out put balance.
                      - Tests non existant account id and/or date range which return ZERO balance
                      
   ![Test results](./images/test_results.PNG?raw=true "Test Results")
                      
# Assumption
* The transactions csv is in valid format
* User inputs are in valid format 
* Reversal transactions are only considered if they are valid to count under the input date range provided
* No exception handling has been programmed

# Building a jar
gradlew build jar

# Running the jar

### Run Main.kt from the IntelliJ IDE using the Play button

![Application Output](./images/execution.PNG?raw=true "Application Output")

### Run a Jar with a file (e.g. transactions.csv) as an argument
* java -jar metest-[version]-[snapshot].jar c:/temp/transactions.csv

![Application Output](./images/running_jar_with_param.PNG?raw=true "Application Output")
 
### User Input
* When you run the program either using IDE or by commind line you will be asked to enter AccountID, From Time and To Time which will be then used in the BalanceService to determin the balance at the time and number of transaction included

# Author
Krunal Shah



