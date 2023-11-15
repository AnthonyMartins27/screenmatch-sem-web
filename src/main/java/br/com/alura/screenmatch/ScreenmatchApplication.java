package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoAPI();
		var resposta = api.obterDados("http://www.omdbapi.com/?t=friends&apikey=196fe8cd");
		System.out.println("----------------");
		System.out.println(resposta);
		System.out.println("----------------");
		ConverteDados converteDados = new ConverteDados();
		System.out.println(converteDados.obterDados(resposta, DadosSerie.class));
	}

}
