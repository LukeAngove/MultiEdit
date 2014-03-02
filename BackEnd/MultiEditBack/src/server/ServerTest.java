package server;

import static org.junit.Assert.*;

import org.junit.Test;

import patch.Patch;

public class ServerTest {

	@Test
	public void submitFirstPatch() {
		Server myServer = new Server();
		Patch patch = new Patch(1, "Some text");
		
		myServer.recieve(patch);
		assertEquals( "Some text", myServer.getContent() );
	}
	
	@Test
	public void submitMultiLinePatchAndChange() {
		Server myServer = new Server();
		Patch patch1 = new Patch(1, "Some text\nSome more text");
		Patch patch2 = new Patch(2, "Some other text");

		myServer.recieve(patch1);
		assertEquals( "Some text\nSome more text", myServer.getContent() );
		myServer.recieve(patch2);
		assertEquals( "Some text\nSome other text", myServer.getContent() );
		
	}

}
