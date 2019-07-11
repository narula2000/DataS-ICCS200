package a7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IsForest {
	static Set<Integer> nbrsExcluding(Set<Integer>[] G, Set<Integer> vtxes, Set<Integer> excl, CycleD cycleS) {
		Set<Integer> union = new TreeSet<>();
		for (Integer src : vtxes) {
			for (Integer dst : G[src])
				if (!excl.contains(dst)) {
					union.add(dst);
					cycleS.edges++;
				} else {
					cycleS.edges++;
				}
		}
		return union;
	}

	public static int identifyTrees(int n, Iterable<Pair<Integer, Integer>> edges) {
		Set<Integer>[] graph = new TreeSet[n];
		Arrays.fill(graph, new TreeSet<>());
		Iterator<Pair<Integer, Integer>> edgeItrator = edges.iterator();
		CycleD Cyc = new CycleD();
		Set<Integer> globalVisited = new TreeSet<>();
		int tree = 0;
		while (edgeItrator.hasNext()) {
			Pair<Integer, Integer> atEdge = edgeItrator.next();
			graph[atEdge.first].add(atEdge.second);
			graph[atEdge.second].add(atEdge.first);
		}
		for (int i = 0; i < n; i++) {
			if (globalVisited.contains(i)) {
				continue;
			}
			Set<Integer> traversal = bfs(graph, i, globalVisited, Cyc);
			if (!traversal.isEmpty()) {
				tree++;
			}
			if (Cyc.edges >= 2 * traversal.size()) {
				return 0;
			} else Cyc.edges = 0;
		}
		return tree;
	}

	static Set<Integer> bfs(Set<Integer>[] G, int s, Set<Integer> visitAll, CycleD cyclestate) {
		Set<Integer> frontier = new TreeSet<>(Arrays.asList(s));
		visitAll.add(s);
		while (!frontier.isEmpty()) {
			frontier = nbrsExcluding(G, frontier, visitAll, cyclestate);
			visitAll.addAll(frontier);
		}
		return visitAll;
	}

	static class CycleD {
		public int edges = 0;
	}


}
