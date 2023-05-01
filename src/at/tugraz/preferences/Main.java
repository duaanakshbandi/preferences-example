import at.tugraz.preferences.controller.PreferencesController;
import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.PreferencesView;

public class Main {
  public static void main( String [] args) {

    PreferencesModel preferencesmodel = new PreferencesModel();
    PreferencesView preferencesview = new PreferencesView();
    PreferencesController preferencescontroller = new PreferencesController(preferencesmodel, preferencesview);

    preferencesview.setController(preferencescontroller);
    preferencesview.setModel(preferencesmodel);
    preferencescontroller.init();
  }
}
