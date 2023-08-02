package com.example.tacocloud.controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

import com.example.tacocloud.model.IngredientDomain;
import com.example.tacocloud.model.IngredientDomain.Type;
import com.example.tacocloud.model.TacoDomain;
import com.example.tacocloud.model.TacoOrderDomain;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    
    
    @ModelAttribute
    public void addIngredients(Model model) {
        
        List<IngredientDomain> ingredients = Arrays.asList(

        new IngredientDomain("FLTO", "Flour Tortilla", Type.WRAP),
        new IngredientDomain("COTO", "Corn Tortilla", Type.WRAP),
        new IngredientDomain("GRBF", "Ground Beef", Type.PROTEIN),
        new IngredientDomain("CARN", "Carnitas", Type.PROTEIN),
        new IngredientDomain("TMTO", "Diced Tomatoes", Type.VEGGIES),
        new IngredientDomain("LETC", "Lettuce", Type.VEGGIES),
        new IngredientDomain("CHED", "Cheddar", Type.CHEESE),
        new IngredientDomain("JACK", "Monterrey Jack", Type.CHEESE),
        new IngredientDomain("SLSA", "Salsa", Type.SAUCE),
        new IngredientDomain("SRCR", "Sour Cream", Type.SAUCE)
        );

        
        Type[] types = IngredientDomain.Type.values();

        for(Type type:types) {
            model.addAttribute(type.toString(), filterType(ingredients, type));
        }


    
    }   

        @ModelAttribute(name="tacoOrder")
        public TacoOrderDomain order() {
            return new TacoOrderDomain();
        }

        @ModelAttribute(name="taco")
        public TacoDomain taco(){ 
            return new TacoDomain();
        }

        @GetMapping
        public String showDesignForm(){
            return " design";
        }

        

    private Iterable<IngredientDomain> filterType(List<IngredientDomain> ingridients, Type type) {
        return ingridients
                    .stream()
                    .filter(ing -> ing.getType().equals(type))
                    .collect(Collectors.toList());
    }
    

    
}

