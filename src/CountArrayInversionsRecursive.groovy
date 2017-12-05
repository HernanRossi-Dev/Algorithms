/**
 * Class to count the number of inversions in an integer array with only
 * unique elements.
 */

class CountArrayInversionsRecursive {

    CountArrayInversionsRecursive(newArray) {
        ArrayAndCount newArrayAndCount = new ArrayAndCount(newArray, 0)
        def resultCountAndSorted = sortAndCountInv(newArrayAndCount)
        println "There are: " + resultCountAndSorted.getCount() + " inversion in the array."
        println "The sorted array is: " + resultCountAndSorted.getArray()
    }

    /**
     * recursive method to count the number of inversion in an array and return the
     * count and the sorted input array. Assumptions n is a power of 2
     * @param arrayNCount
     * @return
     */
    ArrayAndCount sortAndCountInv(ArrayAndCount arrayNCount) {
        Integer[] array = arrayNCount.getArray()
        def arrayLength = array.length

        if(arrayLength < 2) {  // Base Case
            return arrayNCount
        } else {
            Integer[] leftSubArray = array[0 .. arrayLength/2 -1]
            Integer[] rightSubArray = array[(arrayLength/2) .. arrayLength-1]
            ArrayAndCount leftSortedAndInv = sortAndCountInv(new ArrayAndCount(leftSubArray, 0))
            ArrayAndCount righSortedAndInv = sortAndCountInv(new ArrayAndCount(rightSubArray, 0))
            ArrayAndCount mergedAndInvCount = mergeAndCountSplitInversions(leftSortedAndInv, righSortedAndInv)
            return mergedAndInvCount
        }
    }

    ArrayAndCount mergeAndCountSplitInversions(ArrayAndCount leftArrayAndCount, ArrayAndCount rightArrayAndCount) {
        def numSplitInversions = leftArrayAndCount.getCount() + rightArrayAndCount.getCount()
        Integer[] leftArray = leftArrayAndCount.getArray()
        Integer[] righArray = rightArrayAndCount.getArray()
        int l = 0
        int r = 0
        int resultLength = leftArray.length + righArray.length
        Integer[] mergedResult = new Integer[resultLength]
        for(int i = 0; i < resultLength; i++) {
            if( l >= leftArray.length ) {
                mergedResult[i] = righArray[r]
                r++
            } else if (r >= righArray.length) {
                mergedResult[i] = leftArray[l]
                l++
            } else if(leftArray[l] < righArray[r]) {
                mergedResult[i] = leftArray[l]
                l++
            } else {
                println " inversion count " + leftArray[l]  + " " + righArray[r]
                mergedResult[i] = righArray[r]
                r++
                numSplitInversions = numSplitInversions + leftArray.length - l
            }
        }
        println "array is: " + mergedResult
        return new ArrayAndCount(mergedResult, numSplitInversions)
    }

    static void main(String[] args) {
        Integer[] inputArray = [6, 5, 4, 3, 2, 1]
        CountArrayInversionsRecursive countArrayInversionsRecursive = new CountArrayInversionsRecursive(inputArray)
    }
}

