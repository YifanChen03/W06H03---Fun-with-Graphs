package pgdp.ds;

import java.util.ArrayList;
import java.util.List;

public class DenseGraph implements Graph {

	private int nodes;

	private boolean[][] b_graph;

	public DenseGraph(int nodes) {
		// TODO
		if (nodes < 0) {
			this.nodes = 0;
		} else {
			this.nodes = nodes;
		}
		if (nodes < 0) {
			b_graph = new boolean[0][0];
		} else {
			b_graph = new boolean[nodes][nodes];
		}
	}

	@Override
	public int getNumberOfNodes() {
		// TODO
		return nodes;
	}

	@Override
	public void addEdge(int from, int to) {
		// TODO
		if (from >= 0 && from < nodes && to >= 0 && to < nodes) {
			b_graph[from][to] = true;
		}
	}

	@Override
	public boolean isAdj(int from, int to) {
		// TODO
		if (from >= 0 && from < nodes && to >= 0 && to < nodes) {
			return b_graph[from][to];
		}
		return false;
	}

	@Override
	public int[] getAdj(int id) {
		// TODO
		List<Integer> out = new ArrayList<Integer>();
		if (id >= 0 && id < nodes) {
			for (int i = 0; i < nodes; i++) {
				if (b_graph[id][i]) {
					out.add(i);
				}
			}
			return out.stream().mapToInt(x -> x).toArray();
		}
		return null;
	}

}
