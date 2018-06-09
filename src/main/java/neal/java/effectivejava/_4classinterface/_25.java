package neal.java.effectivejava._4classinterface;


/**
 * Item 25: Limit source files to a single top-level class
 */
// Static member classes instead of multiple top-level classes
public class _25 {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }


}
class Utensil {
    static final String NAME = "pan";
}

class Dessert {
    static final String NAME = "cake";
}