package serverTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.IServer;

public class DummyServer implements IServer, AutoCloseable {
	private ServerSocket ss;

	public DummyServer() {
		try (ServerSocket ss = new ServerSocket(40007)) {
			this.ss = ss;
		} catch (IOException e) {
			e.printStackTrace();
			this.ss = null;
		}
	}

	@Override
	public Socket getSocket() {
		try {
			return ss.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO should never happen. Fix.
		return null;
	}

	@Override
	public void close() throws IOException {
		ss.close();
	}

}
