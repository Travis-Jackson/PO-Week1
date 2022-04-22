package week1codingchallenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Example for topological sorting:
// projects: a, b, c, d, e, f
// dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// Output: f, e, a, b, d, c

public class BuildOrder {
	
	public List<Character> buildOrder(char[][] processes){
		Set<Character> tempMarks = new HashSet<Character>();
		Set<Character> permMarks = new HashSet<Character>();
		List<Character> results = new LinkedList<Character>();
		
		for (int i = 0; i < processes.length; i++){
			if(!permMarks.contains(i)){
				visit(i, processes, tempMarks, permMarks, results);
			}
		}
		return results;
	}
	public void visit(int process,
					  char[][] processes,
					  Set<Character> tempMarks,
					  Set<Character> permMarks,
					  List<Character> results){
		if(tempMarks.contains(process)) throw new RuntimeException();
		if(!permMarks.contains(process)){
			tempMarks.add((char)process);
			for(int i : processes[process]){
				visit(i, processes, tempMarks, permMarks, results);
			}
		}
		permMarks.add((char)process);
		tempMarks.remove(process);
		results.add((char)process);
	}
}

// I utilized Byte by Byte YouTube channel as a guide
