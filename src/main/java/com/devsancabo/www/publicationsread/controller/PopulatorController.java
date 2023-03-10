package com.devsancabo.www.publicationsread.controller;


import com.devsancabo.www.publicationsread.dto.GetPopulatorResponseDTO;
import com.devsancabo.www.publicationsread.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PopulatorController {
    private final PublicationService publicationService;

    @Autowired
    public PopulatorController(final PublicationService publicationService) {
        this.publicationService = publicationService;

    }

    @PostMapping("/populator")
    public ResponseEntity<GetPopulatorResponseDTO> populate(@RequestParam(name = "intensity") Integer intensity,
                                                            @RequestParam(name = "runForever") Boolean runForever){
        return ResponseEntity.ok(publicationService.startPopulator(intensity, runForever));
    }

    @DeleteMapping("/populator")
    public ResponseEntity<Object> stopPopulate(){
        publicationService.stopPopulators();
        return ResponseEntity.ok("Requested stopping of data Population");
    }

    @GetMapping("/populator")
    public ResponseEntity<GetPopulatorResponseDTO> getPopulator(){
        return ResponseEntity.ok(publicationService.gerPopulator());
    }
}
