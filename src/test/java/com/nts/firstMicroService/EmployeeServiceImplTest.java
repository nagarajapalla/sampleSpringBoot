package com.nts.firstMicroService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.nts.firstMicroService.entity.Employee;
import com.nts.firstMicroService.entity.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

	@Before
	public void setUp() {
		Employee alex = new Employee("alex");

		Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
	}

//	@TestConfiguration
//	static class EmployeeServiceImplTestContextConfiguration {
//
//		@Bean
//		public EmpService employeeService() {
//			return new EmpService();
//		}
//	}

	@Autowired
	private EmpService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "alex";
		Employee found = employeeService.getEmployeeByName(name);

		assertThat(found.getName()).isEqualTo(name);
	}
}
