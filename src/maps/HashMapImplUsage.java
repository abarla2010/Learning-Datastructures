package maps;

/**
 * Created by abhishekbarla on 11/22/16.
 */
public class HashMapImplUsage {

	public static void main(String[] args){
		HashMapImpl hashMap = new HashMapImpl();

		hashMap.add(1, 10);
		hashMap.add(2, 20);
		hashMap.add(3, 30);
		hashMap.add(4, 40);
		hashMap.add(4, 50);

		System.out.println(hashMap.get(4));
		System.out.println(hashMap.size());
		System.out.println(hashMap.remove(4));
		System.out.println(hashMap.size());
	}
}
