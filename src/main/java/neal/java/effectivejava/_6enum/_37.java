package neal.java.effectivejava._6enum;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * Item	37:	Use	EnumMap	instead	of	ordinal	indexing
 */
public class _37 {

    static class Plant {
        enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

        public final String name;
        public final LifeCycle lifeCycle;

        Plant(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        ArrayList<Plant> garden = new ArrayList<>();
        garden.add(new Plant("a", Plant.LifeCycle.ANNUAL));
        garden.add(new Plant("b", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("c", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("d", Plant.LifeCycle.BIENNIAL));

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

        //	Using	a	stream	and	an	EnumMap	to	associate	data	with	an	enum
        System.out.println(garden.stream()
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }

    //	Using	a	nested	EnumMap	to	associate	data	with	enum	pairs
    public enum Phase {
        SOLID, LIQUID, GAS;

        public enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
            private final Phase from;
            private final Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }

            //	Initialize	the	phase	transition	map
            private static final Map<Phase, Map<Phase, Transition>>
                    m = Stream.of(values()).collect(groupingBy(t -> t.from,
                    () -> new EnumMap<>(Phase.class),
                    toMap(t -> t.to, t -> t,
                            (x, y) -> y, () -> new EnumMap<>(Phase.class))));

            public static Transition from(Phase from, Phase to) {
                return m.get(from).get(to);
            }
        }
    }
}
