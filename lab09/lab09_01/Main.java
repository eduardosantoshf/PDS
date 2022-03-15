import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<Integer> vector = new VectorGeneric<>();
        for (int i = 0; i < 11; i++) {
            vector.addElem(i);
        }
        System.out.println("/----------Iterator----------/");
        Iterator<Integer> it = vector.iterator();
        while (it.hasNext()) {
            int n = it.next();
            System.out.println(n);
        }

        System.out.println("/----------ListIterator----------/");
        ListIterator<Integer> lt = vector.listIterator();
        while (lt.hasNext()) {
            int next = lt.next();
            System.out.println(next + "; next index: " + lt.nextIndex());
        }
    }
}
