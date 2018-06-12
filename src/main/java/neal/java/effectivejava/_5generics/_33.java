package neal.java.effectivejava._5generics;

import neal.java.annotation.Annotation;

import java.lang.reflect.AnnotatedElement;
import java.util.*;

/**
 * Item	33:	Consider	typesafe	heterogeneous	containers
 */

/**
 * You	can	use	Class	objects	as	keys	for	such	typesafe	heterogeneous
 containers.	A	Class	object	used	in	this	fashion	is	called	a	type	token.	You	can
 also	use	a	custom	key	type.	For	example,	you	could	have	a	DatabaseRow	type
 representing	a	database	row	(the	container),	and	a	generic	type	Column<T>	as
 its	key.
 */
public class _33 {

    //	Typesafe	heterogeneous	container	pattern	-	API
    static public class Favorites {

        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {

            favorites.put(Objects.requireNonNull(type), type.cast(instance));

        }

        public <T> T getFavorite(Class<T> type) {

            return type.cast(favorites.get(type));
        }
    }

    public <T extends Annotation>
    T getAnnotation(Class<T> annotationType) {
        return null;
    }

    //	Use	of	asSubclass	to	safely	cast	to	a	bounded	type	token
    static Annotation getAnnotation(AnnotatedElement element,
                                    String annotationTypeName) {
        Class<?> annotationType = null;    //	Unbounded	type	token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(
                annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) {
        ThreadLocal<Long> longLocal = new ThreadLocal<>();
        longLocal.set(100L);
        System.out.println(longLocal.get());
        longLocal.remove();
        System.out.println(longLocal.get());


        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        //f.putFavorite(List<String>.class,null);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s	%x	%s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());


        // create arraylist
        ArrayList<String> arlst = new ArrayList<>();

        // populate the list
        arlst.add("TP");
        arlst.add("PROVIDES");
        arlst.add("QUALITY");
        arlst.add("TUTORIALS");

        // create typesafe view of the collection
        Collection<String> tslst;
        tslst = Collections.checkedCollection(arlst, String.class);

        System.out.println("Type safe view is: " + tslst);


        List<String> strList = new ArrayList<String>();
        Class<? extends List> strList_cast = strList.getClass().asSubclass(List.class);

    }

}
