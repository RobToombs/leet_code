package valid_parenthesis_20

var closeToOpenMap = map[uint8]uint8{
	'}': '{',
	']': '[',
	')': '(',
}

func isValid(s string) bool {
	// Input is empty
	if len(s) == 0 {
		return true
	}

	// Input only has an open or closing bracket OR contains an un-even pairing of brackets
	if len(s) == 1 || len(s)%2 != 0 {
		return false
	}

	// Initialize our "stack", push the first value and set the index. Our "stack" index will
	// always represent the index of the most recently seen parenthesis grouping opening bracket.
	// Since the "stack" only keeps track of valid pairings, and not every symbol, we only need
	// array space for at MOST 50% of the input string length.
	var stack = make([]uint8, len(s)/2)
	var stackIndex = 0
	stack[stackIndex] = s[0]

	// Iterate over the input string starting at index 1
	for i := 1; i < len(s); i++ {
		var symbol = s[i]

		// We've hit a "close" symbol...
		if openSymbol, ok := closeToOpenMap[symbol]; ok {
			// We've seen more "close" symbols than open symbols, fail out
			if stackIndex == -1 {
				return false
				// The close symbol we're at doesn't match the corresponding open symbol, fail out
			} else if stack[stackIndex] != openSymbol {
				return false
				// The close symbol we're at has a corresponding open symbol, "remove" this grouping from the stack
			} else {
				stackIndex--
			}
			// We're sitting on an "open" symbol...
		} else {
			// "Add" this open symbol to the "stack" to later check for an associated close symbol
			stackIndex++

			// Because the stack only keeps track of valid pairings, we know that if the stack index
			// ever exceeds the length of our stack array that we'll have more open brackets than
			// possible for closing brackets per the initial length of the input string (ex. "(({})", or "((")
			if stackIndex >= len(stack) {
				return false
			}

			stack[stackIndex] = symbol
		}
	}

	// We've iterated over the whole input string, on successful marking off of the final grouping our
	// index will always be -1 since the stackIndex represents the most recently visited opening parenthesis
	return stackIndex == -1
}
