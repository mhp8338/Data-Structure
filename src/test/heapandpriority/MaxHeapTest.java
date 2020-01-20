package heapandpriority;

import org.junit.Test;

import java.util.Random;


/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/13
 * @description:
 */
public class MaxHeapTest {

    @Test
    public void extract_max_text() {
        int n = 1000000;
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("extract_max_text right");
    }

    @Test
    public void heapify_test() {
        /*build data*/
        int n = 10;
        Integer[] origin = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            origin[i] = random.nextInt(10);
        }

        double withHeapify = covertArrToHeap(origin, n, true);
        double withoutHeapify = covertArrToHeap(origin, n, false);

        System.out.println("Use heapify cost time: " + withHeapify);
        System.out.println("Don't use heapify cost time: " + withoutHeapify);

    }

    private static double covertArrToHeap(Integer[] origin, int n, boolean isHeapify) {
        Long start = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(origin);
        } else {
            maxHeap = new MaxHeap<>();
            for (int i : origin) {
                maxHeap.add(i);
            }
        }

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        Long end = System.nanoTime();

        return (end - start ) / 1000000000.0;
    }

}