package client;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ClientTest {
	private Client subject;
	private DummyClientCommunicator dummy;
	
	@Before
	public void setUp() {
		dummy = new DummyClientCommunicator();
		subject = new Client( dummy );
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void send() {
		subject.send("Some test text");
		assertEquals( "Some test text", dummy.getLastSend() );
	}

}
