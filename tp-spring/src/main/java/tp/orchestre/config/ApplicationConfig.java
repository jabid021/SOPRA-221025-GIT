package tp.orchestre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import tp.orchestre.Guitare;
import tp.orchestre.Guitariste;
import tp.orchestre.IInstrument;
import tp.orchestre.IMusicien;
import tp.orchestre.Pianiste;
import tp.orchestre.Piano;
import tp.orchestre.Synthe;
import tp.orchestre.Ukulele;

@Configuration
@ComponentScan("tp.orchestre")
public class ApplicationConfig {

	@Bean
	public IInstrument guitare() {
		return new Guitare();
	}
	
	@Bean
	public IInstrument ukulele() {
		return new Ukulele();
	}
	
	@Bean
	public IMusicien guitariste(Guitare guitare) {
		Guitariste guitariste = new Guitariste();
		guitariste.setInstrument(guitare);
		
		return guitariste;
	}
	
	@Bean
	public IInstrument piano() {
		return new Piano();
	}
	
	@Bean
	public IMusicien pianiste(Synthe synthe) {
		return new Pianiste(synthe);
	}
	
}
