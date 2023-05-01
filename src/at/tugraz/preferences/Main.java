package at.tugraz.preferences;
import at.tugraz.preferences.controller.PreferencesController;
import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.PreferencesView;

public class Main {
  public static void main( String [] args) {
    PreferencesController preferencescontroller = new PreferencesController();
    preferencescontroller.init();
  }
}
