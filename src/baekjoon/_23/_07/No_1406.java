package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.23
 * StringBuilder로 하나씩 명령어 받는거는 시간초과
 * 자료구조 (LinkedList) 구현 풀이
 */
public class No_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		Editor editor = new Editor();

		for (int i = 0; i < word.length(); i++) {
			editor.add(word.charAt(i));
		}

		for (int i = 0; i < M; i++) {

			String command = br.readLine();

			switch (command.charAt(0)) {
				case 'L':
					editor.left();
					break;
				case 'D':
					editor.right();
					break;
				case 'B':
					editor.backspace();
					break;
				default:
					editor.add(command.charAt(2));
					break;
			}
		}

		editor.print();

		System.out.println(sb);
	}

	// 노드 클래스 작성
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
		public void print() {
			StringBuilder sb = new StringBuilder();

			Node cur = root.right;
			while (cur != null) {
				sb.append(cur.value);

				cur = cur.right;
			}

			System.out.println(sb);
		}
	}

}
