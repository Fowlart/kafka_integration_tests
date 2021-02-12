public class VariableSope {
    public static void main(String[] args) {
        {
            String str = "insider";
        }
        // System.out.println(str); // not visible

        // JS like behavior 
        Object mas [] ={"wdw",new Integer(21)};
        System.out.println(mas[0]);
        System.out.println(mas[1]);
        mas[2]="sasas";
        System.out.println(mas[2]);
    }
}
