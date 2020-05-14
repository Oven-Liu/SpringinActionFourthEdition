package concert;

import org.springframework.stereotype.Component;

/**
 * @author Liu Xudong
 * @date 2020-04-26 19:14
 */
@Component
public class Musical implements Performance {

    @Override
    public void perform() {
        System.out.println("begin performance musical.");
    }
}
