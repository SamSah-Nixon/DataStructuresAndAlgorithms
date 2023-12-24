public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 4, 7, 6, 9, 8, 0 };
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    /*
    Choose a gap size
    Create a sublist of elements spaced by the gapsize apart
    Perform insertion sort on each sublist
    Reduce the gap size
    */
    public static int[] shellSort(int[] arr) {
        //Choose a gap size
        int temp, preIndex, gap = arr.length / 2;
        while (gap > 0) {
            //Insertion sort with the sublist
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            //Reduce the gap size
            gap /= 2;
        }
        return arr;
    }
}
