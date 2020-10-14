package geekbrains.java_alg.hw2;

import java.util.Arrays;
import java.util.Random;

public class hw2_1 {

    public static void main(String[] args) {
	    int []array;
	    int []arrayCopy;

	    array = new int[10];
        Random rand = new Random();

	    for (int i = 0; i < array.length; ++i)
	        array[i] = rand.nextInt(15);

        arrayCopy = Arrays.copyOf(array, array.length);

	    long start_time = System.nanoTime();

	    System.out.println("Array: " + Arrays.toString(array));
	    System.out.println("Copied array: " + Arrays.toString(arrayCopy));
	    System.out.println("Equals: " + array.equals(arrayCopy));
	    System.out.println("Arrays.equals: " + Arrays.equals(array, arrayCopy));

	    long end_time = System.nanoTime();
	    double time = (double)(end_time - start_time);
	    time *= 0.000001f;
        System.out.println("Time: " + time + "ms");
    }
}
