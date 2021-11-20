package tags;

public @interface Facebook {

    String value() default "";

    String description() default "";

    String video() default "";
}
