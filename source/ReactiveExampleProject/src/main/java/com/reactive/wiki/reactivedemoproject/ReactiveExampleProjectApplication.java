package com.reactive.wiki.reactivedemoproject;

import com.reactive.wiki.reactivedemoproject.exemplos.ExemploBase;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@EnableAspectJAutoProxy
public class ReactiveExampleProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveExampleProjectApplication.class, args);
	}

	private final List<ExemploBase> exemplos;

	@Override
	public void run(String... args) {
		exemplos.forEach(ExemploBase::executa);
	}
}
