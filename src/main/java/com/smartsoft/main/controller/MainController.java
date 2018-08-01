package com.smartsoft.main.controller;

import com.smartsoft.main.service.CSVService;
import com.smartsoft.main.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

    private DBService dbService;

    @Autowired
    public MainController(DBService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/loadCSV")
    public String loadCSV(Model model) {
        try {
            dbService.addAll(CSVService.parseCSVFileToRecords());
            model.addAttribute("message", "Готово");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Ошибка");
        }
        return "index";
    }
}
