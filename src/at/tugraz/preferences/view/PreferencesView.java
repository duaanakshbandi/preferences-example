package at.tugraz.preferences.view;

import at.tugraz.preferences.controller.PreferencesController;
import at.tugraz.preferences.model.PreferencesModel;

import javax.swing.*;
public class PreferencesView extends JFrame {
  public void setController(PreferencesController preferencescontroller) {
    this.preferencescontroller = preferencescontroller;
  }
  public void setModel(PreferencesModel preferencesmodel) {
    this.preferencesmodel = preferencesmodel;
  }
  public void ShowInterestThemes() {
    interestThemesFrame.setNextButtonClickListener(new InterestThemesGUI.NextButtonClickListener() {
      @Override
      public void onNextButtonClicked() {
        preferencesmodel.setAdventure(interestThemesFrame.getAdventureValue());
        preferencesmodel.setCulture(interestThemesFrame.getCultureValue());
        preferencesmodel.setSports(interestThemesFrame.getSportsValue());
        preferencescontroller.advanceState("next");
      }
    });

    setContentPane(interestThemesFrame.getPanel());
    setSize(450, 300);
    setTitle("Preference Elicitation: Activities");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }
  public void ShowActivities() {
    activitiesFrame.setBackButtonClickListener(new ActivitiesGUI.BackButtonClickListener() {
      @Override
      public void onBackButtonClicked() {
        preferencescontroller.advanceState("back");
      }
    });
    activitiesFrame.setNextButtonClickListener(new ActivitiesGUI.NextButtonClickListener() {
      @Override
      public void onNextButtonClicked() {
        preferencesmodel.setSauna(activitiesFrame.getSaunaValue());
        preferencesmodel.setTennis(activitiesFrame.getTennisValue());
        preferencesmodel.setGym(activitiesFrame.getGymValue());
        preferencescontroller.advanceState("next");
      }
    });
    setContentPane(activitiesFrame.getPanel());
    setSize(450, 300);
    setTitle("Preference Elicitation: Activities");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }
  public void ShowSummarization() {
    summarizationFrame.setBackButtonClickListener(new SummarizationGUI.BackButtonClickListener() {
      @Override
      public void onBackButtonClicked() {
        preferencescontroller.advanceState("back");
      }
    });

    summarizationFrame.setAdventureValue(preferencesmodel.getAdventure());
    summarizationFrame.setCultureValue(preferencesmodel.getCulture());
    summarizationFrame.setSportsValue(preferencesmodel.getSports());
    summarizationFrame.setSaunaValue(preferencesmodel.getSauna());
    summarizationFrame.setTennisValue(preferencesmodel.getTennis());
    summarizationFrame.setGymValue(preferencesmodel.getGym());

    setContentPane(summarizationFrame.getPanel());
    setTitle("Preference Elicitation: Summary");
    setSize(450, 300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }
  private PreferencesController preferencescontroller;
  private PreferencesModel preferencesmodel;
  private InterestThemesGUI interestThemesFrame = new InterestThemesGUI();
  private ActivitiesGUI activitiesFrame = new ActivitiesGUI();
  private SummarizationGUI summarizationFrame = new SummarizationGUI();
}
