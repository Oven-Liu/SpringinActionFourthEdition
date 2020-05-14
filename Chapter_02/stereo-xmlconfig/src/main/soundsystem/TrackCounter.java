package soundsystem;

import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liu Xudong
 * @date 2020-04-24 23:20
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    // @Pointcut("execution(* soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)")
    // public void trackPlayed(int trackNumber) {}

    // @Before("trackPlayed(trackNumber)")
    public void watchPerformance(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
