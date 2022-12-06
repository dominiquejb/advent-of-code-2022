fun main() {
    fun String.toIntRange(): IntRange {
        val (start, end) = this.split("-").map { it.toInt() }
        return IntRange(start, end)
    }

    fun IntRange.contains(other: IntRange): Boolean {
        return this.first <= other.first && this.last >= other.last
    }

    fun IntRange.overlaps(other: IntRange): Boolean {
        return this.last >= other.first && this.first <= other.last
    }

    fun hasContainingOverlap(line: String): Boolean {
        val (first, second) = line.split(",").map { it.toIntRange() }

        return first.contains(second) || second.contains(first)
    }

    fun hasAnyOverlap(line: String): Boolean {
        val (first, second) = line.split(",").map { it.toIntRange() }

        return first.overlaps(second)
    }

    fun part1(input: List<String>): Int {
        return input.filter { hasContainingOverlap(it) }.size
    }

    fun part2(input: List<String>): Int {
        return input.filter { hasAnyOverlap(it) }.size
    }

    val inputLines = readInputLines("input.04")

    println(part1(inputLines))
    println(part2(inputLines))
}
