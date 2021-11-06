package randomArrayList_04;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement() {

        int end = super.size();
        Random random = new Random();
        int randomIndex = random.nextInt(end);
        return remove(randomIndex);
    }
}
