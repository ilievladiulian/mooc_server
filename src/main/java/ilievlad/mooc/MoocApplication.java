package ilievlad.mooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by Vlad on 18/06/2017.
 */
@SpringBootApplication
@EntityScan
public class MoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoocApplication.class, args);
    }

}