package pgdp.ds;

import java.util.Arrays;

public class SparseGraph implements Graph {

	private int nodes;
	private SimpleSet[] sims;
	public SparseGraph(int nodes) {
		// TODO
		if (nodes < 0) {
			this.nodes = 0;
		} else {
			this.nodes = nodes;
		}
		if (nodes < 0) {
			sims = new SimpleSet[0];
		} else {
			sims = new SimpleSet[nodes];
		}
		//jedes sims enthält seine verbundenen Knoten in Richtung von diesem sims aus
		for (int i = 0; i < nodes; i++) {
			sims[i] = new SimpleSet();
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
		if (from >= 0 && from < sims.length && to >= 0 && to < sims.length) {
			sims[from].add(to);
		}
	}

	@Override
	public boolean isAdj(int from, int to) {
		// TODO
		if (from >= 0 && from < sims.length) {
			if (sims[from].contains(to)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getAdj(int id) {
		// TODO
		if (id >= 0 && id < nodes) {
			return sims[id].toArray();
		}
		return null;
	}
}
