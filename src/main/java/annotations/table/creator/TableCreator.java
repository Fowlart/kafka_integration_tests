package annotations.table.creator;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Objects;

public class TableCreator {

    public static String createTable(Class<?> aClass){

       Table table = aClass.getAnnotation(Table.class);

       StringBuilder query = new StringBuilder();

       if (Objects.nonNull(table)) {
           query.append("CREATE TABLE ").append(table.name()).append(" (");
       }

       Arrays.stream(aClass.getDeclaredFields())
               .map(field -> field.getAnnotation(Column.class))
               .filter(Objects::nonNull)
               .forEach(column ->
               {
                   String columnName =column.columnName();
                   String type;
                   if (column.columnType()==String.class) {
                       type = "TEXT";
                   }
                   else {
                       type = "INTEGER";
                   }
                   query.append(columnName+" "+type+", ");
               });

       return StringUtils.removeEnd(query.toString(),", ").concat(");");

    }

    public static void main(String[] args) {
        System.out.println(createTable(Person.class));
    }
}
