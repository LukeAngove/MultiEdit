package client;

import communicator.Communicator;

public class DummyClientCommunicator implements Communicator {
	String lastSent;

	@Override
	public void send(String text) {
		lastSent = text;
	}

	@Override
	public String recieve() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastSend() {
		return lastSent;
	}

}
