package poudlard.model;

import javax.persistence.Embeddable;

@Embeddable
public class Stats {

	private Integer attaque;
	private Integer defense;

	public Stats() {
	}

	public Stats(Integer attaque, Integer defense) {
		this.attaque = attaque;
		this.defense = defense;
	}

	public Integer getAttaque() {
		return attaque;
	}

	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	@Override
	public String toString() {
		return "Stats [attaque=" + attaque + ", defense=" + defense + "]";
	}

}
