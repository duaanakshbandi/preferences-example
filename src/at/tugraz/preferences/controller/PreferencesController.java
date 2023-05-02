package at.tugraz.preferences.controller;

import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.*;

import java.awt.event.ActionEvent;

public class PreferencesController {

  private final PreferencesModel pm;
  private final PreferencesView pv;

  private InterestThemesState interestThemesState = new InterestThemesState();
  private ActivitiesState activitiesState = new ActivitiesState();
  private SummarizationState summarizationState = new SummarizationState();
  private ControllerState state;

  public PreferencesController() {
    pm = new PreferencesModel();
    pv = new PreferencesView();
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
    }
  }

  private abstract static class ControllerState {
    public void next() {}
    public void back() {}
    public void store() {}
  }

  private class InterestThemesState extends ControllerState {
    public void next() {
      setState(activitiesState);
      pv.showActivities();
    }
  }

  private class ActivitiesState extends ControllerState {
    public void next() {
      setState(summarizationState);
      pv.getSummarizationPanel().setAdventureValue(pm.getAdventure());
      pv.getSummarizationPanel().setCultureValue(pm.getCulture());
      pv.getSummarizationPanel().setSportsValue(pm.getSports());
      pv.getSummarizationPanel().setSaunaValue(pm.getSauna());
      pv.getSummarizationPanel().setTennisValue(pm.getTennis());
      pv.getSummarizationPanel().setGymValue(pm.getGym());
      pv.showSummarization();
    }

    public void back() {
      setState(interestThemesState);
      pv.showInterestThemes();
    }
  }

  private class SummarizationState extends ControllerState {
    public void back() {
      setState(activitiesState);
      pv.showActivities();
    }

    public void store() {
      pm.store();
      pv.showStored();
    }
  }
}