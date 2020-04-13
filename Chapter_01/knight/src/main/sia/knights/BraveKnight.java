package sia.knights;
  
public class BraveKnight implements sia.knights.Knight {

  private sia.knights.Quest quest;

  public BraveKnight(sia.knights.Quest quest) {
    this.quest = quest;
  }

  public void embarkOnQuest() {
    quest.embark();
  }

}
