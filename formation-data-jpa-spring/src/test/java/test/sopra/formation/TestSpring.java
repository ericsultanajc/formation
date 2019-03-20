package test.sopra.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.dao.IClientDao;
import sopra.formation.model.Client;
import sopra.formation.model.StatutJuridique;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		IClientDao clientDao = context.getBean(IClientDao.class);
		
		Client sopraSteria = new Client("32682006500083", "SOPRA STERIA GROUP", StatutJuridique.SA);

		sopraSteria = clientDao.save(sopraSteria);

	}
}
