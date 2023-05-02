package at.tugraz.preferences.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummarizationPanel {

  public void setAdventureValue(Integer adventureValue_) {
    adventureValue.setText(adventureValue_.toString());
  }
  public void setCultureValue(Integer cultureValue_) {
    cultureValue.setText(cultureValue_.toString());
  }
  public void setSportsValue(Integer sportsValue_) {
    sportsValue.setText(sportsValue_.toString());
  }
  public void setSaunaValue(Integer saunaValue_) {
    saunaValue.setText(saunaValue_.toString());
  }
  public void setTennisValue(Integer tennisValue_) {
    tennisValue.setText(tennisValue_.toString());
  }
  public void setGymValue(Integer gymValue_) {
    gymValue.setText(gymValue_.toString());
  }
  public JPanel getPanel() {
    return panel;
  }
  public interface BackButtonClickListener {
    void onBackButtonClicked();
  }
  public interface StoreButtonClickListener {
    void onStoreButtonClicked();
  }
  public SummarizationView() {
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (backButtonClickListener != null) {
          backButtonClickListener.onBackButtonClicked();
        }
      }
    });
    storeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (storeButtonClickListener != null) {
          storeButtonClickListener.onStoreButtonClicked();
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
