package neal.java.effectivejava._4classinterface;



import com.google.common.collect.Lists;

import java.util.*;

/**
 * Item 18: Favor composition over inheritance
 */

/**
 * Inheritance is appropriate only in circumstances where the subclass really is a
 subtype of the superclass. In other words, a class B should extend a class A only
 if an “is-a” relationship exists between the two classes. If you are tempted to
 have a class B extend a class A, ask yourself the question: Is every B really an A?
 If you cannot truthfully answer yes to this question, B should not extend A. If the
 answer is no, it is often the case that B should contain a private instance of A and
 expose a different API: A is not an essential part of B, merely a detail of its
 implementation.
 */
public class _18 {

    // Broken - Inappropriate use of inheritance!
    static public class InstrumentedHashSet<E> extends HashSet<E> {
        // The number of attempted element insertions
        private int addCount = 0;

        public InstrumentedHashSet() {
        }

        public InstrumentedHashSet(int initCap, float loadFactor) {
            super(initCap, loadFactor);
        }

        @Override
        public boolean add(E
                                   e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }


    public static void main(String[] args) {
        InstrumentedHashSet instrumentedHashSet = new InstrumentedHashSet<String>();
        instrumentedHashSet.add("a");
        instrumentedHashSet.add("b");
        String[] array = {"a","b"};
        instrumentedHashSet.addAll(Arrays.asList(array));
        // 6
        /**
         * public boolean addAll(Collection<? extends E> c) {
         boolean modified = false;
         for (E e : c)
         if (add(e))
         modified = true;
         return modified;
         }
         */
        // 答案错误，addall会调用add函数，所以结果会重复计算
        System.out.println(instrumentedHashSet.getAddCount());



        InstrumentedSet instrumentedSet = new InstrumentedSet(new HashSet<String>());
        instrumentedSet.add("a");
        instrumentedSet.add("b");
        String[] arrays = {"a","b"};
        instrumentedSet.addAll(Arrays.asList(arrays));
        System.out.println(instrumentedSet.getAddCount());

    }

    // Wrapper class - uses composition in place of inheritance
    // import com.google.common.collect.ForwardingSet;
    static public class InstrumentedSet<E> extends ForwardingSet<E> {
        private int addCount = 0;

        public InstrumentedSet(Set<E> s) {
            super(s);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    // Reusable forwarding class
    static public class ForwardingSet<E> implements Set<E> {
        private final Set<E> s;

        public ForwardingSet(Set<E> s) {
            this.s = s;
        }

        public void clear() {
            s.clear();
        }

        public boolean contains(Object o) {
            return s.contains(o);
        }

        public boolean isEmpty() {
            return s.isEmpty();
        }

        public int size() {
            return s.size();
        }

        public Iterator<E> iterator() {
            return s.iterator();
        }

        public boolean add(E e) {
            return s.add(e);
        }

        public boolean remove(Object o) {
            return s.remove(o);
        }

        public boolean containsAll(Collection<?> c) {
            return s.containsAll(c);
        }

        public boolean addAll(Collection<? extends E> c) {
            return s.addAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return s.removeAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return s.retainAll(c);
        }

        public Object[] toArray() {
            return s.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return s.toArray(a);
        }

        @Override
        public boolean equals(Object o) {
            return s.equals(o);
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return s.toString();
        }
    }


}
