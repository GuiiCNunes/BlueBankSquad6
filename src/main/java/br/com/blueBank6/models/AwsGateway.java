package br.com.blueBank6.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AwsGateway {
  
  private int id;
  private String nome;
  private double preco;
  
}
