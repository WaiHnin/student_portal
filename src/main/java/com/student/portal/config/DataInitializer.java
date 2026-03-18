package com.student.portal.config;

import com.student.portal.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            // Default admin user
            String adminUsername = "admin";
            String adminPassword = "admin123"; // You can change
            //Set<String> adminRoles = Set.of("ROLE_ADMIN");
            String adminRoles = "ROLE_ADMIN";

            try {
                userService.createNewUser(adminUsername, adminPassword, adminRoles);
                System.out.println("Default admin user created!");
            } catch (RuntimeException e) {
                System.out.println("Admin user already exists.");
            }
        };
    }
//    @Bean
//    CommandLineRunner initAdminUser(UserRepository userRepository,
//                                    PasswordEncoder passwordEncoder) {
//
//        return args -> {
//
//            if (userRepository.findByUsername("admin").isEmpty()) {
//
//                User admin = new User();
//                admin.setUsername("admin");
//                admin.setPassword(passwordEncoder.encode("admin123"));
//                admin.setRole("ROLE_ADMIN");
//
//                userRepository.save(admin);
//
//                System.out.println("Default admin user created.");
//            }
//        };
//    }
}
