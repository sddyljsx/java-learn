package neal.java.effectivejava._4classinterface;

import java.applet.AudioClip;

/**
 * Item 20: Prefer interfaces to abstract classes
 */
public class _20 {
    public interface Singer {
        AudioClip sing(String s);
    }

    public interface Songwriter {
        String compose(int chartPosition);
    }

    public interface SingerSongwriter extends Singer, Songwriter {
        AudioClip strum();

        void actSensitive();
    }
}
