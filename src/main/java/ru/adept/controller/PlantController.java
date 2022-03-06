package ru.adept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.adept.entity.Plant;
import ru.adept.entity.Preserve;
import ru.adept.repo.PlantRepository;
import ru.adept.repo.PreserveRepository;
import ru.adept.repo.PreservesNPlantsRepository;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class PlantController {
    @Autowired
    PlantRepository plantRepository;

    @Autowired
    PreservesNPlantsRepository pNpRepository;

    @Autowired
    PreserveRepository preserveRepository;

    @GetMapping(value = {"/", "/index-admin"})
    public String loadIndex(Model model, HttpServletRequest request) {
        List<Plant> plants = plantRepository.findAll();
        model.addAttribute("plants", plants);
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/"))
            return "index";
        else
            return "index-admin";
    }

    @GetMapping("/edit-herb/{id}")
    public String editHerb(@PathVariable Long id, Model model) {
        Optional<Plant> plant = plantRepository.findById(id);
        if (plant.isPresent())
            model.addAttribute("plant", plant.get());
        else
            model.addAttribute("plant", new Plant());
        model.addAttribute("herbId", id);
        List<Preserve> preserves = preserveRepository.findAll();
        model.addAttribute("preserves", preserves);
        return "edit-herb";
    }

    @DeleteMapping("/herb/{id}")
    public String deleteHerb(@PathVariable Long id) {
        plantRepository.deleteById(id);
        return "redirect:/index-admin";
    }


}
