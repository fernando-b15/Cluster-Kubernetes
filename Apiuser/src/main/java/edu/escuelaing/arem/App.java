package edu.escuelaing.arem;




/**
 * Hello world!
 * 
 * 
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan("edu.escuelaing.arem")
@EntityScan("edu.escuelaing.arem.entities")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }


}
