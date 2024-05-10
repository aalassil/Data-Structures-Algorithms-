import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("please set the threshold between 100 and 1000000");
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        FileManager fm = new FileManager("src/testFile");
        LinkyListy l = fm.FileReader(SetSIDCThreshold(sc.nextInt()));
        // creating hashMap containing all keys in linkedList
        HashyTably h = new HashyTably();
        h.addAll(l);
        boolean controler = true; // controlls if i want to exit the while loop
        while (controler) {
            menu();
            switch (sc.nextInt()) {
                case 0:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    controler = false;
                    System.out.println("system turned off");
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 1:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("generated student id is: " + Generate());
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    allkeys(h);
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("enter new unique key");
                    int id = sc.nextInt();
                    System.out.println("enter info:");
                    String info = scString.nextLine();
                    add(h, id, info);
                    System.out.println("student with id " + id + " info: " + info + " has been added");
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("enter key");
                    remove(h, sc.nextInt());
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("enter a key");
                    int x = sc.nextInt();
                    System.out.println("INFO: ");
                    Node n = getValues(h, x);
                    if (n == null) {
                        System.out.println("Key used does not exit or has been removed");
                    }
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("enter a valid key");
                    Node m = nextKey(h, sc.nextInt());
                    if (m == null) {
                        System.out.println("key is invalid or the next index is empty");
                    }
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("enter a valid key");
                    Node o = prevKey(h, sc.nextInt());
                    if (o == null) {
                        System.out.println("key is invalid or the prev index is empty/out of bound");
                    }
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 8:
                    System.out.println();
                    System.out.println("*********************************************************************");
                    System.out.println("enter key1");
                    int key1 = sc.nextInt();
                    System.out.println("enter key2");
                    int key2 = sc.nextInt();
                    rangeKey(h, key1, key2);
                    System.out.println("*********************************************************************");
                    System.out.println();
                    break;
                case 9:
                    System.out.println("index --> " + h.getIndex(sc.nextInt()));
            }
        }

    }

    public static void menu() {
        System.out.println();
        System.out.println(
                "************************************************************************************************");
        System.out.println("1. Generate id");
        System.out.println("2. allKeys sorted using Radix sort or Insertion sort");
        System.out.println("3.add Node --> type a key and student info");
        System.out
                .println("4.remove node --> type a key --> if the key is valid flag/delete the Node if not do nothing");
        System.out.println("5.get Values --> provide key");
        System.out.println("6.next key --> if exists i will give you the key in the next index");
        System.out.println("7.prev key --> if exists i will give you the key in the prev index");
        System.out.println("8.range --> give 2 keys");
        System.out.println("0.Exit");
        System.out.println(
                "************************************************************************************************");
        System.out.println();
    }

    /*
     * this function serves as the controller fior the DS used
     */
    public static int SetSIDCThreshold(int size) {
        return size;
    }

    /*
     * Function Generates random ID for new students --> make sure the ID is unique
     * maybe use dictionary
     * the complexity here shou;e be O(1) if i use hash tables to store the IDs and
     * O(n) otherwise
     */
    public static long Generate() {
        int min = 10000000;
        int max = 99999999;
        int randomNum = (int) (Math.random() * (max - min + 1) + min);
        return randomNum;
    }

    /*
     * get all the keys --> sort them --> return an array of their size
     */
    public static int[] allkeys(HashyTably h) {
        int[] array = h.keys();
        if (array.length < 1000) {
            insertionSort(array);
            int counter = 0;
            for (int i = 0; i < array.length; i++) {
                if (counter == 4) {
                    System.out.println();
                    counter = 0;
                }
                System.out.print(" Insrtion-> " + array[i]);
                counter++;
            }
        } else {
            radixSort(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(" RadSrtd-> " + array[i]);
            }
        }
        return array;
    }

    // add an entry to the given DS
    public static void add(HashyTably h, int key, String value) {
        Node n = new Node();
        n.studentId = key;
        n.additonalInfo = value;
        h.addNode(n);
    }

    public static void remove(HashyTably h, int key) {
        // h.goTo(h.firstHashFunction(key)).studentId directs to the array of the
        // hashmap
        if (h.goTo(h.firstHashFunction(key)) == null) {
            System.out.println("key does not exits");
        } else if (key == h.goTo(h.firstHashFunction(key)).studentId) {
            h.goTo(h.firstHashFunction(key)).setStudentId(-key);
        } else if (h.goTo(h.firstHashFunction(key)).studentId < 0) {
            System.out.println("this key is already deleted or does not exits");
        } else {
            int index = h.firstHashFunction(key);
            int counter = h.secondHashFunction(key);
            int laps = 0;
            while (h.goTo(index).studentId != key) {
                if (laps == h.studentArray.length - 1) {
                    System.out.println("key does not exist");
                    return;
                }
                index = index + counter;

                if (index >= h.studentArray.length) {
                    index = index - h.studentArray.length - 1;
                }
                if (h.goTo(h.firstHashFunction(key)) != null && h.goTo(h.firstHashFunction(key)).studentId > 0
                        && key == h.goTo(index).studentId) {
                    h.goTo(index).setStudentId(-key);
                }
                laps++;
            }
        }
    }

    public static Node getValues(HashyTably h, int key) {
        Node temp = h.getNode(key);
        System.out.println();
        if (temp != null) {
            System.out.println(temp.toString());
            return temp;
        } else {
            return null;
        }
    }

    public static Node nextKey(HashyTably h, int key) {
        int temp = h.getIndex(key);
        if (temp + 1 >= 0 && temp + 1 < h.studentArray.length - 2) {
            Node tempp = h.goTo(temp + 1);
            if (tempp == null || tempp.studentId < 0) {
                return null;
            }

            System.out.println();
            System.out.println("next key is: " + tempp.toString());
            return tempp;
        } else {
            System.out.println("next key does not exist the index is empty");
            return null;
        }
    }

    public static Node prevKey(HashyTably h, int key) {
        int temp = h.getIndex(key);
        if (temp - 1 >= 0 && temp - 1 < h.studentArray.length - 1) {

            Node tempp = h.goTo(temp - 1);
            if (tempp == null || tempp.studentId < 0) {
                System.out.println("prev index is empty");
                return null;
            }
            System.out.println();
            System.out.println("next key is: " + tempp.toString());
            return tempp;
        } else {
            System.out.println("Prev key does not exist the index is empty");
            return null;
        }
    }

    public static int rangeKey(HashyTably h, int key1, int key2) {
        int start = Math.min(h.getIndex(key1), h.getIndex(key2));
        int end = Math.max(h.getIndex(key1), h.getIndex(key2));
        int counter = 0;
        if (start < 0 || end < 0 || start > h.studentArray.length - 1 || end > h.studentArray.length - 1) {
            System.out.println("there is no range between non existent keys");
            return 0;
        }
        for (int i = start; i < end; i++) {
            if (h.goTo(i) != null && h.goTo(i).studentId > 0) {
                nextKey(h, i); // problem might be here
                counter++;
            }
        }
        System.out.println("range between 2 keys: " + key1 + " and " + key2 + " is " + counter);
        return counter;
    }

    // Helper methods
    public static void radixSort(int[] array) {
        int max = 99999999;
        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains actual
        // position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[], so that array[] contains sorted numbers
        // according to the current digit
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than key to one position
            // ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }

    }
}

/*
 * multiple lists with n students
 * UNIQUE 8-digits keys id to each student --> use Long type to store these keys
 * user must be able to retreive key/value pair or access elements using its key
 * user can move to the predecessor or successor if available --> might need
 * hashing or trees
 * for small sets of IDs store them in DS while prioritizing the space
 * for big sets prioritize performance over space --> so the algorithm is
 * adaptive to the size
 * for single entry operations --> O(1) preferred but not wors than O(n)
 * opwerations on the complete set of students should never exceed O(n^2)
 *
 *
 */