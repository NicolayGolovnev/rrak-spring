package ru.adept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.adept.entity.Plant;
import ru.adept.repo.PlantRepository;
import ru.adept.repo.PreservesNPlantsRepository;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PlantController {
    @Autowired
    PlantRepository plantRepository;

    @Autowired
    PreservesNPlantsRepository pNpRepository;

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


}
