package com.aredu.biblio.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookIdListBuilderTest {

	@Test
	void shouldGenerateIdList() {
		
		List<String> bookIds = BookIdListBuilder.builder()
		.addIsbn("1234567890")
		.addNumberOfCopies(3)
		.get();
						
		assertEquals(3, bookIds.size());
		assertEquals("12345678901", bookIds.get(0));
		
	}

	@Test
	void shouldGenerateIDand1Copy(){
		List<String> bookIds = BookIdListBuilder.builder().get();

		assertEquals(1,bookIds.size());
	}
	
	
	@Test
	void shouldGenerateIDand3Copy(){
		List<String> bookIds = BookIdListBuilder.builder().addNumberOfCopies(3).get();

		assertEquals(3,bookIds.size());
	}
	
}
