package neal.java.effectivejava._4classinterface;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Item 21: Design interfaces for posterity
 */
public class _21 {


    interface  List<E>{

        Iterator<E> iterator();
        default boolean removeIf(Predicate<? super E> filter) {
            Objects.requireNonNull(filter);
            boolean result = false;
            for (Iterator<E> it = iterator(); it.hasNext(); ) {
                if (filter.test(it.next())) {
                    it.remove();
                    result = true;
                }}
            return result;
        }
    }

    static class ListImplement<e> implements List<e>{
        @Override
        public Iterator iterator() {
            return null;
        }
    };

    public void test(){
        ListImplement listImplement = new ListImplement<String>();
        listImplement.removeIf(s -> {
            return false;
        });
    }
}
