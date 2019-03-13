import java.util.List;

public class List_to_String_IVB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String func(List<Integer> list) {

		boolean[] visited = new boolean[list.size()];

		int max = Integer.MIN_VALUE;

		int idx = 0;

		while (true) {

			for (int i = 0; i < list.size(); i++) {
				if (visited[i] == false) {
					if (list.get(i) > max) {
							
						
									
					}

				}
			}

		}
	}

}
