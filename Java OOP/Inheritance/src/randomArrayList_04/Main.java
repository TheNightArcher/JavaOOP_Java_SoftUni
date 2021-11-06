import randomArrayList_04.RandomArrayList;

public class Main {

    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(1);
        randomArrayList.add(15);
        randomArrayList.add(13);
        randomArrayList.add(14);

        System.out.println(randomArrayList.getRandomElement());
    }
}
