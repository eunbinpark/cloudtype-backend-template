package comed.controller;

import comed.Service.DrugService;
import comed.Service.EfficacyService;
import comed.dto.DrugDto;
import comed.dto.EfficacyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/guests")
public class ComedController {

    @Autowired
    private DrugService drugService;
    @Autowired
    private EfficacyService efficacyService;

    @GetMapping("/drug")
    public ResponseEntity<DrugDto> searchDrugs(@RequestParam String tki, @RequestParam String drug) {
        DrugDto drugA = drugService.searchDrug(tki, drug);
        return ResponseEntity.ok(drugA);
    }

    @GetMapping("/efficacy")
    public ResponseEntity<List<EfficacyDto>> searchEfficacy(@RequestParam String tki, @RequestParam String efficacy) {
        List<EfficacyDto> drugs = efficacyService.searchEfficacy(tki, efficacy);
        return ResponseEntity.ok(drugs);
    }
}
