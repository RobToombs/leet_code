package maximum_average_pass_ratio_1792

import (
	"container/heap"
)

/*
There is a school that has classes of students and each class will be having a final exam. You are given a 2D
integer array classes, where classes[i] = [pass[i], total[i]]. You know beforehand that in the ith class,
there are total[i] total students, but only pass[i] number of students will pass the exam.

You are also given an integer extraStudents. There are another extraStudents brilliant students
that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of
the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the
total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes
divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10^-5
of the actual answer will be accepted.
 */

// https://yuminlee2.medium.com/golang-heap-data-structure-45760f9562dc
// https://www.digitalocean.com/community/tutorials/max-heap-java

func maxAverageRatio(classes [][]int, extraStudents int) float64 {
	h := &MaxHeap{}
	heap.Init(h)

	initializeMaxDifferenceHeap(classes, h)
	addStudentsToClasses(extraStudents, h)
	return sumPassingRates(classes, h)
}

// Create base max heap with nodes consisting of [difference, passing, total], with difference being the sort value
func initializeMaxDifferenceHeap(classes [][]int, h *MaxHeap) {
	for _, class := range classes {
		pass, total := class[0], class[1]
		// Difference between percentage pass rate with additional student + without additional student
		diff := float64(pass+1)/float64(total+1) - float64(pass)/float64(total)
		heap.Push(h, []float64{diff, float64(pass), float64(total)})
	}
}

// Iterate over the 'guaranteed to pass' students, adding the students to the classes where adding a single
// student would make the largest increase in pass rate
func addStudentsToClasses(extraStudents int, h *MaxHeap) {
	for extraStudents > 0 {
		top := heap.Pop(h).([]float64)
		pass, total := top[1]+1, top[2]+1
		// Calculate the new diff with the added student, and push it to the heap. This will cause the next 
		// largest difference to sort to the top for the next iteration
		diff := (pass+1)/(total+1) - pass/total
		heap.Push(h, []float64{diff, pass, total})
		extraStudents--
	}
}

// Sum all the pass rates for the final result
func sumPassingRates(classes [][]int, h *MaxHeap) float64 {
	var sum float64
	for h.Len() > 0 {
		top := heap.Pop(h).([]float64)
		sum += top[1] / top[2]
	}

	return sum / float64(len(classes))
}

type MaxHeap [][]float64

func (h MaxHeap) Len() int {
	return len(h)
}

func (h MaxHeap) Less(i, j int) bool {

	return h[i][0] > h[j][0]
}

func (h MaxHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.([]float64))
}

func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}