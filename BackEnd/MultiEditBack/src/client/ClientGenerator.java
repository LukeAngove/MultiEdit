/**
 * 
 */
package client;

import communicator.Communicator;

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
		Communicator coms = new ClientSideSocketCommunicator(server);
		return new Client(coms);
	}

}
