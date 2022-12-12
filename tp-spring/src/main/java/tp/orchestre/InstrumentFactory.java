package tp.orchestre;

public class InstrumentFactory {
	public static IInstrument getInstrument() {
		return new Piano();
	}
}
