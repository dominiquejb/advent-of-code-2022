fun main() {
    fun scorePart1(round: String): Int {
        return when (round) {
            "A X" -> 4 // Draw, Rock     = 3 + 1 = 4
            "A Y" -> 8 // Win,  Paper    = 6 + 2 = 8
            "A Z" -> 3 // Loss, Scissors = 0 + 3 = 3
            "B X" -> 1 // Loss, Rock     = 0 + 1 = 1
            "B Y" -> 5 // Draw, Paper    = 3 + 2 = 5
            "B Z" -> 9 // Win,  Scissors = 6 + 3 = 9
            "C X" -> 7 // Win,  Rock     = 6 + 1 = 7
            "C Y" -> 2 // Loss, Paper    = 0 + 2 = 2
            "C Z" -> 6 // Draw, Scissors = 3 + 3 = 6
            else -> 0
        }
    }

    fun scorePart2(round: String): Int {
        return when (round) {
            "A X" -> 3 // Loss=>Scissors = 0 + 3 = 3
            "A Y" -> 4 // Draw=>Rock     = 3 + 1 = 4
            "A Z" -> 8 // Win =>Paper    = 6 + 2 = 8
            "B X" -> 1 // Loss=>Rock     = 0 + 1 = 1
            "B Y" -> 5 // Draw=>Paper    = 3 + 2 = 5
            "B Z" -> 9 // Win =>Scissors = 6 + 3 = 9
            "C X" -> 2 // Loss=>Paper    = 0 + 2 = 2
            "C Y" -> 6 // Draw=>Scissors = 3 + 3 = 6
            "C Z" -> 7 // Win =>Rock     = 6 + 1 = 7
            else -> 0
        }
    }

    fun part1(input: List<String>): Int {
        var acc: Int = 0
        input.forEach { acc += scorePart1(it) }

        return acc
    }

    // logic to handle rock, paper, scissors rounds




    fun part2(input: List<String>): Int {
        var acc: Int = 0
        input.forEach { acc += scorePart2(it) }

        return acc
    }

    val inputLines = readInputLines("input.02")

    println(part1(inputLines))
    println(part2(inputLines))
}
