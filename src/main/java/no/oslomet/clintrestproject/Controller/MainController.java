package no.oslomet.clintrestproject.Controller;

import no.oslomet.clintrestproject.Bulding;
import no.oslomet.clintrestproject.service.BuldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private BuldingService buldingService;
    @GetMapping("/")
    public String home(Model model){
        Bulding bulding = new Bulding();
        List<Bulding> buldingList = buldingService.getAllBulding();
        model.addAttribute("building", bulding);
        model.addAttribute("buildings", buldingList);
        return  "index";

    }

    @PostMapping("/saveBuilding")
    public String saveBulding(@ModelAttribute("building") Bulding Bulding){
        System.out.println("building to save: " + Bulding);
        buldingService.saveBuilding(Bulding);
        return "redirect:/";
    }

    @GetMapping("/editBulding")
    public String updateBulding(@PathVariable long id, Model model){
        model.addAttribute("bulding",
        buldingService.getBuildingById(id));
        model.addAttribute("buldings", buldingService.getAllBulding());
        return "redirect/";
    }
}

