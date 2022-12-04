package pgdp.ds;

public class SparseGraph implements Graph {

	private int nodes;
	private SimpleSet[] sims;
	public SparseGraph(int nodes) {
		// TODO
		if (nodes < 0) {
			this.nodes = 0;
			sims = new SimpleSet[0];
		} else {
			this.nodes = nodes;
			sims = new SimpleSet[nodes];
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
			if (sims[from] == null) {
				sims[from] = new SimpleSet();
			}
			sims[from].add(to);
		}
	}

	@Override
	public boolean isAdj(int from, int to) {
		// TODO
		if (from >= 0 && from < nodes && sims[from] != null && sims[from].contains(to)) {
			return true;
		}
		return false;
	}

	@Override
	public int[] getAdj(int id) {
		// TODO
		if (id >= 0 && id < nodes) {
			if (sims[id] == null) {
				return new int[]{};
			} else {
				return sims[id].toArray();
			}
		}
		return null;
	}
}