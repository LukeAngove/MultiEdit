package multiEditFunctionalTest;

import client.IMultiEditClient;

public class MultiEditClientDummy implements IMultiEditClient {
	String lastSend;
	String content;

	public MultiEditClientDummy() {
		lastSend = "";
		content = "";
	}
	/**
	 * @see multiEditFunctionaltest.MultiEditClient
	 */
	public void send(String text) {
		lastSend = text;
	}

	/**
	 * Gets the source and content of the last message sent.
	 * @return String [clientName: Text]
	 */
	public String getLastSend() {
		return lastSend;
	}

	public void setContent(String string) {
		content = string;
	}

	@Override
	public String getContent() {
		return content;
	}

}
