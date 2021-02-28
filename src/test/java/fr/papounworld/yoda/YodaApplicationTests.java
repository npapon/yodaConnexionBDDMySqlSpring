package fr.papounworld.yoda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YodaApplicationTests {

	@Test
	void testSimple() {
		
		assertThat(1).isEqualTo(1);
	}

}
