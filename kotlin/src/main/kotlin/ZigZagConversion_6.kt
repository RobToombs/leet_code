fun main() {
    println("${convert("PAYPALISHIRING", 3)} = PAHNAPLSIIGYIR")
    println("${convert("PAYPALISHIRING", 4)} = PINALSIGYAHRPI")
    println("${convert("A", 1)} = A")
}

fun convert(s: String, numRows: Int): String {
    if(numRows == 1) {
        return s
    }

    val rows = mutableListOf<MutableList<Char>>()
    for(i in 0 until numRows) {
        rows.add(mutableListOf())
    }

    var up = -1
    var index = 0
    for(i in s.indices) {
        if(i % (numRows - 1) == 0) {
            up *= -1
        }

        val row = rows[index]
        row.add(s[i])

        index += up
    }

    var result = ""
    for (row in rows) {
        for(letter in row) {
            result += letter
        }
    }

    return result
}