import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeMap<Long, Long> map;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			map = new TreeMap<Long, Long>();
			for(int k = 0;k<n;k++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				if(str.equals("I")) {
					long num = Long.parseLong(st.nextToken());
					map.put(num, map.getOrDefault(num, (long) 0) + 1);
				}else {
					int num = Integer.parseInt(st.nextToken());
					if(map.isEmpty()) {
						continue;
					}
					if(num == -1) {
						map.put(map.firstKey(), map.get(map.firstKey()) - 1);
						if(map.get(map.firstKey()) == 0) {
							map.remove(map.firstKey());
						}
						
					}else {
						map.put(map.lastKey(), map.get(map.lastKey()) - 1);
						if(map.get(map.lastKey()) == 0) {
							map.remove(map.lastKey());
						}
					}
				}
				
			}
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey() +" " + map.firstKey());
			}
			
		}
	}
}
