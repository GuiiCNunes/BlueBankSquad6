package br.com.blueBank6.repository;

import br.com.blueBank6.models.AwsLambda;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class AwsLambdaRepository {  

    public List<AwsLambda> buildLambdas(){
        return Stream.of(
                new AwsLambda(101, "Mobile", 20000, 1),
                new AwsLambda(102, "Book", 999, 2),
                new AwsLambda(278, "Book", 1466, 3),
                new AwsLambda(953, "Jeans", 4499, 1)
        ).collect(Collectors.toList());
    }
}
