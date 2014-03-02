/**
 * 
 */
package multiEditFunctionalTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import server.IServer;
import server.ClientSideServer;
import client.ClientGenerator;
import client.IClientGenerator;
import client.IMultiEditClient;

/**
 * @author luke
 *
 */
public class TestProcessor {
	private Map<String, IMultiEditClient> clients;
	private IClientGenerator clientGenerator;

	/**
	 * Constructor generates new client map.
	 */
	public TestProcessor(IClientGenerator cg) {
		clients = new HashMap<String, IMultiEditClient>();
		clientGenerator = cg;
	}

	/**
	 * Processes an input string. Used to process lines read from
	 * a test file. Can generate clients, send text and check
	 * data is received.
	 * @param line Line to process.
	 * @throws Exception thrown if a check does not match.
	 */
	public void process(String line) {
		String[] tokens = line.split(" ");
		String operation = tokens[0];
		String name = tokens[1];

		switch(operation) {
			case "start":
				startNewClient(name);
				break;
			case "send":
				String textToSend = extractTextFrom(line);
				sendFromClient( name, textToSend );
				break;
			case "check":
				String textToCheckFor = extractTextFrom(line);
				checkClientHasText( name, textToCheckFor );
				break;
			default:
				// TODO Use a better exception!!!
				assert(false);
		}
		
	}

	/**
	 * Checks that the given client has a specified text as content.
	 * @param clientName Name of the client to test.
	 * @param expectedText text expected by receive.
	 * @throws Exception Thrown if text does not match.
	 */
	private void checkClientHasText(String clientName, String expectedText) {
		String actualText = clients.get(clientName).getContent();
		assert(actualText.contentEquals(expectedText));
	}

	/**
	 * Gets text between "" in a string.
	 * @param line Input String.
	 * @return Returns substring between "".
	 */
	private String extractTextFrom(String line) {
		String[] quotes = line.split("\"");
		String textToSend = quotes[1];
		return textToSend;
	}

	/**
	 * Send required string from given client. Also sets lastSend
	 * for testing.
	 * @param client Name of the client to send from.
	 * @param text Text to be sent.
	 */
	private void sendFromClient(String client, String text) {
		clients.get(client).send(text);
	}

	/**
	 * Creates a new client and adds it to the client list. Names must be
	 * unique, or the old client of the same name will be overwritten.
	 * @param name Name of the client to be created.
	 */
	private void startNewClient(String name) {
		clients.put( name, clientGenerator.getNewClient() );
	}

	/**
	 * Returns the number of currently active clients.
	 * @return number of clients.
	 */
	public int getNumberOfClients() {
		return clients.size();
	}
	
	/**
	 * Runs functional test for given file.
	 */
	public static void main(String[] args) {
		IServer server = new ClientSideServer();
		IClientGenerator cg = new ClientGenerator(server);
		TestProcessor tp = new TestProcessor(cg);
		
		String fileFullPath = args[0];
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileFullPath))) {
			String line;
			while((line = br.readLine()) != null) {
				tp.process(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		}
	}


}
