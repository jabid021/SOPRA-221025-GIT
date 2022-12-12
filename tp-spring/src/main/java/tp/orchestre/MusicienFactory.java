package tp.orchestre;

public class MusicienFactory {
	public static IMusicien getMusicien() {
		return new Pianiste(InstrumentFactory.getInstrument());
	}
}
