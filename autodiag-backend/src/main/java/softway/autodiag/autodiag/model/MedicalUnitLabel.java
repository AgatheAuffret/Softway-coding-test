package softway.autodiag.autodiag.model;

import softway.autodiag.autodiag.enums.MedicalUnitEnum;

public class MedicalUnitLabel {
    public MedicalUnitEnum medicalUnit;
    public String label;

    public MedicalUnitLabel() {
    }

    public MedicalUnitLabel(MedicalUnitEnum medicalUnit, String label) {
        this.medicalUnit = medicalUnit;
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MedicalUnitEnum getMedicalUnit() {
        return this.medicalUnit;
    }

    public void setMedicalUnit(MedicalUnitEnum medicalUnit) {
        this.medicalUnit = medicalUnit;
    }

}
