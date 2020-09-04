package annotations.table.creator;

@Table(name = "Person")
public class Person {

    @Column(columnName = "Name", columnType = String.class)
    String name;

    @Column(columnName = "Age", columnType = int.class)
    int age;
}
