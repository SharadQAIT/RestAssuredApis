package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

/*
 * This is fake data generator 
 * 
 */

public class FakeDataGenerator {

	@Test
	void testGenerateDummyData() {
		Faker fake = new Faker();
		String fullname = fake.name().fullName();
		String firstname = fake.name().firstName();
		String lastname = fake.name().lastName();
		String bloodGroup = fake.name().bloodGroup();
		String buildingNumber = fake.address().buildingNumber();
		String animal = fake.animal().name();
		String creditCardNumber = fake.business().creditCardNumber();

		System.out.println(fake);
		System.out.println(fullname);
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(bloodGroup);
		System.out.println(buildingNumber);
		System.out.println(animal);
		System.out.println(creditCardNumber);
	}

}
