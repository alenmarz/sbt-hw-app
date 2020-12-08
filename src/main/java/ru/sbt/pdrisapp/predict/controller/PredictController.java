package ru.sbt.pdrisapp.predict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sbt.pdrisapp.predict.service.PredictClient;

@Controller
public class PredictController {
    private final PredictClient predictClient;

    PredictController(PredictClient predictClient) {
        this.predictClient = predictClient;
    }

    @GetMapping("/prediction")
    public String getPrediction(Model model) {
        model.addAttribute("prediction", predictClient.getPrediction());
        return "jsonTemplate";
    }
}
