package project1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.Person;
import com.revature.daos.PersonDaoImp;

import junit.framework.Assert;



public class PersonDAOtests {
	private static PersonDaoImp pDao = new PersonDaoImp();
	private static Person testPerson = null;
	@Test
	public void createPerson() {
		Person p = new Person();
		p.setPos_id(1);
		p.setReimb_limit(0d);
		assertTrue(pDao.createPerson(p));
	}
	
	@Test
	public void getByIdTest() {
		Integer id = 4;
		
		assertTrue(pDao.getById(4).getP_id() == id);
	}
	
	@Test
	public void getAllTest() {
		assertNotNull(pDao.getAll());
	}
	
	@Test
	public void updateTest() {
		testPerson = pDao.getById(4);
		testPerson.setFirstname("updateFirstName");
		assertTrue(pDao.update(testPerson));
		
	}
	
	@Test
	public void deleteTest() {
		Integer id = pDao.getLast().getP_id();
		assertTrue(pDao.deleteById(id));
	}
	

}
