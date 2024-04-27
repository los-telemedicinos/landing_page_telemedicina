package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("list_chronic_illness")
public class ChronicIllnessController {
    @RequestMapping("list")
    String are_you_have_asthma(){
        return "Are you have Asthma?";
    }
}
