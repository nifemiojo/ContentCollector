package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContentcollectorApplication {

/*    @Autowired
    IContentRepository contentRepository;

    @Autowired
    ICategoryRepository categoryRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(ContentcollectorApplication.class, args);
    }
/*
    @Bean
    CommandLineRunner runner() {

		return args -> {

            Content cn1 = new Content("Vitalik Talk", "https://www.reddit.com/r/javahelp/comments/77zjx2/why_is_spring_so_hard_to_learn_with_so_bad/");
            Content cn2 = new Content("Google", "www.google.com");

            Category ct1 = new Category("ENTERTAINMENT");
            Category ct2 = new Category("BUSINESS");
            Category ct3 = new Category("LIFESTYLE");
            Category ct4 = new Category("SPORTS");
            Category ct5 = new Category("FUNNY");

            cn1.setCategory(ct2);
            cn2.setCategory(ct3);

            contentRepository.save(cn1);
            contentRepository.save(cn2);

            categoryRepository.save(ct1);
            categoryRepository.save(ct2);
            categoryRepository.save(ct3);
            categoryRepository.save(ct4);
            categoryRepository.save(ct5);

		};
    }*/
}
