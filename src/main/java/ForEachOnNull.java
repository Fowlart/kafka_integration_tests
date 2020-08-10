public class ForEachOnNull {

    static String[] getStringArray(){
        return null;
    }

    public static void main(String[] args) {
        for (String s: getStringArray()) {
            System.out.println(s);
        }
    }
}
