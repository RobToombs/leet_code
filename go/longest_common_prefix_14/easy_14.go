package longest_common_prefix_14

import "bytes"

func longestCommonPrefix(strs []string) string {
	var result bytes.Buffer
	var firstWord = strs[0]
	for letterIndex := 0; letterIndex < len(firstWord); letterIndex++ {
		var letter = firstWord[letterIndex]
		var sameLetter = true
		for wordIndex := 1; wordIndex < len(strs); wordIndex++ {
			word := strs[wordIndex]
			if letterIndex >= len(word) {
				return result.String()
			} else if word[letterIndex] != letter {
				sameLetter = false
				break
			}
		}

		if !sameLetter {
			return result.String()
		}

		result.WriteByte(letter)
	}
	return result.String()
}
