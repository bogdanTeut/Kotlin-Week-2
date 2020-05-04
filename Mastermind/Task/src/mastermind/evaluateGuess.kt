package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightColor = "ABCDEF".sumBy {letter -> minOf(secret.count { it ==  letter}, guess.count { it ==  letter}) }

    val rightPosition = guess.zip(secret).count { it.first == it.second }

    return Evaluation(rightPosition, rightColor-rightPosition)

//    fun identifyRightPositionsAndRemoveThem(
//            guessCharsAsList: MutableList<Char>,
//            secretCharsAsList: MutableList<Char>): Int {
//
//        fun removeFoundRightPositions(rightPositionsIndexes: ArrayList<Int>,
//                                      guessCharsAsList: MutableList<Char>,
//                                      secretCharsAsList: MutableList<Char>
//        ) {
//            rightPositionsIndexes.reverse()
//
//            rightPositionsIndexes.forEach {
//                guessCharsAsList.removeAt(it)
//                secretCharsAsList.removeAt(it)
//            }
//        }
//
//        var rightPositions = 0
//        val rightPositionsIndexes = ArrayList<Int>()
//
//        for (index: Int in guessCharsAsList.indices) {
//            val guessedChar = guessCharsAsList[index]
//            if (guessedChar == secretCharsAsList[index]) {
//                rightPositions += 1
//                rightPositionsIndexes.add(index)
//            }
//        }
//
//        removeFoundRightPositions(rightPositionsIndexes, guessCharsAsList, secretCharsAsList)
//        return rightPositions
//    }
//
//    fun identifyRightColours(guessCharsAsList: MutableList<Char>,
//                             secretCharsAsList: MutableList<Char>): Int {
//        fun checkIfColourExistsInTheSecret(colourToBeChecked: Char, secretColoursAsList: MutableCollection<Char>): Int {
//            for (colour: Char in secretColoursAsList) {
//                if (colourToBeChecked == colour) {
//                    secretColoursAsList.remove(colourToBeChecked)
//                    return 1
//                }
//            }
//            return 0
//        }
//
//        var rightColours = 0
//
//        while (guessCharsAsList.isNotEmpty()) {
//            val guessedChar = guessCharsAsList.first()
//            rightColours += checkIfColourExistsInTheSecret(guessedChar, secretCharsAsList)
//            guessCharsAsList.remove(guessedChar)
//        }
//
//        return rightColours
//    }
//
//    val secretCharsAsList = secret.toMutableList()
//    val guessCharsAsList = guess.toMutableList()
//
//    val rightPosition = identifyRightPositionsAndRemoveThem(guessCharsAsList, secretCharsAsList)
//    val rightColours = identifyRightColours(guessCharsAsList,secretCharsAsList)
//
//    return Evaluation(rightPosition, rightColours)

//    val letters = "ABCDEF".toMutableList()
//
//    val rightPositions = secret.zip(guess).count { it.first == it.second }
//
//    val rightColours = letters.map { ch ->
//        Math.min(secret.count { it == ch }, guess.count { it == ch })
//    }.sum()
//
//    return Evaluation(rightPositions, rightColours - rightPositions)
}
