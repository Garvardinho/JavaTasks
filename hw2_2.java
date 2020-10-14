package geekbrains.java_alg.hw2;

import java.util.Arrays;
import java.util.Random;

public class hw2_2 {

    public static void main(String[] args) {
        int []array;
        int key;
        long start_time;
        long end_time;
        double time;

        array = new int[30];
        Random rand = new Random();
        key = rand.nextInt(20);

        for (int i = 0; i < array.length; ++i)
            array[i] = rand.nextInt(20);

        start_time = System.nanoTime();
        if (linear(array, key) != -1)
            System.out.println("Success!");
        end_time = System.nanoTime();

        time = (double)(end_time - start_time);
        time *= 0.000001f;
        System.out.println("Linear search time: " + time + "ms");

        Arrays.sort(array);
        start_time = System.nanoTime();
        if (binary(array, key) != -1)
            System.out.println("Success!");
        end_time = System.nanoTime();

        time = (double)(end_time - start_time);
        time *= 0.000001f;
        System.out.println("Binary search time: " + time + "ms");
        /*
        При проведении эксперимента с 1 млрд элементов в диапазоне от 0 до 10000
        и рандомным ключом из этого же диапазона было выяснено следующее:
        При неотсортированном массиве линейный поиск работает примерно также быстро, как и бинарный при отсортированном.
        Это связано с тем, что найти рандомный элемент в неотсортированном массиве можно почти всегда очень быстро,
        так как вероятность того, что он тебе попадется довольно высока (для большого количества элементов).
        С другой же стороны, при отсортированном массиве в обоих случаях цифры, как и должно было произойти, сильно
        отличались - бинарный поиск был быстрее на несколько порядков.
         */
    }

    public static int linear(int []array, int key) {
        for (int i = 0; i < array.length; ++i)
            if (array[i] == key) return i;

        return -1;
    }

    public static int binary(int []array, int key) {
        int left = 0;
        int right = array.length - 1;
        int middle;

        while (left != right) {
            middle = (left + right) / 2;

            if (array[middle] == key) return middle;
            else if (array[middle] > key) right = middle - 1;
            else left = middle + 1;
        }

        return -1;
    }
}
