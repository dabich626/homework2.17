import java.lang.reflect.Array;
import java.util.Arrays;

public class ListImpl implements SpringList.IntegerList {

    public IntegerListImpl(Integer[] storage, int size) {
        storage = new Integer[7];
        this.size = size;
    }

    public IntegerListImpl (int initsize){
        storage = new Integer[initsize];
    }

    private final Integer[] storage;
    private int size;
    @Override
    public Integer add(Integer item) {

        validateSize();
        validateItem(item);

        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {

        growIfNeeded();
        validateItem(item);
        validateIndex(index);

        if (index == size){
            add(item);
        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {

        validateIndex(index);
        validateItem(item);
        storage[index] = item;

        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if(index == -1){
            throw new ElementNotFoundException();
        }

        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        Integer item = storage[index];

        if(index == -1){
            throw new ElementNotFoundException();
        }

        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer [] storageCopy = toArray();
        sort(storageCopy);
    }

    @Override
    public int indexOf(Integer item) {

        for (int i = 0; i == size; i++) {
Integer s = storage[i];
if (s.equals(item)){
    return i;
}
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {

        for (int i = size - 1; i >= 0; i--) {
            Integer s = storage[i];
            if (s.equals(item)){
                return i;
            }
        return -1;
    }}

    @Override
    public Integer get(int index) {

        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(SpringList.IntegerList otherList) {
        return Array.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size = 0;
    }

    @Override
    public void clear() {
size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem (Integer Item){
        if (Item == null) {
            throw new NullItemException();
        }
    }

    private void growIfNeeded(){

        if (size == storage.length){
grow();
        }
    }

    private void validateIndex(int index){

        if(index < 0 || index >= size){
            throw new InvalidIndexException();
        }
    }

    private void sort(int [] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private boolean binarySearch(Integer [] arr, Integer item){
        for (int i : arr) {
            if (i == item) {
                return true;
            }
        }
        return false;
    }

    private void grow(){
        storage = Array.copyOf(storage, size + size / 2);
    }

    private void quickSort(Integer[] arr, int begin, int end){
if (begin < end){
    if (paritionIndex = parition(arr, begin, end)){
        quickSort(arr, begin, end: paritionIndex - 1);
        quickSort(arr, begin: paritionIndex + 1,  end);
    }
}
    }

    private void parition(Integer[] arr, int begin, int end){

        int pivot = arr[end];
        int i = (begin - 1);

        for (int i = begin, i < end, i++){
            if(arr[i]<=pivot){
                i++;

                swapElements(arr, 1, i);
            }

            swapElements(arr, 1 + 1, end);
            return i + 1;
        }
    }

    private void swapElements(Integer[] arr, int 11, int 12){
        int temp = arr[11];
        arr[11] = arr[12];
        arr[12] = temp;

    }
}
