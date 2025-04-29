package softway.autodiag.autodiag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import softway.autodiag.autodiag.Config;
import softway.autodiag.autodiag.model.MedicalUnitEnum;
import softway.autodiag.autodiag.ressources.RessourceErrorMessages;
import softway.autodiag.autodiag.ressources.RessourceMessages;
import softway.autodiag.autodiag.model.ErrorEnum;
import softway.autodiag.autodiag.model.MedicalUnit;

@Service
public class MedicalUnitService {
    private final RessourceMessages messages = new RessourceMessages(Config.LANGUAGE);
    private final RessourceErrorMessages errorsMessages = new RessourceErrorMessages(Config.LANGUAGE);

    /**
     * Give the medical unit associated to the healthindex
     * 
     * A score multiple of 3 indicates the cardiology unit.
     * A score multiple of 5 indicates the trauma unit.
     * A score multiple of 3 and 5 indicates both units.
     * 
     * @param healthIndex health index
     * @return medical unit
     */
    public String getMedicalUnitByHealthIndex(String healthIndex) {
        try {
            int index = Integer.parseInt(healthIndex);

            // Give the service list by a medical unit
            List<MedicalUnit> medicalUnitList = getMedicalUnitList(index);

            // Final string to send
            return displayMedicalUnit(medicalUnitList);
        } catch (NumberFormatException e) {
            // Invalid format
            return errorsMessages.getString(ErrorEnum.INVALID_FORMAT);
        }
    }

    /**
     * ALGORYTHM GESTION
     * 
     * Data processing, returns a list of medical units based on the health index
     * passed
     * as a parameter.
     * 
     * @param healthIndex
     * @return List of medical units
     */
    private List<MedicalUnit> getMedicalUnitList(int healthIndex) {
        List<MedicalUnit> medicalUnitList = new ArrayList<>();

        // Cardiology
        if (healthIndex % 3 == 0) {
            MedicalUnit medicalUnitInfo = new MedicalUnit(null);
            medicalUnitInfo.setMedicalUnit(MedicalUnitEnum.CARDIO);
            medicalUnitList.add(medicalUnitInfo);
        }

        // Trauma
        if (healthIndex % 5 == 0) {
            MedicalUnit medicalUnitInfo = new MedicalUnit(null);
            medicalUnitInfo.setMedicalUnit(MedicalUnitEnum.TRAUMA);
            medicalUnitList.add(medicalUnitInfo);
        }

        return medicalUnitList;
    }

    /**
     * DISPLAY GESTION
     * 
     * Transform the list of string in a String
     * 
     * @param medicalUnitList
     * @return
     */
    private String displayMedicalUnit(List<MedicalUnit> medicalUnitList) {
        String text = "";
        int length = medicalUnitList.size();

        if (medicalUnitList == null || medicalUnitList.size() == 0) {
            return errorsMessages.getString(ErrorEnum.NO_MEDICAL_UNIT);
        }

        for (int i = 0; i < length; i++) {
            MedicalUnit unit = medicalUnitList.get(i);
            if (unit.getMedicalUnit() == MedicalUnitEnum.CARDIO) {
                text += messages.getString(MedicalUnitEnum.CARDIO);
            } else if (unit.getMedicalUnit() == MedicalUnitEnum.TRAUMA) {
                text += messages.getString(MedicalUnitEnum.TRAUMA);
            }
            if (i < length - 1) {
                text += ", ";
            }
        }
        return text;
    }
}
