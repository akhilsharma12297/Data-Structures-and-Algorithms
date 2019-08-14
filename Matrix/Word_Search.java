package Matrix;

public class Word_Search {

	public static void main(String[] args) {

		char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String str = "ABCCED";

		System.out.println(search(arr, str));

	}

	private static boolean search(char[][] arr, String str) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (dfs(arr, i, j, str, 0)) {
					return true;
				}
			}
		}

		return false;

	}

	private static boolean dfs(char[][] arr, int i, int j, String str, int idx) {

		if (str.length() == idx)
			return true;

		if (i < 0 || j <= 0 || i > arr.length || j > arr.length || arr[i][j] != str.charAt(idx) || arr[i][j] > 'z')
			return false;

		arr[i][j] ^= 256;

		boolean ans = dfs(arr, i + 1, j, str, idx + 1) || dfs(arr, i, j - 1, str, idx + 1)
				|| dfs(arr, i - 1, j, str, idx + 1) || dfs(arr, i, j + 1, str, idx + 1);
		arr[i][j] ^= 256;

		return ans;
	}

	public boolean exist(char[][] board, String word) {

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((word.charAt(0) == board[i][j]) && searchHelper(board, word, i, j, 0, visited))
					return true;
			}
		}
		return false;
	}

	boolean searchHelper(char[][] board, String word, int i, int j, int wIndex, boolean[][] visited) {
		if (wIndex == word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(wIndex) != board[i][j]
				|| visited[i][j]) {

			return false;
		}

		wIndex++;

		visited[i][j] = true;

		if (searchHelper(board, word, i + 1, j, wIndex, visited) || searchHelper(board, word, i, j + 1, wIndex, visited)
				|| searchHelper(board, word, i - 1, j, wIndex, visited)
				|| searchHelper(board, word, i, j - 1, wIndex, visited)) {
			return true;
		}
		visited[i][j] = false;

		return false;
	}
}
