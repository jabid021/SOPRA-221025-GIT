package tp.orchestre;

import org.springframework.stereotype.Component;

@Component("piano")
public class Piano implements IInstrument {

	@Override
	public String toString() {
		return "PLINK PLINK PLINK";
	}
	
}
