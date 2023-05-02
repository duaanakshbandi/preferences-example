package at.tugraz.preferences.model;

public class PreferencesModel {

  private int adventure;
  private int culture;
  private int sports;
  private int sauna;
  private int tennis;
  private int gym;

  public void store() {
  }

  public int getAdventure() {
    return adventure;
  }

  public void setAdventure(int adventure) {
    this.adventure = adventure;
  }

  public int getCulture() {
    return culture;
  }

  public void setCulture(int culture) {
    this.culture = culture;
  }

  public int getSports() {
    return sports;
  }

  public void setSports(int sports) {
    this.sports = sports;
  }

  public int getSauna() {
    return sauna;
  }

  public void setSauna(int sauna) {
    this.sauna = sauna;
  }

  public int getTennis() {
    return tennis;
  }

  public void setTennis(int tennis) {
    this.tennis = tennis;
  }

  public int getGym() {
    return gym;
  }

  public void setGym(int gym) {
    this.gym = gym;
  }
}