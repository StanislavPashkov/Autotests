import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

//fun main() {
//    println(commissionCalculate(cardType = "Visa",  amount = 26000))
//
//}

fun commissionCalculate(cardType: String , monthlyTransfers: Int = 0, amount: Int) =
    when (cardType) {
        "Visa", "Mir" -> if (amount <= 150_000 && amount + monthlyTransfers <= 600_000)
            max(35, (amount * 0.0075).toInt()) else ERROR_LIMIT


        "Maestro", "MasterCard" -> if (amount <= 150_000 && amount + monthlyTransfers <= 600_000)
            if (amount + monthlyTransfers > 75000) (0.006 * amount + 20).toInt() else 0
        else ERROR_LIMIT


        "VK Pay" -> if (amount <= 15_000 && amount + monthlyTransfers <= 40_000) 0 else ERROR_LIMIT
        else -> ERROR_TYPE

    }
