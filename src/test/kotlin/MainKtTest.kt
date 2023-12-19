import junit.framework.TestCase.assertEquals
import org.junit.Test


class MainKtTest {

    @Test
    fun visaTestMinCommission() {
        val typeCard = "Visa"
        val amount = 1_000
        val monthlyTransfers = 0

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(35, result)
    }

    @Test
    fun visaTestLimit() {
        val typeCard = "Visa"
        val amount = 100_000
        val monthlyTransfers = 550_000

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun visaTestLimitAmount() {
        val typeCard = "Visa"
        val amount = 200_000
        val monthlyTransfers = 0

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun maestroTestLimit() {
        val typeCard = "Maestro"
        val amount = 100_000
        val monthlyTransfers = 550_000

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun maestroTestCommission() {
        val typeCard = "Maestro"
        val amount = 100_000
        val monthlyTransfers = 0

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(620, result)
    }

    @Test
    fun maestroTestNoCommission() {
        val typeCard = "Maestro"
        val amount = 50_000
        val monthlyTransfers = 0

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(0, result)
    }

    @Test
    fun maestroTestNoCommission1() {
        val typeCard = "Maestro"
        val amount = 500_000
        val monthlyTransfers = 10_000

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun vkPayTestLimit() {
        val typeCard = "VK Pay"
        val amount = 10_000
        val monthlyTransfers = 50_000

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun vkPayTestCommission() {
        val typeCard = "VK Pay"
        val amount = 1_000
        val monthlyTransfers = 5_000

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(0, result)
    }

    @Test
    fun vkPayTestLimit1() {
        val typeCard = "VK Pay"
        val amount = 100_000
        val monthlyTransfers = 0

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun cardTest() {
        val typeCard = "No card"
        val amount = 0
        val monthlyTransfers = 0

        val result = commissionCalculate(typeCard, monthlyTransfers, amount)

        assertEquals(-1, result)
    }


}