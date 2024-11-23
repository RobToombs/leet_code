package roman_to_integer_13

var romanToIntMap = map[rune]int{
	'I': 1,
	'V': 5,
	'X': 10,
	'L': 50,
	'C': 100,
	'D': 500,
	'M': 1000,
}

func romanToInt(roman string) int {
	result := 0

	var current = 0
	var previous = -1
	for _, letter := range roman {
		current = romanToIntMap[letter]
		result += current
		if previous != -1 && previous < current {
			result -= previous * 2
		}
		previous = current
	}

	return result
}
