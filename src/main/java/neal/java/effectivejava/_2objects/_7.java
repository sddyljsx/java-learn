package neal.java.effectivejava._2objects;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Item	7:	Eliminate	obsolete	object	references
 */
public class _7 {

    public class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0)
                throw new EmptyStackException();
            /**
             * memory leak
             */
            //return elements[--size]; // memory leak

            Object	result	=	elements[--size];
            elements[size]	=	null;	//	Eliminate	obsolete	reference
            return	result;
        }

        /**
         * Ensure	space	for	at	least	one	more	element,	roughly
         * doubling	the	capacity	each	time	the	array	needs	to	grow.
         */
        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }


}
