package neal.java.effectivejava._3commonmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * Item	 11:	 Always	 override	 hashCode	 when	 you
 * override	equals
 */
public class _11 {

    /**
     * 如果调用equals方法得到的结果为true，则两个对象的hashcode值必定相等
     *
     * 如果equals方法得到的结果为false，则两个对象的hashcode值不一定不同；

     　　如果两个对象的hashcode值不等，则equals方法得到的结果必定为false；

     　　如果两个对象的hashcode值相等，则equals方法得到的结果未知。
     */

    /**
     * The	 value	 31	 was
     * chosen	 because	 it	 is	 an	 odd	 prime.	 If	 it	 were	 even	 and	 the	 multiplication
     * overflowed,	information	would	be	lost,	because	multiplication	by	2	is	equivalent
     * to	shifting.	The	advantage	of	using	a	prime	is	less	clear,	but	it	is	traditional.	A
     * nice	 property	 of	 31	 is	 that	 the	 multiplication	 can	 be	 replaced	 by	 a	 shift	 and	 a
     * subtraction	for	better	performance	on	some	architectures:	31	*	i	==	(i	<<
     * 5)	-	i.	Modern	VMs	do	this	sort	of	optimization	automatically
     */

    public static class PhoneNumber {
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

        @Override
        public int hashCode() {
            int result = (int) areaCode;
            result = 31 * result + (int) prefix;
            result = 31 * result + (int) lineNum;
            return result;
        }

        //	hashCode	method	with	lazily	initialized	cached	hash	code
//        private	int	hashCode;	//	Automatically	initialized	to	0
//        @Override	public	int	hashCode()	{
//            int	result	=	hashCode;
//            if	(result	==	0)	{
//                result	=	Short.hashCode(areaCode);
//                result	=	31	*	result	+	Short.hashCode(prefix);
//                result	=	31	*	result	+	Short.hashCode(lineNum);
//                hashCode	=	result;
//            }
//            return	result;
//        }
    }

    public static void main(String[] args) {
        /**
         * 1.8 hashmap 一个bucket的元素过多就将链表转化为红黑tree
         *
         */
        Map map = new HashMap<PhoneNumber, String>();
        map.put(new PhoneNumber(1, 2, 3), "1");
        /**
         * public V get(Object key) {
         Node<K,V> e;
         return (e = getNode(hash(key), key)) == null ? null : e.value;
         }


         final Node<K,V> getNode(int hash, Object key) {
         Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
         if ((tab = table) != null && (n = tab.length) > 0 &&
         (first = tab[(n - 1) & hash]) != null) {
         if (first.hash == hash && // always check first node
         ((k = first.key) == key || (key != null && key.equals(k))))
         return first;
         if ((e = first.next) != null) {
         if (first instanceof TreeNode)
         return ((TreeNode<K,V>)first).getTreeNode(hash, key);
         do {
         if (e.hash == hash &&
         ((k = e.key) == key || (key != null && key.equals(k))))
         return e;
         } while ((e = e.next) != null);
         }
         }
         return null;
         }
         */

        /**
         * 不重写hashcode无法获取值,map先用hashcode找到桶,再用equal或者==
         */
        System.out.println(map.get(new PhoneNumber(1, 2, 3)));

        System.out.println(Objects.hash(1,2,4));
        System.out.println(new String("123aaaaaaaaaaaaaaaggggggggggggggggggggdggggggggggggggg").hashCode());


        HashFunction hashFunction = Hashing.murmur3_32();
        HashCode hashCode = hashFunction.newHasher().putChar('a').putChar('b').hash();
        System.out.println(hashCode.toString());
    }
}
