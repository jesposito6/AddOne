import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jesposito6
 */
public class AddOne {
    /**
     * @param args the command line arguments
     */

    static List<Long> list;

    public static void main(String[] args) {
        //start at right of array
        //add one
        //if that value >= 10, make carry over = 1
        //decrement index
        //continue until index = 0
        //if youre at index 0 and that val + 1 >= 10 then you need to create new array

        list = new ArrayList<>();

        //Worst Case Scenario:
        System.out.println("WORST CASE: ALL 9S");
        for(int i = 1; i <= 1000; i *= 10){
            int[] arr = new int[i];
            //Array all 9s
            Arrays.fill(arr, 9);
            test(arr, i);
        }

        //Best Case Scenario:
        System.out.println("BEST CASE: ALL 0S");
        for(int i = 1; i <= 1000; i *= 10){
            //Array all 0s
            int[] arr = new int[i];
            test(arr, i);
        }
    }

    public static int[] addOne(int[] array){
        long start = System.nanoTime();
        //Work back to front since adding starts from least significant digit
        for(int i = array.length - 1; i >=0; i--){
            //If we are at the beginning AND that number is 9 we can build a new array of size one greater
            //It is not enough just to say if we are at i = 0 since by that logic we would create a bigger array
            //whenever the size is of 1, when we shouldn't
            if(i == 0 && array[0] == 9){
                int[] returnArray = new int[array.length + 1];
                returnArray[0] = 1;
                long end = System.nanoTime();
                list.add(end - start);
                return returnArray;
            }

            int num = array[i];

            //not a 9, we can simply add and return
            if(num != 9){
                array[i] = num + 1;
                long end = System.nanoTime();
                list.add(end - start);
                return array;
            //9, add one (goes to 0) and continue loop until we hit not a 9 or the beginning of the array
            }else{
                array[i] = 0;
            }
        }

        long end = System.nanoTime();
        list.add(end - start);
        return array;
    }

    //test function for printing results
    public static void test(int[] arr, int n){
        int[] result = addOne(arr);

        System.out.println("Test " + list.size() + ":\nSize Before: " + arr.length +
                "\nSize After: " + result.length + "\nTime (ns): " + list.get(list.size() - 1) + "\nResult: "
                + Arrays.toString(result) + "\n");
    }
}
