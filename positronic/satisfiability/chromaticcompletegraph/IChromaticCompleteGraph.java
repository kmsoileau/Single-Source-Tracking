package positronic.satisfiability.chromaticcompletegraph;

import java.util.Vector;

public interface IChromaticCompleteGraph
{
	boolean equals(Object o);
	Vector<ColoredEdge> getEdges();
	String getName();
	String toString();
}
