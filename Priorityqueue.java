import java.util.Random;

public class Priorityqueue {

    private int index = -1;
    private int[] array = new int[100];

    public void add(int element) {

        if (index == -1)
            array[++index] = element;

        int lastElement = array[index];

        if (element > lastElement)
            array[++index] = element;
        else {
            array[++index] = lastElement;

            for (int i = index - 1; i >= 0; i--) {
                if (element < array[i])
                    array[i + 1] = array[i];
                else {
                    array[i + 1] = element;
                    break;
                }

            }
            if (array[0] > element)
                array[0] = element;

        }
    }

    public void display() {
        for (int i = 0; i <= index; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

}

class TestingAbove {
    public static void main(String[] args) {
        var queue = new Priorityqueue();
        for (int i = 0; i < 20; i++) {
            var randNumber = new Random().nextInt(500);
            queue.add(randNumber);
        }

    }
}