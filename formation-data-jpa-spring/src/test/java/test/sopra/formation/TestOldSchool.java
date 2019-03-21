package test.sopra.formation;

import org.junit.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import sopra.formation.dao.IClientDao;
import sopra.formation.model.Client;
import sopra.formation.model.ClientId;
import sopra.formation.model.StatutJuridique;

public class TestOldSchool extends TestCase {

	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	
	public void testClient() {
		IClientDao clientDao = context.getBean(IClientDao.class);
		
		Client sopraSteria = new Client("32682006500083", "SOPRA STERIA GROUP", StatutJuridique.SA);
		sopraSteria = clientDao.save(sopraSteria);
		
		Client sopraSteriaFind = clientDao.find(new ClientId(sopraSteria.getSiret(), sopraSteria.getRaisonSociale()));
		
		Assert.assertEquals("32682006500083", sopraSteriaFind.getSiret());
		Assert.assertEquals("SOPRA STERIA GROUP", sopraSteriaFind.getRaisonSociale());
		Assert.assertEquals(StatutJuridique.SA, sopraSteriaFind.getStatutJuridique());
	}

	public void testMatiere() {
		System.out.println("testMatiere");
	}
	
	
	
	

}
