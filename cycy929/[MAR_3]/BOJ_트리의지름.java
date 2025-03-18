package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0313_트리의지름 {
	static int n, a, d, distance, maxNode;
	static List<Node>[] tree;
	static int[] visited;

	static class Node {
		int vn;
		int w;

		Node(int vn, int w) {
			this.vn = vn;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		tree = new ArrayList[n + 1];
		visited = new int[n + 1];
		distance = 0;

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Node>();
		}

		for (int i = 1; i <= n; i++) {
			int v = sc.nextInt();
			while (true) {
				a = sc.nextInt();
				if (a == -1)
					break;
				d = sc.nextInt();
				tree[v].add(new Node(a, d)); // i->a 인 거리b 정점
                tree[a].add(new Node(v, d)); // a->i 인 거리b 정점
			}
		}

		dfs(3, 0);
		visited = new int[n + 1];
		distance = 0;
		
		dfs(maxNode,0);
		
		System.out.println(distance);
		sc.close();
	}

	static void dfs(int index, int dis) {
		if (distance < dis) {
			distance = dis;
			maxNode = index;
		}

		visited[index] = 1;

		for (Node nxt : tree[index]) {
			if (visited[nxt.vn] == 0) {
				dfs(nxt.vn, dis + nxt.w);

			}

		}

	}

}
