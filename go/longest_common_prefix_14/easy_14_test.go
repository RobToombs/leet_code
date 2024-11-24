package longest_common_prefix_14

import "testing"

func Test_longestCommonPrefix(t *testing.T) {
	type args struct {
		strs []string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{name: "strs = ['flower','flow','flight']", args: args{strs: []string{"flower", "flow", "flight"}}, want: "fl"},
		{name: "strs = ['dog','racecar','car']", args: args{strs: []string{"dog", "racecar", "car"}}, want: ""},
		{name: "strs = ['cir','car']", args: args{strs: []string{"cir", "car"}}, want: "c"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := longestCommonPrefix(tt.args.strs); got != tt.want {
				t.Errorf("longestCommonPrefix() = %v, want %v", got, tt.want)
			}
		})
	}
}
