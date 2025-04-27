package softway.autodiag.autodiag.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import softway.autodiag.autodiag.Config;
import softway.autodiag.autodiag.enums.MedicalUnitEnum;
import softway.autodiag.autodiag.messages.ErrorMessages;
import softway.autodiag.autodiag.messages.MedicalUnitMessages;
import softway.autodiag.autodiag.model.MedicalUnitInfo;
import softway.autodiag.autodiag.model.MedicalUnitLabel;

@Service
public class MedicalUnitService {
    private final List<MedicalUnitLabel> medicalUnitListMessages = MedicalUnitMessages.MED_UNIT
            .get(Config.LANGUAGE.getCode());
    private final List<String> errorsMessages = ErrorMessages.ERRORS.get(Config.LANGUAGE.getCode());

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
            return errorsMessages.get(1);
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
        boolean isMultiple3 = healthIndex % 3 == 0;
        boolean isMultiple5 = healthIndex % 5 == 0;

        // Cardiology
        if (isMultiple3) {
            MedicalUnitInfo medicalUnitInfo = new MedicalUnitInfo();
            medicalUnitInfo.setMedicalUnit(MedicalUnitEnum.CARDIO);
            medicalUnitList.add(medicalUnitInfo);
        }

        // Trauma
        if (isMultiple5) {
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
        if (medicalUnitList == null || medicalUnitList.size() == 0) {
            return errorsMessages.get(0);
        }

        List<MedicalUnitEnum> medicalUnitType = medicalUnitList.stream().map(MedicalUnitInfo::getMedicalUnit)
                .collect(Collectors.toList());

        List<String> result = medicalUnitListMessages.stream()
                .filter(message -> medicalUnitType.contains(message.getMedicalUnit())).map(MedicalUnitLabel::getLabel)
                .collect(Collectors.toList());

        return String.join(", ", result);
    }
}
