package org.egonet.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.egonet.model.alter.Alter;
import org.egonet.util.FileHelpers;

public class EdgeListWriter extends FileWriter {

	public EdgeListWriter(File file, boolean append) throws IOException {
		super(file, append);
	}

	public EdgeListWriter(File file) throws IOException {
		super(file);
	}

	public EdgeListWriter(FileDescriptor fd) {
		super(fd);
	}

	public EdgeListWriter(String fileName, boolean append) throws IOException {
		super(fileName, append);
	}

	public EdgeListWriter(String fileName) throws IOException {
		super(fileName);
	}

	public void writeEdgelist(List<Alter> thisInterviewAlterlist, int [][] adj) throws IOException {
		for(int i = 0; i < adj.length; i++)
		{
			for(int j = i+1; j < adj[i].length; j++)
			{
				// adj[i][j] != 0 && 
				if(i != j)
				{
					
					String alter1 = thisInterviewAlterlist.get(i).getName();
					String alter2 = thisInterviewAlterlist.get(j).getName();
					int edgeValue = adj[i][j];
					if(edgeValue != 0) { // Don't need to include edges that don't 
						                 // represent a connection.
						String line = ("\"" + 
								FileHelpers.formatForCSV(alter1) 
								+ "\",\"" + 
								FileHelpers.formatForCSV(alter2) 
								+ "\","+adj[i][j] +"\n");
						write(line);
					}
				}
			}
		}
	}
	
}
