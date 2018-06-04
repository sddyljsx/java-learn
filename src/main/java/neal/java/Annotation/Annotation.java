package neal.java.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Annotation {

    @Target(ElementType.TYPE)//只能应用于类上
    @Retention(RetentionPolicy.RUNTIME)//保存到运行时
    public @interface ClassName {
        String name() default "";
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldName {
        String name() default "";
    }


   public static void parse(String className) throws Exception{
        Class clazz = Class.forName(className);

        ClassName className1 = (ClassName) clazz.getAnnotation(ClassName.class);
        System.out.println(String.format("class name: %s", className1.name()));
        for(Field field: clazz.getDeclaredFields()){
            FieldName fieldName = field.getAnnotation(FieldName.class);
            System.out.println(String.format("field name: %s", fieldName.name()));

        }
   }
}


