import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	static Node root;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		root = new Node(Integer.parseInt(br.readLine()));
		String input = "";

		Node cur = root;
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int num = Integer.parseInt(input);

			add(num);
		}

		sb = new StringBuilder();
		postOrder(root);
		System.out.println(sb);

	}

	static void add(int num) {
		Node cur = root;

		while (true) {
			if (num < cur.number) {
				if (cur.left == null) {
					cur.left = new Node(num);
					break;
				} else {
					cur = cur.left;
				}
			} else {
				if (cur.right == null) {
					cur.right = new Node(num);
					break;
				} else {
					cur = cur.right;
				}
			}
		}
	}

	static void postOrder(Node node) {
		// 왼쪽
		if(node.left != null) postOrder(node.left);

		// 오른쪽
		if(node.right != null) postOrder(node.right);

		// 루트
		sb.append(node.number).append("\n");
	}



	static class Node {
		Node left;
		Node right;
		int number;

		public Node(int number) {
			this.number = number;
		}

	}
}

