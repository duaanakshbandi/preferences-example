package at.tugraz.preferences.view;

import javax.swing.*;

public class PreferencesView extends JFrame {

  private final InterestThemesPanel interestThemesPanel = new InterestThemesPanel();
  private final ActivitiesPanel activitiesPanel = new ActivitiesPanel();
  private final SummarizationPanel summarizationPanel = new SummarizationPanel();

  public PreferencesView() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(450, 300);
  }

  public InterestThemesPanel getInterestThemesPanel() {
    return interestThemesPanel;
  }

  public ActivitiesPanel getActivitiesPanel() {
    return activitiesPanel;
  }

  public SummarizationPanel getSummarizationPanel() {
    return summarizationPanel;
  }

  public void showInterestThemes() {
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
