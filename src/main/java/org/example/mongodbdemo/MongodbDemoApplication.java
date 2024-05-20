package org.example.mongodbdemo;

import com.mongodb.client.model.CreateCollectionOptions;
import lombok.extern.slf4j.Slf4j;
import org.example.mongodbdemo.model.Address;
import org.example.mongodbdemo.model.Gender;
import org.example.mongodbdemo.model.Student;
import org.example.mongodbdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class  MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoOperations mongoOperations) {


		// Create capped collection for logs
		mongoOperations.createCollection(
				"StudentLogs",
				CollectionOptions.empty().capped().size(1024).maxDocuments(5)
		);

		return args -> {
			Student student = new Student(
					"Jamila",
					"Ahmed",
					"jahmed@gmail.com",
					Gender.FEMALE,
					new Address("England", "London", "NE9"),
					List.of("subject1", "subject2"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			repository.findStudentByEmail(student.getEmail()).ifPresentOrElse(
					student1 -> log.info("Student with email {} already exists", student.getEmail()),
					() -> {
						log.info("Inserting student {}", student);
						repository.insert(student);
					}
			);
		};
	}
}
