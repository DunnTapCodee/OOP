import list.SLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HelloWorld {

    public static void main(String[] args) {
        list.MyList<String> stringList = new SLinkedList<>();

        stringList.addFirst("one");
        stringList.addFirst("three");
        stringList.addFirst("sldkfgjhlksdjf");
        stringList.print();

        list.MyList<Integer> intList = new SLinkedList<>();

        intList.addFirst(1);
        intList.addFirst(2);
        intList.addFirst(46);
        intList.print();

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new TreeMap<>();
    }


}
