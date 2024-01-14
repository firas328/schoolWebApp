package com.springHandOn.schoolWebApp.Controller;
import com.springHandOn.schoolWebApp.model.Holiday;
import com.springHandOn.schoolWebApp.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HolidaysController {
    @Autowired
    private HolidayRepository holidayRepository;
    @GetMapping("/holidays")
    public String displayHolidays(Model model,@RequestParam(required = false) boolean festival ,
                                  @RequestParam(required = false) boolean federal) {
        model.addAttribute("festival",festival);
        model.addAttribute("federal",federal);
        List<Holiday> holidays = holidayRepository.getHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
    @GetMapping("/holidays/{path}")
    public String displayHolidays(Model model, @PathVariable String path) {
        switch (path) {
            case "all" -> {
                model.addAttribute("festival", true);
                model.addAttribute("federal", true);
            }
            case "federal" -> model.addAttribute("federal", true);
            case "festival" -> model.addAttribute("festival", true);
        }
        List<Holiday> holidays = holidayRepository.getHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
