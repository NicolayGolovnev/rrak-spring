package ru.adept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.adept.entity.Plant;
import ru.adept.entity.PreservesAndPlant;
import ru.adept.repo.PlantRepository;
import ru.adept.repo.PreservesNPlantsRepository;

import java.util.List;

@Controller
public class PlantController {
    @Autowired
    PlantRepository plantRepository;

    @Autowired
    PreservesNPlantsRepository pNpRepository;

    @GetMapping("/")
    public String loadIndex(Model model) {
        List<Plant> plants = plantRepository.findAll();
        model.addAttribute("plants", plants);
        return "index";
    }
}
