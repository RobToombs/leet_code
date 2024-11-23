package roman_to_integer_13

import "testing"

func Test_romanToInt(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "I", args: args{s: "I"}, want: 1},
		{name: "V", args: args{s: "V"}, want: 5},
		{name: "X", args: args{s: "X"}, want: 10},
		{name: "L", args: args{s: "L"}, want: 50},
		{name: "C", args: args{s: "C"}, want: 100},
		{name: "D", args: args{s: "D"}, want: 500},
		{name: "M", args: args{s: "M"}, want: 1000},
		{name: "III", args: args{s: "III"}, want: 3},
		{name: "LVIII", args: args{s: "LVIII"}, want: 58},
		{name: "MCMXCIV", args: args{s: "MCMXCIV"}, want: 1994},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := romanToInt(tt.args.s); got != tt.want {
				t.Errorf("romanToInt() = %v, want %v", got, tt.want)
			}
		})
	}
}
