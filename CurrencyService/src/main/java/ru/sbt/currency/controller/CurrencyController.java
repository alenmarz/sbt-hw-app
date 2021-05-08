package ru.sbt.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbt.currency.model.db.CurrencyEntity;
import ru.sbt.currency.service.CbrCurrencyClient;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;

@Controller
public class CurrencyController {
    private final CbrCurrencyClient cbrCurrencyClient;

    CurrencyController(CbrCurrencyClient cbrCurrencyClient) {
        this.cbrCurrencyClient = cbrCurrencyClient;
    }

    @GetMapping("/currency")
    @Transactional
    public String getCurrency(Model model,
                              @RequestParam(value = "start_date", required = false) String startDate,
                              @RequestParam(value = "end_date", required = false) String endDate) {

        try {
            List<CurrencyEntity> currencyEntities = cbrCurrencyClient.getCurrency("", startDate, endDate);
            model.addAttribute("currency", currencyEntities);
        } catch (ParseException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "jsonTemplate";
    }
}
