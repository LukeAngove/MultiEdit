package patch;

public class Patch {

	private String[] content;
	private int startLine;

	public Patch(int start, String string) {
		content = string.split("\n");
		startLine = start;
	}
	
	public String getFullContent() {
		return content.toString();
	}

	public String getContent(int i) {
		return content[i];
	}
	
	public int getStartLine() {
		return startLine;
	}

	public int getLength() {
		return content.length;
	}


}
