package org.example.mongodbdemo;

import org.example.mongodbdemo.model.Address;
import org.example.mongodbdemo.model.Gender;
import org.example.mongodbdemo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class  MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
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
			if (repository.findStudentByEmail(student.getEmail()).isEmpty())
				repository.insert(student);
		};
	}
}
