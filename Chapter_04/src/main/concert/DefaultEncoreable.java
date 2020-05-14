package concert;

import org.springframework.stereotype.Component;

/**
 * @author Liu Xudong
 * @date 2020-04-26 19:00
 */
@Component
public class DefaultEncoreable implements Encoreable {

    @Override
    public void performanceEncore() {
        System.out.println("performance again.");
    }
}
