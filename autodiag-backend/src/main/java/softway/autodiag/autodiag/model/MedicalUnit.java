package softway.autodiag.autodiag.model;

public class MedicalUnit {
    public MedicalUnitEnum medicalUnit;

    public MedicalUnitEnum getMedicalUnit() {
        return this.medicalUnit;
    }

    public void setMedicalUnit(MedicalUnitEnum medicalUnit) {
        this.medicalUnit = medicalUnit;
    }

    public MedicalUnit(MedicalUnitEnum medicalUnit) {
        this.medicalUnit = medicalUnit;
    }
}
