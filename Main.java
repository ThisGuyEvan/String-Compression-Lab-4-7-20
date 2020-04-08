import java.util.Arrays;
import java.util.Scanner;



class Main {
  public static void main(String[] args) {
    //Scanner to test conditions.
    Scanner console = new Scanner(System.in);
    System.out.print("\nEnter your array with no space.\n\tEx: \"aaabbbdddee\" \t: ");
    String input = console.next();

    char[] arr = input.toCharArray();

    System.out.println("Your array: " + Arrays.toString(arr));
    System.out.println("\nAfter string compression: " + Arrays.toString(compress(arr)));
  }


  public static char[] compress(char[] arr){
    int count = 0;
    
    //Insertion sort
    for (int i = 1; i < arr.length; i++){
      char temp = arr[i];
      count = i-1;
      
      //Finds smallest and goes down the chain
      while(count >= 0 && arr[count] > temp){
        arr[count+1] = arr[count];
        count--;
      }
      arr[count+1] = temp;
    }

    System.out.println("\n*Insertion Sorted: " + Arrays.toString(arr));
   // System.out.println("Current letter: " + Character.toString(110)); //<--- Char to ASCII Val (Cool stuff)

    count = 1;//Always begins with at least 1.
    String newArr = "";

    //Counting and adding char to a string.
    for (int j = 0; j < arr.length-1; j++){
      //counts
      if (arr[j] == arr[j+1]){
        count++;
      }
      //Next letter + count
      else{
        newArr += String.valueOf(arr[j]) + count;
        count = 1;
      }
    }

    //Since the last one does not get added because there is no other following.
    newArr += String.valueOf(arr[arr.length-1]) + count; //Add
    
    char[] compressedArray = newArr.toCharArray(); //Compressed arr.
    
    return compressedArray;
  }
}