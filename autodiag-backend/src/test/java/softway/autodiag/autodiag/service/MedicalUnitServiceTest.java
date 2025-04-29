package softway.autodiag.autodiag.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import softway.autodiag.autodiag.Config;
import softway.autodiag.autodiag.model.LanguageEnum;

public class MedicalUnitServiceTest {
    @InjectMocks
    private MedicalUnitService medicalUnitService;

    @ParameterizedTest(name = "Test with healthIndex={0} => result in french is {1}")
    @CsvSource({ "33,Cardiologie", "55,Traumatologie", "15,'Cardiologie, Traumatologie'",
            "14,L\'index de santé saisi ne possède aucune unitée médicale associée",
            "test,Le format de l\'index de santé saisi est invalide" })
    void testGetServiceByMedicalUnit_FR(String healthIndex, String result) {
        // Arrange
        Config.LANGUAGE = LanguageEnum.FR;
        MockitoAnnotations.openMocks(this);

        // Assert
        assertEquals(medicalUnitService.getMedicalUnitByHealthIndex(healthIndex), result);
    }

    @ParameterizedTest(name = "Test with healthIndex={0} => result in english is {1}")
    @CsvSource({ "33,Cardiology", "55,Trauma", "15,'Cardiology, Trauma'",
            "14,This health index has no associated medical unit",
            "test,The format of this health index is incorrect" })
    @DisplayName("Test the dispatch of medical unit(s) based on the health index in English")
    void testGetServiceByMedicalUnit_EN(String healthIndex, String result) {
        // Arrange
        Config.LANGUAGE = LanguageEnum.EN;
        MockitoAnnotations.openMocks(this);

        // Assert
        assertEquals(medicalUnitService.getMedicalUnitByHealthIndex(healthIndex), result);
    }

}
