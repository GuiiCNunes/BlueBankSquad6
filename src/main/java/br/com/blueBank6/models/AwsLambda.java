package br.com.blueBank6.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsLambda {

    public AwsLambda(int i, String string, int j, int k) {
  }
    private int id;
    private String name;
    private double price;
    private int quantity;
}
  

