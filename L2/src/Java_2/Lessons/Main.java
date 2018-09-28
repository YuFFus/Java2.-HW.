/**
 * Java 2. Lesson 2. Homework;
 * @author Fedak Yuriy;
 * @version 28/09/2018;
 * @link
 */

package Java_2.Lessons;

import org.apache.commons.lang3.math.NumberUtils;



public class Main {
    static String[][] myOkArray, myNg1Array, myNg2Array;

    public Main(){
        myOkArray = new String [4][];
        myOkArray[0] = new String[]{"12", "1", "16", "8"};
        myOkArray[1] = new String[]{"2", "8", "14", "6"};
        myOkArray[2] = new String[]{"9", "4", "13", "19"};
        myOkArray[3] = new String[]{"17", "8", "7", "21"};

        myNg1Array = new String [4][];
        myNg1Array[0] = new String[]{"12", "1", "16", "8"};
        myNg1Array[1] = new String[]{"2", "8", "14", "6", "24"};
        myNg1Array[2] = new String[]{"9", "4", "13", "19"};
        myNg1Array[3] = new String[]{"17", "8", "7", "21"};

        myNg2Array = new String [4][];
        myNg2Array[0] = new String[]{"4", "1", "16", "8"};
        myNg2Array[1] = new String[]{"2", "8", "14", "6"};
        myNg2Array[2] = new String[]{"9", "4", "A", "19"};
        myNg2Array[3] = new String[]{"17", "8", "7", "21"};
    }

    public static int myArraySum(String[][] myArray) throws MySizeArrayException, MyArrayDataException {
        int mySymbolInt = 0;
        for (int i = 0; i < myArray.length; i++){
            if (myArray.length != 4) throw new MySizeArrayException();
            for (int k = 0; k < myArray[i].length; k++){
                if (myArray[i].length != 4) throw new MySizeArrayException();
                if (!NumberUtils.isCreatable(myArray[i][k])) throw new MyArrayDataException(i, k);
                mySymbolInt = (mySymbolInt + Integer.valueOf(myArray[i][k]));
            }
        }
        return mySymbolInt;
    }

    public static void main(String[] args) {
	    new Main();
        try {
            Main.myArraySum(myOkArray);
            System.out.println(Main.myArraySum(myOkArray));
        }
        catch (MyArrayDataException exc) {
        }
        catch (MySizeArrayException exc) {
        }
        try {
            Main.myArraySum(myNg1Array);
        }
        catch (MyArrayDataException exc) {
        }
        catch (MySizeArrayException exc) {
        }
        try {
            Main.myArraySum(myNg2Array);
        }
        catch (MyArrayDataException exc) {
        }
        catch (MySizeArrayException exc) {
        }
    }
}

