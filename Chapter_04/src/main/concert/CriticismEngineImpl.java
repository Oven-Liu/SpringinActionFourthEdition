package concert;

/**
 * @author Liu Xudong
 * @date 2020-04-28 22:10
 */
public class CriticismEngineImpl implements CriticismEngine {
    // injected
    private String[] criticismPool;
    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }

    public CriticismEngineImpl() {
    }

    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }
}
