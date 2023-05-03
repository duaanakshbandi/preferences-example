package at.tugraz.preferences.controller;

import at.tugraz.preferences.model.PreferencesModel;
import at.tugraz.preferences.view.ActivitiesPanelDataDTO;
import at.tugraz.preferences.view.InterestThemesPanelDataDTO;
import at.tugraz.preferences.view.SummarizationPanelDataDTO;

public class PreferencesModelMapper {
    public static ActivitiesPanelDataDTO toActivitiesPanelDataDTO(PreferencesModel pm) {
        return new ActivitiesPanelDataDTO(pm.getSauna(), pm.getTennis(), pm.getGym());
    }

    public static InterestThemesPanelDataDTO toInterestThemesPanelDataDTO(PreferencesModel pm) {
        return new InterestThemesPanelDataDTO(pm.getAdventure(), pm.getCulture(), pm.getSports());
    }

    public static SummarizationPanelDataDTO toSummarizationPanelDataDTO(PreferencesModel pm) {
        return new SummarizationPanelDataDTO(pm.getAdventure(), pm.getCulture(), pm.getSports(), pm.getSauna(), pm.getTennis(), pm.getGym());
    }

    public static void fromActivitiesPanelDataDTO(PreferencesModel pm, ActivitiesPanelDataDTO dto) {
        pm.setSauna(dto.sauna());
        pm.setTennis(dto.tennis());
        pm.setGym(dto.gym());
    }

    public static void fromInterestThemesPanelDataDTO(PreferencesModel pm, InterestThemesPanelDataDTO dto) {
        pm.setAdventure(dto.adventure());
        pm.setCulture(dto.culture());
        pm.setSports(dto.sports());
    }

    public static void fromSummarizationPanelDataDTO(PreferencesModel pm, SummarizationPanelDataDTO dto) {
        pm.setAdventure(dto.adventure());
        pm.setCulture(dto.culture());
        pm.setSports(dto.sports());
        pm.setSauna(dto.sauna());
        pm.setTennis(dto.tennis());
        pm.setGym(dto.gym());
    }
}
