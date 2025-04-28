package softway.autodiag.autodiag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import softway.autodiag.autodiag.Config;
import softway.autodiag.autodiag.enums.MedicalUnitEnum;
import softway.autodiag.autodiag.messages.ErrorMessages;
import softway.autodiag.autodiag.messages.Messages;
import softway.autodiag.autodiag.model.MedicalUnitInfo;

@Service
public class MedicalUnitService {
    private final Messages messages = new Messages(Config.LANGUAGE);
    private final ErrorMessages errorsMessages = new ErrorMessages(Config.LANGUAGE);

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
            List<MedicalUnitInfo> medicalUnitList = getMedicalUnitList(index);

            // Final string to send
            return displayMedicalUnit(medicalUnitList);
        } catch (NumberFormatException e) {
            // Invalid format
            return errorsMessages.getString(1);
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
    private List<MedicalUnitInfo> getMedicalUnitList(int healthIndex) {
        List<MedicalUnitInfo> medicalUnitList = new ArrayList<>();

        // Cardiology
        if (healthIndex % 3 == 0) {
            MedicalUnitInfo medicalUnitInfo = new MedicalUnitInfo();
            medicalUnitInfo.setMedicalUnit(MedicalUnitEnum.CARDIO);
            medicalUnitList.add(medicalUnitInfo);
        }

        // Trauma
        if (healthIndex % 5 == 0) {
            MedicalUnitInfo medicalUnitInfo = new MedicalUnitInfo();
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
    private String displayMedicalUnit(List<MedicalUnitInfo> medicalUnitList) {
        String text = "";
        int length = medicalUnitList.size();

        if (medicalUnitList == null || medicalUnitList.size() == 0) {
            return errorsMessages.getString(0);
        }

        for (int i = 0; i < length; i++) {
            MedicalUnitInfo unit = medicalUnitList.get(i);
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
