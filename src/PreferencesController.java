public class PreferencesController {
  private PreferencesModel preferencesmodel;
  private PreferencesView preferencesview;
  public PreferencesController(PreferencesModel preferencesmodel, PreferencesView preferencesview){
    this.preferencesmodel = preferencesmodel;
    this.preferencesview = preferencesview;
  }
  public void init(){
    setState(initialState); advanceState("init");
  }
  private InitialState initialState = new InitialState();
  private InterestThemesState interestthemes = new InterestThemesState();
  private ActivitiesState activities = new ActivitiesState();
  private SummarizationState summarization = new SummarizationState();
  private ControllerState state;
  private void setState(ControllerState state_) {
    state = state_;
  }
  public void advanceState(String event) {
    switch (event) {
      case "init": { state.init(); }
      break;
      case "next": { state.next(); }
        break;
      case "back": { state.back(); }
        break;
      case "store": { state.store(); }
        break;
      default: break;
    }
  }
  private abstract class ControllerState {
    public void init() {}
    public void next() {}
    public void back() {}
    public void store() {}
  }
  private class InitialState extends ControllerState {
    public void init() { setState(interestthemes); preferencesview.ShowInterestThemes();}
  }
  private class InterestThemesState extends ControllerState {
    public void next() { setState(activities); preferencesview.ShowActivities();}
  }
  private class ActivitiesState extends ControllerState {
    public void next() {setState(summarization); preferencesview.ShowSummarization();}
    public void back() {setState(interestthemes); preferencesview.ShowInterestThemes();}
  }
  private class SummarizationState extends ControllerState {
    public void back() {setState(activities); preferencesview.ShowActivities();}
    public void store() {preferencesmodel.store();}
  }
}

