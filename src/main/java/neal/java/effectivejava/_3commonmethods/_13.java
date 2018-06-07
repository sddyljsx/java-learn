package neal.java.effectivejava._3commonmethods;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Item	13:	Override	clone	judiciously
 */
public class _13 {
    /**
     * if	 a
     * class	 implements	 Cloneable,	 Object’s	 clone	 method	 returns	 a	 field-by-
     * field
     * copy
     * of
     * the
     * object;
     * otherwise
     * it
     * throws
     * CloneNotSupportedException
     */

    static class Test implements Cloneable {

        private int a = 1;

        @Override
        protected Test clone() throws CloneNotSupportedException {
            return (Test) super.clone();
        }
    }

    static class Test2 {
        private int a = 2;

        @Override
        protected Test2 clone() throws CloneNotSupportedException {
            return (Test2) super.clone();
        }
    }

    public static void main(String[] args) throws Exception {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Stack stack1 = stack.clone();
        System.out.println(stack1.size);
        System.out.println(stack1.elements);
        stack.pop();
        stack.pop();
        System.out.println(stack1.size);
        stack1.pop();
        System.out.println(stack1.size);




        Test test = new Test();
        Test test_clone = test.clone();
        System.out.println("clone");
        System.out.println(test_clone.a);




        Test2 test2 = new Test2();
        Test2 test2_clone = test2.clone();
        System.out.println("clone2");
        System.out.println(test2_clone.a);
    }

    public static class Stack implements Cloneable {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public Stack(Stack stack){

        }

        public static Stack newInstance(Stack stack){
            return null;
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0)
                throw new EmptyStackException();
            Object result = elements[--size];
            elements[size] = null;    //	Eliminate	obsolete	reference
            return result;
        }

        //	Ensure	space	for	at	least	one	more	element.
        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }

        /**
         * deep copy
         *
         * @return
         */
        @Override
        public Stack clone() {
            try {
                Stack result = (Stack) super.clone();
                result.elements = elements.clone();
                return result;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }


    //	Recursive	clone	method	for	class	with	complex	mutable	state
    public	static class	HashTable	implements	Cloneable	{
        private	Entry[]	buckets;
        private	static	class	Entry	{
            final	Object	key;
            Object	value;
            Entry	next;
            Entry(Object	key,	Object	value,	Entry	next)	{
                this.key	=	key;
                this.value	=	value;
                this.next	=	next;
            }
            //	Recursively	copy	the	linked	list	headed	by	this	Entry
            Entry	deepCopy()	{
                return	new	Entry(key,	value,
                        next	==	null	?	null	:	next.deepCopy());
            }
        }
        @Override	public	HashTable	clone()	{
            try	{
                HashTable	result	=	(HashTable)	super.clone();
                result.buckets	=	new	Entry[buckets.length];
                for	(int	i	=	0;	i	<	buckets.length;	i++)
                    if	(buckets[i]	!=	null)
                        result.buckets[i]	=	buckets[i].deepCopy();
                return	result;
            }	catch	(CloneNotSupportedException	e)	{
                throw	new	AssertionError();
            }
        }
    }
}
