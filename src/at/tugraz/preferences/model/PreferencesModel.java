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
    return Adventure;
  }

  public void setAdventure(int adventure) {
    Adventure = adventure;
  }

  public int getCulture() {
    return Culture;
  }

  public void setCulture(int culture) {
    Culture = culture;
  }

  public int getSports() {
    return Sports;
  }

  public void setSports(int sports) {
    Sports = sports;
  }

  public int getSauna() {
    return Sauna;
  }

  public void setSauna(int sauna) {
    Sauna = sauna;
  }

  public int getTennis() {
    return Tennis;
  }

  public void setTennis(int tennis) {
    Tennis = tennis;
  }

  public int getGym() {
    return Gym;
  }

  public void setGym(int gym) {
    Gym = gym;
  }
  private int Adventure;
  private int Culture;
  private int Sports;
  private int Sauna;
  private int Tennis ;
  private int Gym;
}