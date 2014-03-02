/**
 * 
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import communicator.Communicator;

import server.IServer;

/**
 * @author luke
 *
 */
public class Client implements IMultiEditClient {
	private Communicator coms;

	public Client(Communicator coms)  {
		this.coms = coms;
	}


	@Override
	public void send(String text) {
		coms.send(text);
		
	}

	@Override
	public String getContent() {
		return coms.recieve();
	}


}
