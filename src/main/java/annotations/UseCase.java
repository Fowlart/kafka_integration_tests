package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    /**
     * @UseCase(id = 47, description =
     * "Passwords must contain at least one numeric")
     **/


    int id(); // Перевірка типів гарантує, що в параметри аннотації потрапить саме int


    String description() default "no description"; // може мати значення по дефолту
}
