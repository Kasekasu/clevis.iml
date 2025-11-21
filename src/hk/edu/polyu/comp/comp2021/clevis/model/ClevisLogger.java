package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClevisLogger {
    private final BufferedWriter txtLog;
    private final BufferedWriter htmlLog;
    private int index = 1; // used for the table index on html file

    public ClevisLogger(String txtPath, String htmlPath) throws IOException {
        txtLog = new BufferedWriter(new FileWriter(txtPath));
        htmlLog = new BufferedWriter(new FileWriter(htmlPath));

        htmlLog.write("<html><body><table border=\"1\">\n");
        htmlLog.write("<tr><th>#</th><th>Command</th></tr>\n");

    }
    public void log(String cmd) throws IOException {
        txtLog.write(cmd);
        txtLog.newLine();

        htmlLog.write("<tr><td>" + (index++) + "</td><td>" + escape(cmd) + "</td></tr>\n");
    }

    public void close() throws IOException {
        txtLog.close();
        htmlLog.write("</table></body></html>");
        htmlLog.close();
    }

    private String escape(String cmd) { // in case the command has a character that is used in an html tag
        return cmd.replace("<", "&lt;").replace(">", "&gt;");
    }
}
