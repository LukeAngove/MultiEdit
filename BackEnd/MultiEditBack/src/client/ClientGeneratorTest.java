package client;

import static org.junit.Assert.*;

import org.junit.Test;

import serverTest.DummyServer;

public class ClientGeneratorTest {

	@Test
	public void getNewClient() {
		ClientGenerator cg = new ClientGenerator( new DummyServer() );
		assertTrue( cg.getNewClient() instanceof Client );
	}

}
