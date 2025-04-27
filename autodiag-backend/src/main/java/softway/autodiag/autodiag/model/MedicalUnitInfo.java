package softway.autodiag.autodiag.model;

import softway.autodiag.autodiag.enums.MedicalUnitEnum;

public class MedicalUnitInfo {
    public MedicalUnitEnum medicalUnit;

    public MedicalUnitInfo() {
    }

    public MedicalUnitEnum getMedicalUnit() {
        return this.medicalUnit;
    }

    public void setMedicalUnit(MedicalUnitEnum medicalUnit) {
        this.medicalUnit = medicalUnit;
    }

    public MedicalUnitInfo(MedicalUnitEnum medicalUnit) {
        this.medicalUnit = medicalUnit;
    }

}
