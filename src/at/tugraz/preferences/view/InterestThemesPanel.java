package at.tugraz.preferences.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterestThemesPanel {

  public JPanel getPanel() {
    return panel;
  }

  public interface NextButtonClickListener {
    void onNextButtonClicked(ActionEvent e, InterestThemesPanelDataDTO dto);
  }

  public InterestThemesPanel() {
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nextButtonClickListener != null) {
          int adventure = Integer.parseInt(cbAdventure.getSelectedItem().toString());
          int culture = Integer.parseInt(cbCulture.getSelectedItem().toString());
          int sports = Integer.parseInt(cbSports.getSelectedItem().toString());

          InterestThemesPanelDataDTO dto = new InterestThemesPanelDataDTO(adventure, culture, sports);
          nextButtonClickListener.onNextButtonClicked(e, dto);
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
