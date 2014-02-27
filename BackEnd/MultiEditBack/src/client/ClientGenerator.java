/**
 * 
 */
package client;

import server.IServer;

/**
 * @author luke
 *
 */
public class ClientGenerator implements IClientGenerator {
	
	private IServer server;

	public ClientGenerator(IServer server) {
		this.server = server;
	}

	@Override
	public IMultiEditClient getNewClient() {
		return new Client(server);
	}

}
