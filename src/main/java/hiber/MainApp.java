package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car bmw = new Car("BMW", 2000);
      Car tesla = new Car("Tesla", 3000);
      Car benz = new Car("benz", 4000);

      User user1 = new User("name1", "lastname1", "email1");
      User user2 = new User("name2", "lastname2", "email2");
      User user3 = new User("name3", "lastname3", "email3");
      User user4 = new User("name4", "lastname4", "email4");

      user1.setCar(bmw);
      user2.setCar(benz);
      user4.setCar(tesla);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      System.out.println("User who owning this car is -> " + userService.getUserByCar("BMW", 2000));
      System.out.println("User who owning this car is -> " + userService.getUserByCar("Tesla", 3000));
      System.out.println("User who owning this car is -> " + userService.getUserByCar("Benz", 4000));

   }
}
