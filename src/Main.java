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
