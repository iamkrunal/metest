package util

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert
import org.junit.jupiter.api.assertThrows
import java.time.format.DateTimeParseException


class DateUtilsSpek : Spek({
    describe("in toDate") {
        context("when given a valid string date and valid string format"){
            val date = "20/10/2018 12:47:55"
            val format = "dd/MM/yyyy HH:mm:ss"
            val actualDate = toDate(date, format)
            it("returns the correct date of month"){
                Assert.assertEquals(20, actualDate.dayOfMonth)
            }
            it("returns the correct month of the year"){
                Assert.assertEquals(10, actualDate.monthValue)
            }
            it("returns the correct date of month"){
                Assert.assertEquals(2018, actualDate.year)
            }
            it("returns the correct hour of the day"){
                Assert.assertEquals(12, actualDate.hour)
            }
            it("returns the correct minute of the hour"){
                Assert.assertEquals(47, actualDate.minute)
            }
            it("returns the correct second of the minute"){
                Assert.assertEquals(55, actualDate.second)
            }
        }

        context("when given a valid string date and no format provided"){
            val date = "20/10/2018 13:47:55"
            val actualDate = toDate(date)
            it("returns the correct date of month"){
                Assert.assertEquals(actualDate.dayOfMonth, 20)
            }
            it("returns the correct month of the year"){
                Assert.assertEquals(actualDate.monthValue,10)
            }
            it("returns the correct date of month"){
                Assert.assertEquals(actualDate.year, 2018)
            }
            it("returns the correct hour of the day"){
                Assert.assertEquals(13, actualDate.hour)
            }
            it("returns the correct minute of the hour"){
                Assert.assertEquals(47, actualDate.minute)
            }
            it("returns the correct second of the minute"){
                Assert.assertEquals(55, actualDate.second)
            }
        }

        context("when given an invalid string date"){

            it("throws DateTimeParseException"){
                assertThrows<DateTimeParseException> {
                    val date = "20/13/2018 13:47:55"
                    toDate(date)
                }
            }

            it("throws DateTimeParseException"){
                assertThrows<DateTimeParseException> {
                    val date = "20/12/2018 13:65:55"
                    toDate(date)
                }
            }
        }
    }
})