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
    setContentPane(interestThemesPanel.getPanel());
    setVisible(true);
  }

  public void showActivities() {
    setTitle("Preference Elicitation: Activities");
    setContentPane(activitiesPanel.getPanel());
    setVisible(true);
  }

  public void showSummarization() {
    setTitle("Preference Elicitation: Summary");
    setContentPane(summarizationPanel.getPanel());
    setVisible(true);
  }

  public void showStored() {
    JOptionPane.showMessageDialog(this, "Preferences stored!");
  }
}
