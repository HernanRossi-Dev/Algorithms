class ArrayAndCount {
    private Integer count
    private Integer[] array

    ArrayAndCount() {

    }
    ArrayAndCount(newArray, newCount) {
        count = newCount
        array = newArray
    }

    void setCount(newCount) {
        count = newCount
    }

    void setArray(newArray) {
        array = newArray
    }

    Integer getCount(){
        return count
    }

    Integer[] getArray() {
        return array
    }
}
