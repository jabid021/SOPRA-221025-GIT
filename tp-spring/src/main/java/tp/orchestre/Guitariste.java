package tp.orchestre;

public class Guitariste implements IMusicien {
	private IInstrument instrument;

	public Guitariste() {
		super();
	}

	public Guitariste(IInstrument instrument) {
		super();
		this.instrument = instrument;
	}

	public IInstrument getInstrument() {
		return instrument;
	}

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("Le guitariste joue : " + this.instrument.toString());
		throw new RuntimeException("Fausse note");
	}

}
