package softway.autodiag.autodiag.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import softway.autodiag.autodiag.service.MedicalUnitService;

class MedicalUnitControllerTest {

    @Mock
    private MedicalUnitService medicalUnitService;

    @InjectMocks
    private MedicalUnitController medicalUnitController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetServiceByMedicalUnit() {
        // Act
        medicalUnitController.getServiceByMedicalUnit(anyString());

        // Assert
        verify(medicalUnitService).getMedicalUnitByHealthIndex(anyString());
    }
}