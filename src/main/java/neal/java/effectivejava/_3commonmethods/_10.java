package neal.java.effectivejava._3commonmethods;

import java.util.Objects;

/**
 * Item	 10:	 Obey	 the	 general	 contract	 when	 overriding
 * equals
 */
public class _10 {

    //	Broken	-	violates	symmetry!
    public final class CaseInsensitiveString {
        private final String s;

        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }
        //	Broken	-	violates	symmetry!
//        @Override	public	boolean	equals(Object	o)	{
//            if	(o	instanceof	CaseInsensitiveString)
//                return	s.equalsIgnoreCase(
//                        ((CaseInsensitiveString)	o).s);
//            if	(o	instanceof	String)	//	One-way	interoperability!
//                return	s.equalsIgnoreCase((String)	o);
//            return	false;
//        }


        @Override
        public boolean equals(Object o) {
            return o instanceof CaseInsensitiveString &&
                    ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
        }
    }


    //	Class	with	a	typical	equals	method
    public final class PhoneNumber {
        private final short areaCode, prefix, lineNum;

        public PhoneNumber(int areaCode, int prefix, int lineNum) {
            this.areaCode = rangeCheck(areaCode, 999, "area	code");
            this.prefix = rangeCheck(prefix, 999, "prefix");
            this.lineNum = rangeCheck(lineNum, 9999, "line	num");
        }

        private short rangeCheck(int val, int max, String arg) {
            if (val < 0 || val > max)
                throw new IllegalArgumentException(arg + ":	" + val);
            return (short) val;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof PhoneNumber))
                return false;
            PhoneNumber pn = (PhoneNumber) o;
            return pn.lineNum == lineNum && pn.prefix == prefix
                    && pn.areaCode == areaCode;
        }

        /**
         * generate by ide
         *
         * @return
         */

        @Override
        public int hashCode() {
            int result = (int) areaCode;
            result = 31 * result + (int) prefix;
            result = 31 * result + (int) lineNum;
            return result;
        }
    }


    public class Test{
        private int a;
        private String b;
        private Object object;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Test test = (Test) o;

            if (getA() != test.getA()) return false;
            if (!getB().equals(test.getB())) return false;
            return getObject().equals(test.getObject());
        }

        /**
         * 如果调用equals方法得到的结果为true，则两个对象的hashcode值必定相等
         *
         * 如果equals方法得到的结果为false，则两个对象的hashcode值不一定不同；

         　　如果两个对象的hashcode值不等，则equals方法得到的结果必定为false；

         　　如果两个对象的hashcode值相等，则equals方法得到的结果未知。
         * @return
         */

        @Override
        public int hashCode() {
            int result = getA();
            result = 31 * result + getB().hashCode();
            result = 31 * result + getObject().hashCode();
            return result;
        }
    }
}
