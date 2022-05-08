package tr.edu.bilkent.cs.cs102.registerplusplus.server.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

//    @Bean
//    CommandLineRunner itemRepositoryInit(ItemRepository repository) {
//
//        return args -> {
//            System.out.println("Data creation started...");
//            repository.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
//            repository.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
//            repository.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
//            repository.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
//            repository.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
//            System.out.println("Data creation complete...");
//        };
//    }
//
//    @Bean
//    CommandLineRunner courseRepoInit(CourseRepository repo){
//        return args -> {
//            Course c = new Course();
//            c.setId("CS102-2");
//            c.setName("CS102");
//            c.setSection("2");
//            boolean[][] b = new boolean[9][6];
//            b[1][2] = true;
//            b[3][5] = true;
//            c.setProgram(b);
//            repo.save(c);
//        };
//    }
}
