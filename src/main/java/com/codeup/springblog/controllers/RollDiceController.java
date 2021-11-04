//package com.codeup.springblog.controllers;
//
//import com.codeup.springblog.models.Coffee;
//import com.codeup.springblog.models.Dice;
//import com.codeup.springblog.models.DiceGame;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class RollDiceController {
//
//    @GetMapping("/roll-dice")
//    public String rollOfDice(){
//        return "views-lec/dice-game";
//    }
//
//
//    @GetMapping("/roll-dice/{n}")
//    public String numberSelection(@PathVariable String n, Model model){
//
//    Dice selection1 = new Dice(n, "one");
//    Dice selection2 = new Dice(n, "two");
//    Dice selection3 = new Dice(n, "three");
//    Dice selection4 = new Dice(n, "four");
//    Dice selection5 = new Dice(n, "five");
//    Dice selection6 = new Dice(n, "six");
//
//
//        if(n.equals("one")){
//        selection1.setOne("one");
//    }else if(n.equals("two")){
//        selection2.setTwo("two");
//     }else if(n.equals("three")){
//         selection3.setThree("three");
//     }else if(n.equals("four")){
//         selection4.setFour("four");
//     }else if(n.equals("five")){
//         selection5.setFive("five");
//     } else{
//             selection6.setSix("six");
//    }
//    List<Dice> selections = new ArrayList<>();
//
//        selections.add(selection1);
//        selections.add(selection2);
//        selections.add(selection3);
//        selections.add(selection4);
//        selections.add(selection5);
//        selections.add(selection6);
//
//        model.addAttribute("selections", selections);
//
//        return "views-lec/dice-game";
//    }
//
//
//
//}
