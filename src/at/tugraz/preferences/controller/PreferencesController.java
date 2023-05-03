package at.tugraz.preferences.controller;

import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.*;

import java.awt.event.ActionEvent;

public class PreferencesController {

  private final PreferencesModel pm;
  private final PreferencesView pv;

  private final InterestThemesState interestThemesState = new InterestThemesState();
  private final ActivitiesState activitiesState = new ActivitiesState();
  private final SummarizationState summarizationState = new SummarizationState();
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
      public void onNextButtonClicked(ActionEvent e, InterestThemesPanelDataDTO dto) {
        PreferencesModelMapper.fromInterestThemesPanelDataDTO(pm, dto);

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
      public void onNextButtonClicked(ActionEvent e, ActivitiesPanelDataDTO dto) {
        PreferencesModelMapper.fromActivitiesPanelDataDTO(pm, dto);

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
      case "Next" -> state.next();
      case "Back" -> state.back();
      case "Store" -> state.store();
      default -> {
      }
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
      SummarizationPanelDataDTO dto = PreferencesModelMapper.toSummarizationPanelDataDTO(pm);

      pv.showSummarization(dto);
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