package hopital.service;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Service;

import hopital.model.Patient;

@Service
public class FileAttenteService {
	private final Queue<Patient> fileAttente = new LinkedList<>();

	public void addPatient(Patient patient) {
		this.fileAttente.add(patient);
	}

	public Patient peekPatient() {
		return this.fileAttente.peek();
	}

	public Patient pollPatient() {
		return this.fileAttente.poll();
	}

	public void removeHeadPatient() {
		this.fileAttente.remove();
	}

	public void removePatient(Patient patient) {
		this.fileAttente.remove(patient);
	}

	public Queue<Patient> getFileAttente() {
		return fileAttente;
	}

}
