package at.tugraz.preferences.controller;

import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.PreferencesView;

public class PreferencesController {
  private PreferencesModel pm = new PreferencesModel();
  private PreferencesView pv = new PreferencesView();
  public PreferencesController(){
    pv.init(this, pm);
  }
  public void init(){
    setState(INITIAL_STATE); advanceState("init");
  }
  private INIT INITIAL_STATE = new INIT();
  private INTEREST_THEMES INTEREST_THEMES = new INTEREST_THEMES();
  private ACTIVITIES ACTIVITIES = new ACTIVITIES();
  private SUMMARIZATION SUMMARIZATION = new SUMMARIZATION();
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
  private class INIT extends ControllerState {
    public void init() { setState(INTEREST_THEMES); pv.ShowInterestThemes();}
  }
  private class INTEREST_THEMES extends ControllerState {
    public void next() { setState(ACTIVITIES); pv.ShowActivities();}
  }
  private class ACTIVITIES extends ControllerState {
    public void next() {setState(SUMMARIZATION); pv.ShowSummarization();}
    public void back() {setState(INTEREST_THEMES); pv.ShowInterestThemes();}
  }
  private class SUMMARIZATION extends ControllerState {
    public void back() {setState(ACTIVITIES); pv.ShowActivities();}
    public void store() {pm.store(); pv.ShowStored();}
  }
}