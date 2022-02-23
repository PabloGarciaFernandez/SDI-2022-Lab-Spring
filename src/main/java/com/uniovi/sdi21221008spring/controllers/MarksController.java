package com.uniovi.sdi21221008spring.controllers;

import com.uniovi.sdi21221008spring.entities.Mark;
import com.uniovi.sdi21221008spring.services.MarksService;
import com.uniovi.sdi21221008spring.services.UsersService;
import com.uniovi.sdi21221008spring.validators.NotasFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MarksController {
    @Autowired //Inyectar el servicio
    private MarksService marksService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private NotasFormValidator notasFormValidator;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@Validated Mark mark, BindingResult result, Model model) {
        model.addAttribute("usersList", usersService.getUsers());
        notasFormValidator.validate(mark,result);
        if(result.hasErrors()){
            return"mark/add";
        }

        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.GET)
    public String getMark(Model model) {
        model.addAttribute("mark", new Mark());
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/add";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.GET)
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@Validated Mark mark, @PathVariable Long id, BindingResult result) {
        notasFormValidator.validate(mark, result);
        if(result.hasErrors())
            return "/mark/edit";

        Mark originalMark = marksService.getMark(id);
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/" + id;
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list::tableMarks";
    }
}
