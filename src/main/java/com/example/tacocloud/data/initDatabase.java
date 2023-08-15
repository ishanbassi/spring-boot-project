package com.example.tacocloud.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.model.User;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.OrderRepository;
import com.example.tacocloud.repository.TacoRepository;
import com.example.tacocloud.repository.UserRepository;


@Configuration
public class InitDatabase {

  private Logger logger = LoggerFactory.getLogger(InitDatabase.class);




    
    @Bean
    public CommandLineRunner dataLoader(
        IngredientRepository repo,
        TacoRepository tacoRepo,
        UserRepository userRepo,
        OrderRepository orderRepo
        // PasswordEncoder encoder
        ) {
    return args -> {
        
    Ingredient  flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
    Ingredient  cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
    Ingredient  groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
    Ingredient  carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
    Ingredient  dicedTomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
    Ingredient  lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
    Ingredient  cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
    Ingredient  monterreyJack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
    Ingredient  salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
    Ingredient  sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);
    Ingredient  testIngredient = new Ingredient("TEST", "Sour Cream", Type.SAUCE);


         repo.save(flourTortilla);
        repo.save(cornTortilla);
        repo.save(groundBeef);
        repo.save(carnitas);
        repo.save(dicedTomatoes);
        repo.save(lettuce);
        repo.save(cheddar);
        repo.save(monterreyJack);
        repo.save(salsa);
        repo.save(sourCream);
        repo.save(testIngredient);

        Taco taco1 = new Taco();
        taco1.setName("Carnivore");
        taco1.setIngredients(Arrays.asList(
        flourTortilla, groundBeef, carnitas,
        sourCream, salsa, cheddar));
        logger.info(taco1.toString());

        Taco taco2 = new Taco();
        taco2.setName("Bovine Bounty");
        taco2.setIngredients(Arrays.asList(
        cornTortilla, groundBeef, cheddar,
        salsa, sourCream));

         tacoRepo.save(taco2);
        Taco taco3 = new Taco();
        taco3.setName("Veg-Out");
        taco3.setIngredients(Arrays.asList(
        flourTortilla, cornTortilla, dicedTomatoes,
        lettuce, salsa));
         tacoRepo.save(taco3);



        
         TacoOrder order = new TacoOrder();
         order.setDeliveryCity("Ludhiana");
         order.setDeliveryName("ISHAN BASSI");
         order.setDeliveryStreet("Haibowal");
         order.setDeliveryZip("141001");
         order.setDeliveryState("Punjab");

         orderRepo.save(order);

         
         TacoOrder order2 = new TacoOrder();
         order2.setDeliveryCity("moga");
         order2.setDeliveryName("AMAN");
         order2.setDeliveryStreet("STREET NO 9");
         order2.setDeliveryZip("141031");
         order2.setDeliveryState("Punjab");

         orderRepo.save(order2);


         
         User user1   = new User("ishan", "Ish@n20pp", "ISHAN BASSI", "HAIBOWAL", "LUDHIANA", "PUNJAB", "141001", "6239771006");

         User user2 = new User("admin", "Ish@n20pp", "ISHAN BASSI", "HAIBOWAL", "LUDHIANA", "PUNJAB", "141001", "6239771006");

         userRepo.save(user1);
         userRepo.save(user2);
        

    };

    
    }

    
}
