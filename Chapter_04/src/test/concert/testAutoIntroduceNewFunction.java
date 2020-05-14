package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Liu Xudong
 * @date 2020-04-26 22:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aspect-config.xml")
// @ContextConfiguration(classes = Config.class)
public class testAutoIntroduceNewFunction {

    @Autowired
    private Performance musical;

    @Test
    public void performance() {
        musical.perform();
        Encoreable defaultEncoreable = (Encoreable) musical;
        defaultEncoreable.performanceEncore();
    }

}
