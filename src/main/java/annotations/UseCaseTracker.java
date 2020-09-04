package annotations;

import java.lang.reflect.Method;

public class UseCaseTracker {
    public static void
    trackUseCases(Class<?> cl) {

        // Взяти всі методи
        for (Method m : cl.getDeclaredMethods()) {

            // Тип - аннотація Ж)
            UseCase uc = m.getAnnotation(UseCase.class); // взяти аннотацію

            // Якщо така є
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
            }
        }
    }

    public static void main(String[] args) {
        trackUseCases(PasswordUtils.class);
    }
}