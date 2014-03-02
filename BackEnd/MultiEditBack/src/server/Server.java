/**
 * 
 */
package server;

import java.net.Socket;
import java.util.ArrayList;

import patch.Patch;

/**
 * @author luke
 *
 */
public class Server implements IServer {

	private ArrayList<String> content;
	
	public Server() {
		content = new ArrayList<String>();
	}

	/* (non-Javadoc)
	 * @see server.IServer#getSocket()
	 */
	@Override
	public Socket getSocket() {
		// TODO Auto-generated method stub
		return null;
	}

	synchronized public void recieve(Patch patch) {
		for( int i=0; i<patch.getLength(); i++ ) {
			addContent( i+patch.getStartLine(), patch.getContent(i) );
		}
	}
	
	synchronized private void addContent(int i, String content2) {
		i = i-1; // Use (i-1), as not 0 indexed.
		if(i<content.size()) {
			content.set(i, content2);
		} else if(i==content.size()) {
			content.add(content2);
		}
		
		// TODO should throw exception if happens past end of file!
	}

	public String getContent() {
		String fullContent = content.get(0);
		
		for(int i=1; i<content.size(); i++) {
			fullContent += "\n" + content.get(i);
		}

		return fullContent;
	}

}
