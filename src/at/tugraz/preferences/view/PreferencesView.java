package at.tugraz.preferences.view;
import at.tugraz.preferences.controller.PreferencesController;
import at.tugraz.preferences.model.PreferencesModel;
import javax.swing.*;
public class PreferencesView extends JFrame {
  public void init(PreferencesController preferencescontroller, PreferencesModel preferencesmodel) {
    this.preferencescontroller = preferencescontroller;
    this.preferencesmodel = preferencesmodel;
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(450, 300);
  }
  public void ShowInterestThemes() {
    interestThemesFrame.setNextButtonClickListener(new InterestThemesView.NextButtonClickListener() {
      @Override
      public void onNextButtonClicked() {
        preferencesmodel.setAdventure(interestThemesFrame.getAdventureValue());
        preferencesmodel.setCulture(interestThemesFrame.getCultureValue());
        preferencesmodel.setSports(interestThemesFrame.getSportsValue());
        preferencescontroller.advanceState("next");
      }
    });
    setTitle("Preference Elicitation: Activities");
    setContentPane(interestThemesFrame.getPanel());
    setVisible(true);
  }
  public void ShowActivities() {
    activitiesFrame.setBackButtonClickListener(new ActivitiesView.BackButtonClickListener() {
      @Override
      public void onBackButtonClicked() {
        preferencescontroller.advanceState("back");
      }
    });
    activitiesFrame.setNextButtonClickListener(new ActivitiesView.NextButtonClickListener() {
      @Override
      public void onNextButtonClicked() {
        preferencesmodel.setSauna(activitiesFrame.getSaunaValue());
        preferencesmodel.setTennis(activitiesFrame.getTennisValue());
        preferencesmodel.setGym(activitiesFrame.getGymValue());
        preferencescontroller.advanceState("next");
      }
    });
    setTitle("Preference Elicitation: Activities");
    setContentPane(activitiesFrame.getPanel());
    setVisible(true);
  }
  public void ShowSummarization() {
    summarizationFrame.setBackButtonClickListener(new SummarizationView.BackButtonClickListener() {
      @Override
      public void onBackButtonClicked() {
        preferencescontroller.advanceState("back");
      }
    });
    summarizationFrame.setStoreButtonClickListener(new SummarizationView.StoreButtonClickListener() {
      @Override
      public void onStoreButtonClicked() {
        preferencescontroller.advanceState("store");
      }
    });
    summarizationFrame.setAdventureValue(preferencesmodel.getAdventure());
    summarizationFrame.setCultureValue(preferencesmodel.getCulture());
    summarizationFrame.setSportsValue(preferencesmodel.getSports());
    summarizationFrame.setSaunaValue(preferencesmodel.getSauna());
    summarizationFrame.setTennisValue(preferencesmodel.getTennis());
    summarizationFrame.setGymValue(preferencesmodel.getGym());

    setTitle("Preference Elicitation: Summary");
    setContentPane(summarizationFrame.getPanel());
    setVisible(true);
  }
  public void ShowStored() {
    JOptionPane.showMessageDialog(null, "Preferences stored!");
  }
  private PreferencesController preferencescontroller;
  private PreferencesModel preferencesmodel;
  private InterestThemesView interestThemesFrame = new InterestThemesView();
  private ActivitiesView activitiesFrame = new ActivitiesView();
  private SummarizationView summarizationFrame = new SummarizationView();
}