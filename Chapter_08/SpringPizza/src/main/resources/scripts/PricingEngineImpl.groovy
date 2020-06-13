import com.springinaction.pizza.domain.*
import com.springinaction.pizza.service.PricingEngine

class PricingEngineImpl implements PricingEngine, Serializable {
  public float calculateOrderTotal(Order order) {
    print "IN GROOVY";
  
    retun 99.99;
  }
}
