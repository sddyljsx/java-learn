package neal.java.annotation;


@Annotation.ClassName(name = "test")
public class AnnotationTest {


    @Annotation.FieldName(name = "a")
    private int a = 0;

    public static void main(String[] args) {
        try {
            Annotation.parse("neal.java.Annotation.AnnotationTest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
