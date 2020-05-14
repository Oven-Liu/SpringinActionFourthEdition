package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author Liu Xudong
 * @date 2020-04-26 18:53
 */
@Aspect
@Component
public class EncoreableIntroducer {
    @DeclareParents(value = "concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public Encoreable encoreable;
}
