package com.javamsdt.docker;

import com.javamsdt.docker.modal.User;
import com.javamsdt.docker.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerDemoApplication implements ApplicationRunner {

	private final UserRepository userRepository;

	public DockerDemoApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// userRepository.save(new User(1, "Ahmed Samy", "serenitydiver@hotmail.com"));
		System.out.println("User:: " + userRepository.findById(1));
	}
}
