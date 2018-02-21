package io.cvaldezchavez.pc2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.cvaldezchavez.pc2.service.FactoryService;

public class ReadFileTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadInputStream() {
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		FactoryService.ReadDBClassic();
		end = System.currentTimeMillis();
		assertNotNull(FactoryService.listProfesor);
		System.out.println("Total time " + (((double)end - start) / 1000));
	}
	
	@Test
	public void testReadBuffered() {
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		FactoryService.ReadDbBuffered();
		end = System.currentTimeMillis();
		assertNotNull(FactoryService.listProfesor);
		System.out.println("Total time " + (((double)end - start) / 1000));
	}

}
