/**
 * Class to count the number of inversions in an integer array with only
 * unique elements.
 */

class CountArrayInversionsRecursive {

    CountArrayInversionsRecursive(newArray) {
        ArrayAndCount newArrayAndCount = new ArrayAndCount(newArray, 0)
        def resultCountAndSorted = sortAndCountInv(newArrayAndCount)
    }

    /**
     * recursive method to count the number of inversion in an array and return the
     * count and the sorted input array
     * @param arrayNCount
     * @return
     */
    ArrayAndCount sortAndCountInv(ArrayAndCount arrayNCount) {
        Integer[] array = arrayNCount.getArray()
        Integer count = arrayNCount.getCount()
        def arrayLength = array.length

        if(arrayLength == 0 || arrayLength == 1) {  // Base Case
            return arrayNCount
        } else {
            Integer[] leftSubArray = array[arrayLength-1 .. arrayLength/2]
            Integer[] rightSubArray = array[(arrayLength/2)-1 .. 0]
            ArrayAndCount leftResult = sortAndCountInv()

        }


    }



    static main(String[] args) {
        Integer[] inputArray = [2, 4, 1, 5, 6, 7, 2, 8, 0, 9]
        CountArrayInversionsRecursive(inputArray)

    }
}

