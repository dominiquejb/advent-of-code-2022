fun main() {

    fun unpackLetter(boxedLetter: String): String {
        return boxedLetter.trim().removePrefix("[").removeSuffix("]")
    }

    fun part1(input: String): String {
        val (stacksSection, movesSection) = input.split("\n\n")
        
        // Part 1 - Parse stacks
        val stacksLines = stacksSection.split("\n").dropLast(1)
        
        val cratesRows = stacksLines.map { line ->
            line.chunked(4).map { box -> unpackLetter(box) }
        }
        // Turn rows into vertical stacks 
        val crateStacks = List(cratesRows.first().size) { mutableListOf<String>() }
        cratesRows.forEach { row ->
            row.forEachIndexed { i, crate ->
                if (crate.isNotBlank()) {
                    crateStacks[i].add(crate)
                }
            } 
        }
        
        // Part 2 - Parse and execute moves
        val moveLines = movesSection.split("\n")
        moveLines.forEach { moveLine -> 
            val moveSegments = moveLine.split(" ")
            val moveAmount = moveSegments[1].trim().toInt()
            val moveFromIdx = moveSegments[3].trim().toInt() - 1
            val moveToIdx = moveSegments[5].trim().toInt() - 1
            
            println("Moving $moveAmount crates from idx $moveFromIdx to idx $moveToIdx")
            
            val selectedCrates = crateStacks[moveFromIdx].take(moveAmount)
            selectedCrates.forEach { crate ->
                crateStacks[moveToIdx].add(0, crate)
                crateStacks[moveFromIdx].remove(crate)
            }
        }
        
        // Part 3 - Take first letters of each stack
        val letters = crateStacks.mapNotNull { stack ->
            stack.firstOrNull()
        }.joinToString("")
        
        return letters
    }

    fun part2(input: String): String {
        val (stacksSection, movesSection) = input.split("\n\n")

        // Part 1 - Parse stacks
        val stacksLines = stacksSection.split("\n").dropLast(1)

        val cratesRows = stacksLines.map { line ->
            line.chunked(4).map { box -> unpackLetter(box) }
        }
        // Turn rows into vertical stacks 
        val crateStacks = List(cratesRows.first().size) { mutableListOf<String>() }
        cratesRows.forEach { row ->
            row.forEachIndexed { i, crate ->
                if (crate.isNotBlank()) {
                    crateStacks[i].add(crate)
                }
            }
        }

        println(crateStacks)

        // Part 2 - Parse and execute moves
        val moveLines = movesSection.split("\n")
        moveLines.forEach { moveLine ->
            val moveSegments = moveLine.split(" ")
            val moveAmount = moveSegments[1].trim().toInt()
            val moveFromIdx = moveSegments[3].trim().toInt() - 1
            val moveToIdx = moveSegments[5].trim().toInt() - 1

            // println("Moving $moveAmount crates from idx $moveFromIdx to idx $moveToIdx")

            val selectedCrates = crateStacks[moveFromIdx].take(moveAmount)
            crateStacks[moveToIdx].addAll(0, selectedCrates)
            selectedCrates.forEach { _ ->
                crateStacks[moveFromIdx].removeFirst()
            }
        }

        // println(crateStacks)

        // Part 3 - Take first letters of each stack
        val letters = crateStacks.mapNotNull { stack ->
            stack.firstOrNull()
        }.joinToString("")

        return letters

        return "a"
    }

    val inputString = readInput("input.05")

    println(part1(inputString))
    println(part2(inputString))
}
