package hopital.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VisiteDTO {
		private double prix = 20;
		private Integer idVisite;
		private int salle;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private LocalDate dateVisite;
		private String loginMedecin;
		private Integer identifiantMedecin;
		
		public VisiteDTO() {
			// TODO Auto-generated constructor stub
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public Integer getIdVisite() {
			return idVisite;
		}

		public void setIdVisite(Integer idVisite) {
			this.idVisite = idVisite;
		}

		public int getSalle() {
			return salle;
		}

		public void setSalle(int salle) {
			this.salle = salle;
		}

		public LocalDate getDateVisite() {
			return dateVisite;
		}

		public void setDateVisite(LocalDate dateVisite) {
			this.dateVisite = dateVisite;
		}

		public String getLoginMedecin() {
			return loginMedecin;
		}

		public void setLoginMedecin(String loginMedecin) {
			this.loginMedecin = loginMedecin;
		}

		public Integer getIdentifiantMedecin() {
			return identifiantMedecin;
		}

		public void setIdentifiantMedecin(Integer identifiantMedecin) {
			this.identifiantMedecin = identifiantMedecin;
		}

		
	}

