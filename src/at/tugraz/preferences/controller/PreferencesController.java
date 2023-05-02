package at.tugraz.preferences.controller;

import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.PreferencesView;

public class PreferencesController {
  private PreferencesModel pm = new PreferencesModel();
  private PreferencesView pv = new PreferencesView();
  public PreferencesController(){
    pv.init(this, pm);
  }

  private void setState(ControllerState state) {
    this.state = state;
  }

  public void init() {
    // register listeners
    pv.getInterestThemesPanel().setNextButtonClickListener(new InterestThemesPanel.NextButtonClickListener() {
      @Override
      public void onNextButtonClicked(ActionEvent e) {
        pm.setAdventure(pv.getInterestThemesPanel().getAdventureValue());
        pm.setCulture(pv.getInterestThemesPanel().getCultureValue());
        pm.setSports(pv.getInterestThemesPanel().getSportsValue());
        advanceState(e);
      }
    });
    pv.getActivitiesPanel().setBackButtonClickListener(new ActivitiesPanel.BackButtonClickListener() {
      @Override
      public void onBackButtonClicked(ActionEvent e) {
        advanceState(e);
      }
    });
    pv.getActivitiesPanel().setNextButtonClickListener(new ActivitiesPanel.NextButtonClickListener() {
      @Override
      public void onNextButtonClicked(ActionEvent e) {
        pm.setSauna(pv.getActivitiesPanel().getSaunaValue());
        pm.setTennis(pv.getActivitiesPanel().getTennisValue());
        pm.setGym(pv.getActivitiesPanel().getGymValue());
        advanceState(e);
      }
    });
    pv.getSummarizationPanel().setBackButtonClickListener(new SummarizationPanel.BackButtonClickListener() {
      @Override
      public void onBackButtonClicked(ActionEvent e) {
        advanceState(e);
      }
    });
    pv.getSummarizationPanel().setStoreButtonClickListener(new SummarizationPanel.StoreButtonClickListener() {
      @Override
      public void onStoreButtonClicked(ActionEvent e) {
        advanceState(e);
      }
    });

    setState(interestThemesState);
    pv.showInterestThemes();
  }

  public void advanceState(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Next":
        state.next();
        break;
      case "Back":
        state.back();
        break;
      case "Store":
        state.store();
        break;
      default:
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