package com.relacionamento03.relacionamento_entidade03;

import com.relacionamento03.relacionamento_entidade03.model.Alunos;
import com.relacionamento03.relacionamento_entidade03.model.Cursos;
import com.relacionamento03.relacionamento_entidade03.repository.AlunosRepositorio;
import com.relacionamento03.relacionamento_entidade03.repository.CursoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RelacionamentoEntidade03Application {

	public static void main(String[] args) {
		SpringApplication.run(RelacionamentoEntidade03Application.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AlunosRepositorio ar, CursoRepositorio cr) {
		return args -> {

			// Criar um aluno
			Alunos aluno = new Alunos();
			aluno.setNome("Ralf");

			// Cadastrar na tabela alunos
			ar.save(aluno);

			// Criar três cursos
			Cursos c1 = new Cursos();
			c1.setNameC("Java - Spring Boot");

			Cursos c2 = new Cursos();
			c2.setNameC("Python - Flask");

			Cursos c3 = new Cursos();
			c3.setNameC("PHP - Laravel");

			// Cadastrar os cursos na tabela cursos
			cr.saveAll(Arrays.asList(c1, c2, c3));

			// Adicionar os primeiro e o terceiro curso no aluno
			aluno.getCursos().addAll(Arrays.asList(c1, c3));

			// Atualizar a lista de cursos do aluno
			ar.save(aluno);
		};
	}

}
