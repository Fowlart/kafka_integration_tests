package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Приклад синтаксису аннотацій. Дуже схоже на інтерфейси.
 **/
@Target(ElementType.METHOD) // до чого застосовується аннотація(метод, поле)
@Retention(RetentionPolicy.RUNTIME) //
public @interface Test {
}

/**
 * Це "маркерна аннтоція". В ній немає "методів". Вона порожня
 **/
