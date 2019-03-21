package test.sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.dao.IClientDao;
import sopra.formation.model.Client;
import sopra.formation.model.ClientId;
import sopra.formation.model.StatutJuridique;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class TestNewAgeWithSpring {
	@Autowired
	private IClientDao clientDao;
	
	@Test
	public void client() {
		Client sopraSteria = new Client("32682006500083", "SOPRA STERIA GROUP", StatutJuridique.SA);
		sopraSteria = clientDao.save(sopraSteria);

		Client sopraSteriaFind = clientDao.find(new ClientId(sopraSteria.getSiret(), sopraSteria.getRaisonSociale()));

		Assert.assertEquals("32682006500083", sopraSteriaFind.getSiret());
		Assert.assertEquals("SOPRA STERIA GROUP", sopraSteriaFind.getRaisonSociale());
		Assert.assertEquals(StatutJuridique.SA, sopraSteriaFind.getStatutJuridique());
	}
	
	@Test
	public void matiere() {
		
	}
}
