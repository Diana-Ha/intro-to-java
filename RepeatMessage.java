public class RepeatMessage {
    /*
    Method: repeat(stringToRepeat, numberOfIterations)

    This class repeats a message as many times as indicated. Number of iterations must be a whole, non-negative number,
    or else it will throw an exception.
    */
    public static void main(String[] args) {
        repeat("hello", 3);  //expected output "hellohellohello"
        repeat("this is fun", 1);  //expected output "this is fun"
        repeat("wow", 0);  //expected output ""
    }

    public static String repeat(String s, int n) {
        if (n==0) {
            System.out.println("");
            return "";
        } else if (n>0) {
            return s + repeat(s, n-1);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
