package lexicographically_smallest_2948

import (
	"reflect"
	"testing"
)

func Test_lexicographicallySmallestArray(t *testing.T) {
	type args struct {
		nums  []int
		limit int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"1", args{nums: []int{1, 5, 3, 9, 8}, limit: 2}, []int{1, 3, 5, 8, 9}},
		{"2", args{nums: []int{1, 7, 6, 18, 2, 1}, limit: 3}, []int{1, 6, 7, 18, 1, 2}},
		{"3", args{nums: []int{1, 7, 28, 19, 10}, limit: 3}, []int{1, 7, 28, 19, 10}},
		{"4", args{nums: []int{1, 60, 34, 84, 62, 56, 39, 76, 49, 38}, limit: 4}, []int{1, 56, 34, 84, 60, 62, 38, 76, 49, 39}},
		{"5", args{nums: []int{1, 81, 10, 79, 36, 2, 87, 12, 20, 77}, limit: 7}, []int{1, 77, 10, 79, 36, 2, 81, 12, 20, 87}},
		{"6", args{nums: []int{81, 79, 87, 77}, limit: 7}, []int{77, 79, 81, 87}},
		{"7", args{nums: []int{87, 77}, limit: 10}, []int{77, 87}},
		{"8", args{nums: []int{4, 34, 29, 73, 51, 11, 8, 53, 98, 47}, limit: 10}, []int{4, 29, 34, 73, 47, 8, 11, 51, 98, 53}},
		{"9", args{nums: []int{4, 52, 38, 59, 71, 27, 31, 83, 88, 10}, limit: 14}, []int{4, 27, 31, 38, 52, 59, 71, 83, 88, 10}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := lexicographicallySmallestArray(tt.args.nums, tt.args.limit); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("lexicographicallySmallestArray() = %v, want %v", got, tt.want)
			}
		})
	}
}
