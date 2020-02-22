import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert

class MainSpek : Spek({
    describe("In the main") {
        it("it prints successfully") {
            Assert.assertEquals(true, true)
        }
    }
});