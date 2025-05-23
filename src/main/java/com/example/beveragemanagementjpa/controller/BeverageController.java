package com.example.beveragemanagementjpa.controller;

import com.example.beveragemanagementjpa.model.Beverage;
import com.example.beveragemanagementjpa.service.IBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/beverages")
public class BeverageController {
    @Autowired
    private IBeverageService beverageService;

    @GetMapping("")
    public String index(Model model) {
        List<Beverage> beverageList = beverageService.findAll();
        model.addAttribute("beverages", beverageList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("beverages", new Beverage());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Beverage beverage) {
        beverageService.save(beverage);
        return "redirect:/beverages";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("beverages", beverageService.findById(id));
        return "/edit";
    }

    @PostMapping("/updade")
    public String update(Beverage beverage) {
        beverageService.save(beverage);
        return "redirect:/beverages";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model){
        model.addAttribute("beverages", beverageService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Beverage beverage){
        beverageService.remove(beverage.getId());
        return "redirect:/beverages";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id,Model model){
        model.addAttribute("beverage", beverageService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String searchBeverages(@RequestParam("keyword") String keyword, Model model) {
        List<Beverage> beverages = beverageService.searchByName(keyword);
        model.addAttribute("beverages" , beverages);
        model.addAttribute("keyword",keyword);
        return "/index";
    }
}