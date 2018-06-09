package neal.java.effectivejava._4classinterface;

/**
 * Item 16: In public classes, use accessor methods, not
 public fields
 */
public class _16 {

    class Point {
        private double x;
        private double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() { return x; }
        public double getY() { return y; }
        public void setX(double x) { this.x = x; }
        public void setY(double y) { this.y = y; }
    }

    // Public class with exposed immutable fields - questionable
    public final class Time {
        private static final int HOURS_PER_DAY = 24;
        private static final int MINUTES_PER_HOUR = 60;
        public final int hour;
        public final int minute;
        public Time(int hour, int minute) {
            if (hour < 0 || hour >= HOURS_PER_DAY)
                throw new IllegalArgumentException("Hour: " + hour);
            if (minute < 0 || minute >= MINUTES_PER_HOUR)
                throw new IllegalArgumentException("Min: " + minute);
            this.hour = hour;
            this.minute = minute;
        }
    }
//
//    public class t extends Time{
//
//    }
}
