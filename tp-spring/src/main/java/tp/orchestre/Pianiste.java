package tp.orchestre;

public class Pianiste implements IMusicien {
	private IInstrument instrument;

	public Pianiste() {
		super();
	}

	public Pianiste(IInstrument instrument) {
		super();
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("Le pianiste joue : " + this.instrument.toString());
	}

}
