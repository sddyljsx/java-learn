package neal.java.effectivejava._2objects;


/**
 * Item	 4:	 Enforce	 noninstantiability	 with	 a	 private
 constructor

 * 工具类不允许实例化
 */
public class _4 {

    public static class UtilityClass {
        //	Suppress default constructor for noninstantiability
        private UtilityClass() {
            throw new AssertionError();
        }

        public static void test(){

        }
    }

    public static void main(String[] args){
        UtilityClass utilityClass = new UtilityClass();
    }


}
