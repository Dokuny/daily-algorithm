package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			Editor keylogger = new Editor();

			String input = br.readLine();

			for (int j = 0; j < input.length(); j++) {

				char cur = input.charAt(j);

				switch (cur) {
					case '<':
						keylogger.left();
						break;
					case '>':
						keylogger.right();
						break;
					case '-':
						keylogger.backspace();
						break;
					default:
						keylogger.add(cur);
						break;
				}

			}

			sb.append(keylogger.print())
				.append("\n");
		}
		System.out.println(sb);
	}

	static class Node {

		Node left;
		Node right;
		char value;

		public Node(Node left, Node right, char value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}

		public Node() {
		}
	}

	// 에디터 클래스 작성
	static class Editor {
		private final Node root;
		private Node cur;

		public Editor() {
			root = new Node();
			cur = root;
		}

		// 커서 왼쪽으로 이동
		public void left() {
			if(cur.left == null) return; // 왼쪽으로 이동할 곳이 없으면 이동 X
			cur = cur.left;
		}

		// 커서 오른쪽 이동
		public void right() {
			if(cur.right == null) return; // 오른쪽으로 이동할 곳이 없으면 이동 X
			cur = cur.right;
		}

		// 백스페이스
		public void backspace() {
			if(cur == root) return; // 커서가 맨 앞이면 무시

			// 오른쪽 노드가 존재한다면, 현재 노드의 오른쪽 노드가 현재 노드의 왼쪽 노드를 바라보도록 설정
			if(cur.right != null) cur.right.left = cur.left;
			// 현재 노드의 왼쪽 노드가 현재 노드의 오른쪽 노드를 바라보도록 설정
			cur.left.right = cur.right;

			// 백스페이스 했으므로 커서 위치 왼쪽으로
			cur = cur.left;
		}

		// 글자 추가
		public void add(char ch) {

			// 입력받은 글자를 노드로 만들기
			Node newNode = new Node(cur, cur.right, ch);

			// 현재 노드의 오른쪽 노드가 비어있지 않다면 현재 노드의 오른쪽노드가 새로운 노드를 바라보도록 설정
			if (cur.right != null) cur.right.left = newNode;
			// 현재 노드의 오른쪽에 글자 추가
			cur.right = newNode;

			// 커서가 현재 글자를 바라보도록
			cur = newNode;
		}

		// root 부터 끝까지 돌면서 출력
		public String print() {
			StringBuilder sb = new StringBuilder();

			Node cur = root.right;
			while (cur != null) {
				sb.append(cur.value);

				cur = cur.right;
			}

			return sb.toString();
		}
	}
}
