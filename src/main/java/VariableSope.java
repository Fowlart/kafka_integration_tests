public class VariableSope {
    public static void main(String[] args) {
        {
            String str = "insider";
        }
        // System.out.println(str); // not visible
    }
}
