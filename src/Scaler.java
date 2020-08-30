import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Scaler {

    private static String solve(String A) {

        String concated = A.concat(A);
        char c[] = concated.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == Character.toUpperCase(c[i])) {
                c[i] = '-';
            }
        }

        //Character vowes[] = {'a', 'e', 'i', 'o', 'u'};

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');

        for (int i = 0; i < c.length; i++) {
            if (vowels.contains(c[i])) {
                c[i] = '#';
            }
        }

        return new String(c).replace("-", "");
    }

    public static LinkedList.ListNode solve(LinkedList.ListNode A) {

        List<Integer> p = new ArrayList<>();

        LinkedList.ListNode fastPtr = A;

        while (fastPtr != null && fastPtr.next != null) {
            p.add(fastPtr.val * 10 + fastPtr.next.val);
            fastPtr = fastPtr.next.next;
        }

        Collections.sort(p);

        int u, t;

        LinkedList.ListNode newest = A;

        for (int i = 0; i < p.size(); i++) {
            t = (p.get(i) / 10) % 10;
            u = p.get(i) % 10;

            newest.val = t;
            newest.next.val = u;

            newest = newest.next.next;
        }

        return A;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Insert the values
        list = list.insert(list, 6);
        list = list.insert(list, 5);
        list = list.insert(list, 4);
        list = list.insert(list, 3);
        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 8);
        list = list.insert(list, 7);

        list.printList(list);

        solve(list.head);

        list.printList(list);

    }


}
