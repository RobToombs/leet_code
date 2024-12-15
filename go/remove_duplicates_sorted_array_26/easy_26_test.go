package remove_duplicates_sorted_array_26

import "testing"

func Test_removeDuplicates(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
		wantArray []int
	}{
		{name: "2, nums = [1,2,_]", args: args{nums: []int{1,1,2}}, want: 2, wantArray: []int{1,2}},
		{name: "5, nums = [0,1,2,3,4,_,_,_,_,_]", args: args{nums: []int{0,0,1,1,1,2,2,3,3,4}}, want: 5, wantArray: []int{0,1,2,3,4}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			input := tt.args.nums
			got := removeDuplicates(input)
			if got != tt.want {
				t.Errorf("removeDuplicates() = %v, want %v", got, tt.want)
			}

			for i := 0; i < len(tt.wantArray); i++ {
				if input[i] != tt.wantArray[i] {
					t.Errorf("nums = %v, wantArray %v", input, tt.wantArray)
					break
				}
			}
		})
	}
}
