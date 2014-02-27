/**
 * 
 */
package client;

import server.IServer;

/**
 * @author luke
 *
 */
public class Client implements IMultiEditClient {
	IServer server;

	public Client(IServer server) {
		this.server = server;
	}

	@Override
	public void send(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
