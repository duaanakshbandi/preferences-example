package at.tugraz.preferences.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActivitiesGUI {
  private JComboBox cbSauna;
  private JComboBox cbTennis;
  private JComboBox cbGym;
  private JButton backButton;
  private JButton nextButton;
  private JPanel panel;
  public int getSaunaValue() {
    return Integer.parseInt(cbSauna.getSelectedItem().toString());
  }
  public int getTennisValue() {
    return Integer.parseInt(cbTennis.getSelectedItem().toString());
  }
  public int getGymValue() {
    return Integer.parseInt(cbGym.getSelectedItem().toString());
  }
  public JPanel getPanel() {
    return panel;
  }
  public interface BackButtonClickListener {
    void onBackButtonClicked();
  }
  public interface NextButtonClickListener {
    void onNextButtonClicked();
  }
  private BackButtonClickListener backButtonClickListener;
  private NextButtonClickListener nextButtonClickListener;
  public ActivitiesGUI() {
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (backButtonClickListener != null) {
          backButtonClickListener.onBackButtonClicked();
        }
      }
    });
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nextButtonClickListener != null) {
          nextButtonClickListener.onNextButtonClicked();
        }
      }
    });
  }
  public void setBackButtonClickListener(BackButtonClickListener listener) {
    this.backButtonClickListener = listener;
  }
  public void setNextButtonClickListener(NextButtonClickListener listener) {
    this.nextButtonClickListener = listener;
  }
}
