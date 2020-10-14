package geekbrains.java_alg.hw2;

import java.util.Arrays;
import java.util.Random;

public class hw2_3to6 {

    public static void main(String[] args) {
        int []array;
        int []unsorted;

        array = new int[400];
        Random rand = new Random();

        for (int i = 0; i < array.length; ++i)
            array[i] = rand.nextInt(15);

        unsorted = Arrays.copyOf(array, array.length);

        System.out.println("Arrays.sort time: " + sortTime(array) + "ms");

        array = Arrays.copyOf(unsorted, unsorted.length);
        System.out.println("Bubble sort time: " + bubbleSortTime(array) + "ms");

        array = Arrays.copyOf(unsorted, unsorted.length);
        System.out.println("Selection sort time: " + selectionSortTime(array) + "ms");

        array = Arrays.copyOf(unsorted, unsorted.length);
        System.out.println("Insert sort time: " + insertSortTime(array) + "ms");
    }

    public static double sortTime(int []array) {
        long start_time = System.nanoTime();
        Arrays.sort(array);
        long end_time = System.nanoTime();
        double time = (double)(end_time - start_time);
        time *= 0.000001f;

        return time;
    }

    public static double bubbleSortTime(int []array) {
        long start_time = System.nanoTime();
        bubbleSort(array);
        long end_time = System.nanoTime();
        double time = (double)(end_time - start_time);
        time *= 0.000001f;

        return time;
    }

    public static void bubbleSort(int []array) {
        for (int size = array.length - 1; size > 0; --size)
            for (int i = 0; i < size; ++i)
                if (array[i] > array[i + 1]) swapM(array, i, i + 1);
    }

    public static double selectionSortTime(int []array) {
        long start_time = System.nanoTime();
        selectionSort(array);
        long end_time = System.nanoTime();
        double time = (double)(end_time - start_time);
        time *= 0.000001f;

        return time;
    }

    public static void selectionSort(int []array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] <= array[min]) {
                    min = j;
                }
            }
            swapM(array, i, min);
        }
    }

    public static double insertSortTime(int []array) {
        long start_time = System.nanoTime();
        insertSort(array);
        long end_time = System.nanoTime();
        double time = (double)(end_time - start_time);
        time *= 0.000001f;

        return time;
    }

    public static void insertSort(int []array) {
        int buff, in;

        for (int i = 1; i < array.length; ++i) {
            buff = array[i];
            in = i;

            while (in > 0 && array[in - 1] > buff) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = buff;
        }
    }

    public static void swapM(int []array, int i1, int i2) {
        int buff = array[i2];
        array[i2] = array[i1];
        array[i1] = buff;
    }
}