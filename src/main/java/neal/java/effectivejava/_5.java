package neal.java.effectivejava;

import java.util.List;
import java.util.Objects;

/**
 * Static utility classes and singletons are inappropriate for classes
 * whose behavior is parameterized by an underlying resource
 */
public class _5 {

    public class SpellChecker {
        private final String dictionary;

        public SpellChecker(String dictionary) {
            this.dictionary = Objects.requireNonNull(dictionary);
        }

        public boolean isValid(String word) {
            return true;
        }

        public List<String> suggestions(String typo) {
            return null;
        }
    }
}

