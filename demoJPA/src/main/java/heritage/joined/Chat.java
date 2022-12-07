package heritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cat")
@PrimaryKeyJoinColumn(name = "id_chat")
public class Chat extends Animal {

	private int viesRestantes;
	
	@Column(nullable=false)
	private String robe;
	
	public Chat() {
	}

	public Chat(String nom, String espece, int viesRestantes, String robe) {
		super(nom, espece);
		this.viesRestantes = viesRestantes;
		this.robe = robe;
	}

	public int getViesRestantes() {
		return viesRestantes;
	}

	public void setViesRestantes(int viesRestantes) {
		this.viesRestantes = viesRestantes;
	}

	public String getRobe() {
		return robe;
	}

	public void setRobe(String robe) {
		this.robe = robe;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", nom=" + nom + ", espece=" + espece + ", viesRestantes=" + viesRestantes + ", robe="
				+ robe + "]";
	}
	
	
	
	
	
	
}
