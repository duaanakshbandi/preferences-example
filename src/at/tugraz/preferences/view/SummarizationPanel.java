package at.tugraz.preferences.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummarizationPanel {

  public void setData(SummarizationPanelDataDTO dto) {
    adventureValue.setText(String.valueOf(dto.adventure()));
    cultureValue.setText(String.valueOf(dto.culture()));
    sportsValue.setText(String.valueOf(dto.sports()));
    saunaValue.setText(String.valueOf(dto.sauna()));
    tennisValue.setText(String.valueOf(dto.tennis()));
    gymValue.setText(String.valueOf(dto.gym()));
  }

  public JPanel getPanel() {
    return panel;
  }

  public interface BackButtonClickListener {
    void onBackButtonClicked(ActionEvent e);
  }

  public interface StoreButtonClickListener {
    void onStoreButtonClicked(ActionEvent e);
  }

  public SummarizationPanel() {
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (backButtonClickListener != null) {
          backButtonClickListener.onBackButtonClicked(e);
        }
      }
    });
    storeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (storeButtonClickListener != null) {
          storeButtonClickListener.onStoreButtonClicked(e);
        }
      }
    });
  }

  public void setBackButtonClickListener(BackButtonClickListener listener) {
    this.backButtonClickListener = listener;
  }

  public void setStoreButtonClickListener(StoreButtonClickListener listener) {
    this.storeButtonClickListener = listener;
  }

  private JLabel adventureValue;
  private JLabel cultureValue;
  private JLabel sportsValue;
  private JLabel saunaValue;
  private JLabel tennisValue;
  private JLabel gymValue;
  private JButton backButton;
  private JButton storeButton;
  private JPanel panel;
  private BackButtonClickListener backButtonClickListener;
  private StoreButtonClickListener storeButtonClickListener;
}
