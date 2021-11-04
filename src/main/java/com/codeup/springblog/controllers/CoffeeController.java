package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {

    @GetMapping("/coffee")
    public String coffeeInfo(){
        return "views-lec/coffee";
    }

    @GetMapping("/coffee/{roast}")
    public String roastSelection(@PathVariable String roast, Model model){
//        block of code:A
        //was commented out to write another way, below
//        model.addAttribute("roast", roast);
//        boolean choseDark = false;
//        if(roast.equals("dark")){
//            choseDark = true;
//        }
//        model.addAttribute("choseDark", choseDark);

        Coffee selection = new Coffee(roast, "Cool beans");
        Coffee selection2 = new Coffee(roast, "Jolting Joe");
        //commented out below line for above two lines
//        selection.setRoast(roast);
        if(roast.equals("dark")){
            selection.setOrigin("Columbian");
            selection2.setOrigin("Brazil");
        }else if(roast.equals("medium")){
            selection.setOrigin("New Guinea");
            selection2.setOrigin("Sumatra");
        }else{
            selection.setOrigin("Kenya");
            selection2.setOrigin("Ethiopia");
        }
        List<Coffee> selections = new ArrayList<>();
        selections.add(selection);
        selections.add(selection2);
        model.addAttribute("selections", selections);
        //replaced with above line of code with new "selecitons"
//        model.addAttribute("selection", selection);
        model.addAttribute("roast", roast);
        return "views-lec/coffee";
    }


}
