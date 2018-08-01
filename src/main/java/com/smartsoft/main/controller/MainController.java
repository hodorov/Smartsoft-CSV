package com.smartsoft.main.controller;

import com.smartsoft.main.service.CSVService;
import com.smartsoft.main.service.DBService;
import com.smartsoft.main.view.SSOIDAndFormIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class MainController {

    private DBService dbService;

    @Autowired
    public MainController(DBService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("message", "Добро пожаловать!");
        return "main";
    }

    @GetMapping("/last")
    public String last(Model model) {
        model.addAttribute("headers", new String[]{"SSOID", "ID форм(ы)"});
        model.addAttribute("colWidth", 6);
        //Date now = new Date();
        Date now = new GregorianCalendar(2017, 6, 11, 9, 0).getTime();
        Date past = new Date(now.getTime() - 3600 * 1000);

        ArrayList<SSOIDAndFormIDs> usersForms = dbService.formsByTime(past, now);
        model.addAttribute("records", usersForms.stream().map(uf -> new String[]{uf.getSsoId(), uf.formIdsToString()}).toArray());
        return "main";
    }

    @GetMapping("/loadCSV")
    public String loadCSV(Model model) {
        try {
            dbService.deleteAll();
            dbService.addAll(CSVService.parseCSVFileToRecords());
            model.addAttribute("message", "Готово");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Ошибка");
        }
        return "main";
    }
}
