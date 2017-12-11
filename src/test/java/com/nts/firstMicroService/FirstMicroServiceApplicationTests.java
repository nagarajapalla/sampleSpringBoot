package com.nts.firstMicroService;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nts.firstMicroService.entity.Employee;
import com.nts.firstMicroService.entity.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class FirstMicroServiceApplicationTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void whenFindByName_thenReturnEmployee() {
		// given
		Employee alex = new Employee("alex");
		entityManager.persist(alex);
		entityManager.flush();

		// when
		Employee found = employeeRepository.findByName(alex.getName());

		// then
		assertThat(found.getName()).isEqualTo(alex.getName());
	}

}
