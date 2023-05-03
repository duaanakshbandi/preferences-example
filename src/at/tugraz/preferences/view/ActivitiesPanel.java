package at.tugraz.preferences.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivitiesPanel {

  public JPanel getPanel() {
    return panel;
  }

  public interface BackButtonClickListener {
    void onBackButtonClicked(ActionEvent e);
  }

  public interface NextButtonClickListener {
    void onNextButtonClicked(ActionEvent e, ActivitiesPanelDataDTO dto);
  }

  public ActivitiesPanel() {
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (backButtonClickListener != null) {
          backButtonClickListener.onBackButtonClicked(e);
        }
      }
    });
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nextButtonClickListener != null) {
          ActivitiesPanelDataDTO dto = new ActivitiesPanelDataDTO(
                  Integer.parseInt(cbSauna.getSelectedItem().toString()),
                  Integer.parseInt(cbTennis.getSelectedItem().toString()),
                  Integer.parseInt(cbGym.getSelectedItem().toString())
          );

          nextButtonClickListener.onNextButtonClicked(e, dto);
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

  private JComboBox cbSauna;
  private JComboBox cbTennis;
  private JComboBox cbGym;
  private JButton backButton;
  private JButton nextButton;
  private JPanel panel;
  private BackButtonClickListener backButtonClickListener;
  private NextButtonClickListener nextButtonClickListener;
}
