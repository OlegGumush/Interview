package leetcode.questions.reflection.printobj;

import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        School school = new School();
        school.name = "Milkin";
        school.street = "Ariel 12";

        Name name = new Name();
        name.firstName = "Shani";
        name.lastName = "Moyal";

        Person p = new Person();
        p.name = name;
        p.id = "319638333";
        p.age = 30;
        p.school = school;
        p.someField = null;
        p.array = new Integer[]{1, 2, 3, 4};
        p.names = new Name[]{new Name("a", "b"), new Name("c", "d")};

        print(p);
    }

    private static void print(Object p) {
        print(p, "");
    }

    private static void print(Object o, String spaces) {

        if (o == null) {
            return;
        }

        printClass(o, spaces);
        spaces += "   ";

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {

            Object value = null;
            try {
                value = field.get(o);
            } catch (IllegalAccessException e) {
                System.out.println(String.format("%s%s is not public", spaces, field.getName()));
                continue;
            }

            if (isPrimitive(field.getType())) {
                handlePrimitive(field, spaces, field.getName(), value);
            } else if (field.getType().isArray()) {
                handleArray(spaces, field, value);
            } else {
                handleObject(spaces, field, value);
            }
        }
    }

    private static void handlePrimitive(Field field, String spaces, String name, Object value) {
        printValue(spaces, field.getName(), value);
    }

    private static void handleObject(String spaces, Field field, Object value) {
        if (value != null) {
            printValue(spaces, field.getName(), "");
            print(value, spaces);
        } else {
            printValue(spaces, field.getName(), "null");
        }
    }

    private static void handleArray(String spaces, Field field, Object value) {

        int length = Array.getLength(value);
        if (length == 0) {
            printValue(spaces, field.getName(), "[]");
            return;
        }
        if (isPrimitive(value.getClass().getComponentType())) {
            String primitiveArray = getArrayString(value, length);
            printValue(spaces, field.getName(), primitiveArray);
        } else {
            handleObjectArray(value, spaces);
        }
    }

    private static void handleObjectArray(Object value, String spaces) {

        StringBuilder sb = new StringBuilder();
        int length = Array.getLength(value);

        for (int i = 0; i < length; i++) {
            Object element = Array.get(value, i);
            // handleObject(spaces, );
        }
    }

    private static String getArrayString(Object value, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Object element = Array.get(value, i);
            if (i == length - 1) {
                sb.append(element);
            } else {
                sb.append(element).append(",");
            }
        }
        return sb.toString();
    }

    private static void printValue(String spaces, String fieldName, Object value) {

        System.out.println(new StringBuilder().append(spaces).append(fieldName).append("=").append(value));
    }

    private static boolean isPrimitive(Class<?> clazz) {
        if (clazz.equals(String.class)) {
            return true;
        }
        return ClassUtils.isPrimitiveOrWrapper(clazz);
    }

    private static void printClass(Object o, String spaces) {
        System.out.println(spaces + "Object of Class " + "\"" + o.getClass().getSimpleName() + "\"");
        System.out.println(spaces + "------------------------------------------------------------------------");
    }
}
