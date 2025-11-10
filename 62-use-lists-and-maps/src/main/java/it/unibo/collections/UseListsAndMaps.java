package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final long AFRICA = 1_110_635_000L;
    private static final long AMERICAS = 972_005_000L;
    private static final long ANTARCTICA = 0L;
    private static final long ASIA = 4_298_723_000L;
    private static final long EUROPA = 742_452_000L;
    private static final long OCEANIA = 38_304_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arrList = new ArrayList<Integer>();
        for(int i = 1000; i<2000; i++){
            arrList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkList = new LinkedList<Integer>(java.util.stream.IntStream.range(1000, 2000).boxed().toList());
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer swap = arrList.getLast();
        arrList.set(arrList.size()-1, arrList.getFirst());
        arrList.set(0, swap);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer i : arrList){
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {

            arrList.add(0, (Integer)i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + arrList.size()
                + " Integers in ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {

            linkList.addFirst((Integer)i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + linkList.size()
                + " Integers in LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            arrList.get(arrList.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading 1000 times an Integer in the middle of ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            linkList.get(linkList.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading 1000 times an Integer in the middle of LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> mappa = new HashMap<>();
        mappa.put("Africa", AFRICA);
        mappa.put("Americas", AMERICAS);
        mappa.put("Antarctica", ANTARCTICA);
        mappa.put("Asia", ASIA);
        mappa.put("Europa", EUROPA);
        mappa.put("Oceania", OCEANIA);
        /*
         * 8) Compute the population of the world
         */
        long worldpop = 0;
        for(long population : mappa.values()){
            worldpop += population;
        }
        System.out.println("Siamo "+ worldpop +" persone in sto mondo demmerda!");
    }
}
