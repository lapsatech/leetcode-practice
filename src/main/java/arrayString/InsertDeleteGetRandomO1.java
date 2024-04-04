package arrayString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

  public static class GenericRandomizedSet<T> {

    public GenericRandomizedSet() {
    }

    private final HashMap<T, Integer> index = new HashMap<>();
    private final ArrayList<T> array = new ArrayList<>();

    public boolean insertValue(T value) {
      if (index.containsKey(value)) {
        return false;
      }
      int addedIndex = array.size();
      array.add(value);
      index.put(value, addedIndex);
      return true;
    }

    public boolean removeValue(T value) {
      if (!index.containsKey(value)) {
        return false;
      }
      int removedIndex = index.remove(value);
      if (removedIndex == array.size() - 1) {
        array.remove(removedIndex);
      } else {
        T tailValue = array.remove(array.size() - 1);
        array.set(removedIndex, tailValue);
        index.replace(tailValue, removedIndex);
      }
      return true;
    }

    private final Random r = new Random();

    public T getRandomValue() {
      return array.get(r.nextInt(array.size()));
    }

  }

  public static class RandomizedSet extends GenericRandomizedSet<Integer> {

    public boolean insert(int val) {
      return insertValue(Integer.valueOf(val));
    }

    public boolean remove(int val) {
      return removeValue(Integer.valueOf(val));
    }

    public int getRandom() {
      return getRandomValue().intValue();
    }

  }

}
