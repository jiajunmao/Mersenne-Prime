package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	private String filePath;
	
	public FileWrite() throws IOException {
		filePath = "D://Result//calcResult.txt";
		new File(filePath);
	}

	public FileWrite(String path) throws IOException {
		filePath = path;
		new File(filePath);
	}

	public void append(String write) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
		writer.append(write);
		writer.close();
	}
	
	public void appendAndSpace(String write) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
		writer.append(write);
		writer.append(" ,");
		writer.close();
	}

	public void appendAndNewLine(String write) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
		writer.append(write);
		writer.newLine();
		writer.close();
	}

	public void newLine() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
		writer.newLine();
		writer.close();
	}
}
