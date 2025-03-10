package number_of_alternating_groups_3208

import "testing"

func Test_numberOfAlternatingGroups(t *testing.T) {
	type args struct {
		colors []int
		k      int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"1", args{[]int{0, 1, 0, 1, 0}, 3}, 3},
		{"2", args{[]int{0, 1, 0, 0, 1, 0, 1}, 6}, 2},
		{"3", args{[]int{1, 1, 0, 1}, 4}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numberOfAlternatingGroups(tt.args.colors, tt.args.k); got != tt.want {
				t.Errorf("numberOfAlternatingGroups() = %v, want %v", got, tt.want)
			}
		})
	}
}
