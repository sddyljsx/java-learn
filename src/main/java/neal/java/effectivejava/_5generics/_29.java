package neal.java.effectivejava._5generics;

import java.util.EmptyStackException;

/**
 * Item	29:	Favor	generic	types
 */
public class _29 {


    static public class Stack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public Stack() {
            // elements = new E[DEFAULT_INITIAL_CAPACITY];

            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            elements[size++] = e;
        }

        public E pop() {
            if (size == 0)
                throw new EmptyStackException();
            //	push	requires	elements	to	be	of	type	E,	so	cast	is	correct
            @SuppressWarnings("unchecked") E result =
                    (E) elements[--size];
            //E result = elements[--size];
            elements[size] = null;    //	Eliminate	obsolete	reference
            return result;
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("abbbbb");
        System.out.println(stack.pop().length());
    }
}
