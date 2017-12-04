class MergeSort {
    MergeSort () {

    }

    void run(){
        Integer[] unsortedArray = [4,3,2,6,7,9,1,0,5,8]
        // Sort left and right sub arrays
        def result = divideAndConquer(unsortedArray)
        println result
    }

    /**
     *
     * @param input
     * @return
     */
    Integer[] divideAndConquer(Integer[] input) {
        def inputLength = input.length
        Integer[] output = new Integer[inputLength]

        if (inputLength < 2) {
            return input
        } else {
            Integer[] leftSubArray = input[ inputLength-1 .. inputLength/2 ]
            Integer[] rightSubArray = input[ (inputLength/2)-1 .. 0 ]

            Integer[] sortedLeft = divideAndConquer(leftSubArray)
            Integer[] sortedRight = divideAndConquer(rightSubArray)

            int j = 0, k = 0
            int leftLength = sortedLeft.length
            int rightLength = rightSubArray.length

            for ( int i = 0; i < inputLength; i++) {
                if (j >= leftLength) {
                    while (k < rightLength) {
                        output[i] = sortedRight[k]
                        i++; k++
                    }
                } else if (k >= rightLength) {
                    while (j < leftLength) {
                        output[i] = sortedLeft[j]
                        i++; j++
                    }
                } else if (sortedLeft[j] < sortedRight[k]) {
                    output[i] = sortedLeft[j]
                    j++
                }else {
                    output[i] = sortedRight[k]
                    k++
                }
            }
            return output
        }
    }

    static void main(String[] args) {
        MergeSort mergeSort = new MergeSort()
        mergeSort.run()
    }
}
