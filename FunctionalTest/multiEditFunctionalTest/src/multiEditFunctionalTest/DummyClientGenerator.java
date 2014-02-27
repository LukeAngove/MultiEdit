/**
 * 
 */
package multiEditFunctionalTest;

import java.util.ArrayList;
import java.util.List;

import client.IClientGenerator;
import client.IMultiEditClient;

/**
 * @author luke
 *
 */
public class DummyClientGenerator implements IClientGenerator {
	List<MultiEditClientDummy> clients;
	
	public DummyClientGenerator() {
		clients = new ArrayList<MultiEditClientDummy>();
	}

	/* (non-Javadoc)
	 * @see multiEditFunctionalTest.ClientGenerator#getNewClient()
	 */
	@Override
	public IMultiEditClient getNewClient() {
		MultiEditClientDummy newClient = new MultiEditClientDummy();
		clients.add(newClient);
		return newClient;
	}
	
	public MultiEditClientDummy getClient(int index) {
		return clients.get(index);
	}

}
