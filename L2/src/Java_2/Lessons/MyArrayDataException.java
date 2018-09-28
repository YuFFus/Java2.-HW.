package Java_2.Lessons;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int k) {
        System.out.println("Array cell with coordinates: "+ i + " - " + k + " is not a number. Please, check data array.");
    }
}
