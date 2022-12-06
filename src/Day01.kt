fun main() {
    fun part1(input: List<String>): Int {
        val elves = mutableListOf<Int>()
        var calorieCount: Int = 0
        input.forEach {
            if (it.isNullOrBlank()) {
                elves.add(calorieCount)
                calorieCount = 0
            } else {
                calorieCount += it.toInt()
            }
        }
        elves.add(calorieCount) // add last
        return elves.max()
    }

    fun part2(input: List<String>): Int {
        val elves = mutableListOf<Int>()
        var calorieCount: Int = 0
        input.forEach {
            if (it.isNullOrBlank()) {
                elves.add(calorieCount)
                calorieCount = 0
            } else {
                calorieCount += it.toInt()
            }
        }
        elves.add(calorieCount) // add last

        println("Sublist")
        println(elves.sortedDescending().subList(0, 3))
        println("Sublist")

        return elves.sortedDescending().take(3).sum()
    }

    val inputLines = readInputLines("input.01")

    println(part1(inputLines))
    println(part2(inputLines))
}
