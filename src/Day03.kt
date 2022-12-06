fun main() {

    fun Char.itemPriority(): Int {
        return when (val c = this.code) {
            in 97..122 -> c - 96
            in 65..90 -> c - 38
            else -> throw Error("Invalid item")
        }
    }

    fun getCommonItem(first: String, second: String): Char {
        for (c in first.toCharArray()) {
            if (second.toCharArray().contains(c)) {
                return c
            }
        }
        throw Error("No common item found")
    }

    fun getCommonItem(first: String, second: String, third: String): Char {
        for (c in first.toCharArray()) {
            if (second.toCharArray().contains(c) && third.toCharArray().contains(c)) {
                return c
            }
        }
        throw Error("No common item found")
    }

    fun part1(input: List<String>): Int {
        var prioritiesSum = 0

        input.forEach { rucksack ->
            val pocketSize = rucksack.length/2
            val first = rucksack.take(pocketSize)
            val second = rucksack.takeLast(pocketSize)

            val item = getCommonItem(first, second)

            prioritiesSum += item.itemPriority()
        }

        return prioritiesSum
    }

    fun part2(input: List<String>): Int {
        var prioritiesSum = 0

        val it = input.iterator()
        while (it.hasNext()) {
            val first = it.next()
            val second = it.next()
            val third = it.next()

            val item = getCommonItem(first, second, third)

            prioritiesSum += item.itemPriority()
        }

        return prioritiesSum
    }

    val inputLines = readInputLines("input.03")

    println(part1(inputLines))
    println(part2(inputLines))
}
