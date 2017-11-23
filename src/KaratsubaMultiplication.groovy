/**
 * A simple class to multiply 2 n length numbers x and y using Karatsuba Multiplication
 * Assumptions: x and y are both lengths 2^k, 2^j for any k, j >= 0
 */
class KaratsubaMultiplication {


    KaratsubaMultiplication(){

    }

    void requestMultiplicationParameters(){
        println "Welcome to the Karatsuba Multiplication program"
        println "This program recursively computes two values x and y, both must have a length power of 2 and same length"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        println "Input value x: "
        def x = br.readLine().toInteger()
        println "Input value y: "
        def y = br.readLine().toInteger()
        int nx = String.valueOf(x).length()
        int ny = String.valueOf(y).length()
        if( (nx != ny)  || (nx % 2 != 0) ) {
            println "Program error, invalid input values."
            System.exit(0)
        }
        def multiplied = recursiveMult(x, y)
        println "The result is: " + multiplied
    }

    int recursiveMult(x, y) {
        def n = String.valueOf(x).length()
        if(n == 1){
            return x * y
        } else {
            def a = getFirstHalfSlicedInt(x)
            println a
            def b = getLastHalfSlicedInt(x)
            println b
            def c = getFirstHalfSlicedInt(y)
            println c
            def d = getLastHalfSlicedInt(y)
            println d
            def p = a + b
            def q = c + d
            def ac = recursiveMult(a, c)
            def bd = recursiveMult(b, d)
            def abdc = p * q - ac - bd
            def result = Math.pow(10, n)* ac + Math.pow(10, n/2) * abdc + bd
            return result
        }
    }

    static int getFirstHalfSlicedInt(int value){
        int n = String.valueOf(value).length()
        return Integer.parseInt( String.valueOf(value).substring( 0 , (n/2).intValue() ))
    }

    static int getLastHalfSlicedInt(value) {
        int n = String.valueOf(value).length()
        return  Integer.parseInt( String.valueOf(value).substring( (n/2).intValue()) -1 )
    }

    static void main(String[] args) {
        KaratsubaMultiplication karatsubaMultiplication = new KaratsubaMultiplication()
        karatsubaMultiplication.requestMultiplicationParameters()
    }
}
