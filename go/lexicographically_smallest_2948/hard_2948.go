package lexicographically_smallest_2948

import "sort"

func lexicographicallySmallestArray(nums []int, limit int) []int {
	// Create a sorted list of elements by value while maintaining index
	items := make([]Item, len(nums))
	for index, value := range nums {
		items[index] = Item{Value: value, Index: index}
	}
	sort.Slice(items, func(i, j int) bool {
		return items[i].Value < items[j].Value
	})

	// Create groupings of values where all values in the group are within the limit
	part := []Item{items[0]}
	parts := [][]Item{}
	for i := 1; i < len(items); i++ {
		if items[i].Value-items[i-1].Value <= limit {
			part = append(part, items[i])
		} else {
			parts = append(parts, part)
			part = []Item{items[i]}
		}
	}
	parts = append(parts, part)

	// Initialize a result of the same input nums length with 'empty' values
	result := make([]int, len(nums))

	// Iterate over the groupings, creating two lists sorted by index and value
	for _, part := range parts {
		indexes := Map(part, Item.GetIndex)
		sort.Slice(indexes, func(i, j int) bool {
			return indexes[i] < indexes[j]
		})
		values := Map(part, Item.GetValue)
		sort.Slice(values, func(i, j int) bool {
			return values[i] < values[j]
		})

		// Iterate over the ordered indexes assigning the associated ordered value to the result index
		for index, _ := range indexes {
			result[indexes[index]] = values[index]
		}
	}

	return result
}

type Item struct {
	Value int
	Index int
}

func (i Item) GetValue() int {
	return i.Value
}

func (i Item) GetIndex() int {
	return i.Index
}

func Map(vs []Item, f func(Item) int) []int {
	vsm := make([]int, len(vs))
	for i, v := range vs {
		vsm[i] = f(v)
	}
	return vsm
}
