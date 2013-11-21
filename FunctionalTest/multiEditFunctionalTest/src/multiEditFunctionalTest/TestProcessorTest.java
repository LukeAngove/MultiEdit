package multiEditFunctionalTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProcessorTest {

	private DummyClientGenerator cg;
	private TestProcessor tp;

	@Before
	public void setUp() throws Exception {
		cg = new DummyClientGenerator();
		tp = new TestProcessor(cg);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcessStartClient() {
		assertEquals( 0, tp.getNumberOfClients() );
		tp.process("start client1");
		assertEquals( 1, tp.getNumberOfClients() );
	}
	
	@Test
	public void testSendText() {
		tp.process("start client1");
		tp.process("send client1 \"Test text\"");
		assertEquals( "Test text", cg.getClient(0).getLastSend() );
	}
	
	@Test(expected=java.lang.AssertionError.class)
	public void testCheckReceiveTextFail() {
		tp.process("start client1");
		tp.process("check client1 \"Testing text\"");
	}

	/**
	 * Fails when exception is thrown.
	 */
	@Test
	public void testCheckReceiveText() {
		tp.process("start client1");
		cg.getClient(0).setContent("Testing text");
		tp.process("check client1 \"Testing text\"");
	}
	
}
