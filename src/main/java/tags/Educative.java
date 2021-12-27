package tags;

public @interface Educative {

    Type value();

    String description() default "";

    String video() default "";
}
