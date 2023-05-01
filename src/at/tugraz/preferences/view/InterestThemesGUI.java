package at.tugraz.preferences.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterestThemesGUI {
  private JComboBox cbAdventure;
  private JComboBox cbCulture;
  private JComboBox cbSports;
  private JButton nextButton;
  private JPanel panel;
  public int getAdventureValue() {
    return Integer.parseInt(cbAdventure.getSelectedItem().toString());
  }
  public int getCultureValue() {
    return Integer.parseInt(cbCulture.getSelectedItem().toString());
  }
  public int getSportsValue() {
    return Integer.parseInt(cbSports.getSelectedItem().toString());
  }
  public JPanel getPanel() {
    return panel;
  }
  public interface NextButtonClickListener {
    void onNextButtonClicked();
  }
  private NextButtonClickListener nextButtonClickListener;
  public InterestThemesGUI() {
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nextButtonClickListener != null) {
          nextButtonClickListener.onNextButtonClicked();
        }
      }
    });
  }
  public void setNextButtonClickListener(NextButtonClickListener listener) {
    this.nextButtonClickListener = listener;
  }
}
