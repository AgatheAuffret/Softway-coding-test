package softway.autodiag.autodiag.messages;

import java.util.List;

import softway.autodiag.autodiag.enums.MedicalUnitEnum;
import softway.autodiag.autodiag.model.MedicalUnitLabel;

public class MedicalUnitMessages {

        private static final List<MedicalUnitLabel> MED_UNIT_FR = List.of(
                        new MedicalUnitLabel(MedicalUnitEnum.CARDIO, "Cardiologie"),
                        new MedicalUnitLabel(MedicalUnitEnum.TRAUMA, "Traumatologie"));

        private static final List<MedicalUnitLabel> MED_UNIT_EN = List.of(
                        new MedicalUnitLabel(MedicalUnitEnum.CARDIO, "Cardiology"),
                        new MedicalUnitLabel(MedicalUnitEnum.TRAUMA, "Trauma"));

        public static final List<List<MedicalUnitLabel>> MED_UNIT = List.of(MED_UNIT_FR, MED_UNIT_EN);

}
