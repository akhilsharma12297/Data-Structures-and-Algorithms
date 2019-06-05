package DP;

import java.util.Arrays;

public class BoxStacking {

	public int maxHeight(Box[] arr, int n) {
		Box[] rot = new Box[n * 3];

		createAllRotation(arr, rot);

		Arrays.sort(rot);

		int t[] = new int[rot.length];
		int result[] = new int[rot.length];

		for (int i = 0; i < t.length; i++) {
			t[i] = rot[i].h;
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 0; j < i; j++) {

				if (rot[i].area < rot[j].area) {

					if (t[j] + rot[i].h > t[i]) {
						t[i] = t[j] + rot[i].h;
						result[i] = j;
					}
				}

			}
		}

		return n;

	}

	private void createAllRotation(Box[] arr, Box[] rot) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			rot[index++] = new Box(arr[i].h, arr[i].l, arr[i].w);
			rot[index++] = new Box(arr[i].l, arr[i].h, arr[i].w);
			rot[index++] = new Box(arr[i].w, arr[i].l, arr[i].h);
		}
	}

	static class Box implements Comparable<Box> {
		int h;
		int l;
		int w;
		int area = l * w;

		public Box(int h, int l, int w) {
			this.h = h;
			this.l = l;
			this.w = w;
		}

		@Override
		public int compareTo(Box o) {
			return o.area - this.area;
		}
	}

	public static void main(String[] args) {

		Box[] arr = new Box[2];
		arr[0] = new Box(3, 2, 5);
		arr[1] = new Box(1, 2, 4);

	}
}