package hopital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.repository.ICompteRepository;
import hopital.repository.IPatientRepository;
import hopital.repository.IVisiteRepository;
import hopital.service.FileAttenteService;

@SpringBootTest
class HopitalBootApplicationTests {

	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IPatientRepository patientRepository;
	@Autowired
	private IVisiteRepository visiteRepository;
	@Autowired
	private FileAttenteService fileAttente;

	@Test
	void contextLoads() {
		Medecin medecin1 = new Medecin("docBrown@gmail.Com", "doloreane");

		medecin1 = this.compteRepository.save(medecin1);
		Patient patient1 = new Patient("masha@gmail.Com", "mashmoush");
        patient1 = this.patientRepository.save(patient1);
	}

}
