import java.util.TreeSet;

public class TreeSetExps {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("c");
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("z");
        System.out.println(treeSet);
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet.pollLast());
    }
}