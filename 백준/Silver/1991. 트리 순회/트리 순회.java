import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Node[] tree = new Node[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new Node();
		}

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			int idx = c - 'A';

			tree[idx].c = c;

			if (left != '.') {
				tree[idx].left = tree[left - 'A'];
			}

			if (right != '.') {
				tree[idx].right = tree[right - 'A'];
			}
		}

		sb = new StringBuilder();

		// 전위
		ArrayDeque<Node> stack = new ArrayDeque<>();
		stack.add(tree[0]);

		while (!stack.isEmpty()) {
			Node cur = stack.pop();

			sb.append(cur.c);

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		sb.append("\n");

		// 중위
		mid(tree[0]);
		sb.append("\n");
		// 후위
		post(tree[0]);

		System.out.println(sb);
	}

	static void mid(Node node) {
		if(node == null) return;

		mid(node.left);

		sb.append(node.c);

		mid(node.right);
	}

	static void post(Node node) {
		if(node == null) return;

		post(node.left);
		post(node.right);
		sb.append(node.c);
	}

	static class Node{
		char c;
		Node left;
		Node right;

		public Node() {
		}

		public Node(char c, Node left, Node right) {
			this.c = c;
			this.left = left;
			this.right = right;
		}
	}

}