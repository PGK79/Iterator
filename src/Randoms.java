import java.util.*;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    List<Integer> list = new ArrayList<>();

    public Randoms(int min, int max) {
        Random random = new Random();
        int i = 0;

        while (i < max) {
            int spacing = max - min + 1;
            i = random.nextInt(spacing);
            i += min;
            list.add(i);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int nextItem = 0;

            @Override
            public boolean hasNext() {
                if (!list.isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    if(list.size() > 1) {
                        nextItem++;
                    }
                }
                return list.get(nextItem);
            }
        };
    }
}
