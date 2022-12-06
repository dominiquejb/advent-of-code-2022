fun main() {
    fun part1(input: String): Int {
        for (i in 0..input.length-5) {
            val packet = input.substring(i, i + 4)

            if (packet.chunked(1).toSet().size == 4) {
                return i+4
            }
        }

        throw Error("packet not found")
    }

    fun part2(input: String): Int {
        for (i in 0..input.length-15) {
            val packet = input.substring(i, i + 14)

            if (packet.chunked(1).toSet().size == 14) {
                return i+14
            }
        }

        throw Error("packet not found")
    }

    val inputString = readInput("input.06")

    println(part1(inputString))
    println(part2(inputString))
}
