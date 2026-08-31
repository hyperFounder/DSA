package main.sorting;

public class MergeSort{

    private int[] array;
    private int[] temp;

    public static void main(String[] args) {
        int[] data = {9, 3, 7, 5, 6, 4, 8, 2};
        MergeSort sorter = new MergeSort(data);
        sorter.sort();
        System.out.println(java.util.Arrays.toString(data));
    }

    public MergeSort(int[] array) {
        this.array = array;
        this.temp = new int[array.length];
    }
    public void sort(){
        if (array == null || array.length <= 1) return;
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int left, int right){
        if (left >= right)return;
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right){
        for(int i = left; i<=right; i++){
            temp[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right){
            if (temp[i] <= temp[j]){
                array[k++] = temp[i++];
            } else{
                array[k++] = temp[j++];
            }
        }
        while (i<=mid){
            array[k++] = temp[i++];
        }
    }
}