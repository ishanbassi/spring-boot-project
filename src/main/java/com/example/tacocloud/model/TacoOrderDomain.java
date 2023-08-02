package com.example.tacocloud.model;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Data
public class TacoOrderDomain {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<TacoDomain> tacos = new ArrayList<>();

    public void addTaco(TacoDomain taco){
        tacos.add(taco);
    }
}
