package at.tugraz.preferences.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterestThemesPanel {

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
    void onNextButtonClicked(ActionEvent e);
  }

  public InterestThemesPanel() {
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nextButtonClickListener != null) {
          nextButtonClickListener.onNextButtonClicked(e);
        }
      }
    });
  }

  public void setNextButtonClickListener(NextButtonClickListener listener) {
    this.nextButtonClickListener = listener;
  }

  private JComboBox cbAdventure;
  private JComboBox cbCulture;
  private JComboBox cbSports;
  private JButton nextButton;
  private JPanel panel;
  private NextButtonClickListener nextButtonClickListener;
}
