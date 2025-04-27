package softway.autodiag.autodiag.controller;

import org.springframework.web.bind.annotation.RestController;

import softway.autodiag.autodiag.service.MedicalUnitService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "api")
public class MedicalUnitController {

    private MedicalUnitService medicalUnitService;

    public MedicalUnitController(MedicalUnitService medicalUnitService) {
        this.medicalUnitService = medicalUnitService;
    }

    /**
     * Return the medical unit associated to the health index parameter
     */
    @GetMapping("/service")
    public String getServiceByMedicalUnit(@RequestParam String healthIndex) {
        return this.medicalUnitService.getMedicalUnitByHealthIndex(healthIndex);
    }
}
