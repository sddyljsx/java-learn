package neal.java.effectivejava.objects;

import sun.misc.Cleaner;

import java.io.*;

/**
 * Item	8:	Avoid	finalizers	and	cleaners
 */

/**
 * 1. act	as	a	safety	net	in	case	the	owner	of	a	resource
 * neglects	to	call	its	close	method
 * <p>
 * 2. use	 of	 cleaners	 concerns	 objects	 with	 native	 peers.
 */
public class _8 {
    //System.runFinalizersOnExit
    //Runtime.runFinalizersOnExit
    //System.runFinalization
    //System.gc

    public static void main(String[] args) {
        try {

            /**
             * finalize()
             *
             * **/
//            //protected void finalize() throws IOException {
//            //    if ((fd != null) &&  (fd != FileDescriptor.in)) {
//            /* if fd is shared, the references in FileDescriptor
//             * will ensure that finalizer is only called when
//             * safe to do so. All references using the fd have
//             * become unreachable. We can call close()
//             */
//            //        close();
//            //    }
//            //}
            FileInputStream fileInputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //	An	autocloseable	class	using	a	cleaner	as	a	safety	net
//    public class Room implements AutoCloseable {
//        private static final Cleaner cleaner = Cleaner.create();
//
//        //	Resource	that	requires	cleaning.	Must	not	refer	to	Room!
//        private static class State implements Runnable {
//            int numJunkPiles;    //	Number	of	junk	piles	in	this	room
//
//            State(int numJunkPiles) {
//                this.numJunkPiles = numJunkPiles;
//            }
//
//            //	Invoked	by	close	method	or	cleaner
//            @Override
//            public void run() {
//                System.out.println("Cleaning	room");
//                numJunkPiles = 0;
//            }
//        }
//
//        //	The	state	of	this	room,	shared	with	our	cleanable
//        private final State state;
//        //	Our	cleanable.	Cleans	the	room	when	it’s	eligible	for	gc
//        private final Cleaner.Cleanable cleanable;
//
//        public Room(int numJunkPiles) {
//            state = new State(numJunkPiles);
//            cleanable = cleaner.register(this, state);
//        }
//
//        @Override
//        public void close() {
//            cleanable.clean();
//        }
//    }

    /**
     * AutoCloseable
     * Closeable
     * //
     * //     * Closes this resource, relinquishing any underlying resources.
     * //            * This method is invoked automatically on objects managed by the
     * //     * {@code try}-with-resources statement.
     * 原理 ： 编译器自动添加finally语句
     */
    public String read(String fileName) {
        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)
        ) {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
