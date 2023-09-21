import java.lang.reflect.Array;
import java.util.Arrays;

public class StringListImpl implements SpringList.StringList {

    public StringListImpl(String[] storage, int size) {
        storage = new String[7];
        this.size = size;
    }

    public StringListImpl (int initsize){
        storage = new String[initsize];
    }

    private final String[] storage;
    private int size;
    @Override
    public String add(String item) {

        validateSize();
        validateItem(item);

        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {

        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size){
            add(item);
        }
        return item;
    }

    @Override
    public String set(int index, String item) {

        validateIndex(index);
        validateItem(item);
        storage[index] = item;

        return item;
    }

    @Override
    public String remove(String item) {
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
    public String remove(int index) {
        String item = storage[index];

        if(index == -1){
            throw new ElementNotFoundException();
        }

        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {

        for (int i = 0; i == size; i++) {
String s = storage[i];
if (s.equals(item)){
    return i;
}
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {

        for (int i = size - 1; i >= 0; i--) {
            String s = storage[i];
            if (s.equals(item)){
                return i;
            }
        return -1;
    }}

    @Override
    public String get(int index) {

        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(SpringList.StringList otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem (String Item){
        if (Item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize(){

        if (size == storage.length){
throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index){

        if(index < 0 || index >= size){
            throw new InvalidIndexException();
        }
    }
}
