package lab4;

import java.util.ArrayList;
import java.util.List;

public class CSVData {
    private List<CSVLine> lines;
    private List<String> headers;

    public CSVData() { lines = new ArrayList(); headers = new ArrayList(); }
    public void addHeaders(List<String> headers) { this.headers.addAll(headers); }
    public List<String> getHeaders() { return this.headers; }
    public void addLine(CSVLine line) { lines.add(line); }
    public CSVLine getLine(int pos) { return lines.get(pos); }
    public int numLines() { return lines.size(); }
}
