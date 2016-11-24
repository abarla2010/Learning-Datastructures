package common;

/**
 * Created by abhishekbarla on 11/20/16.
 * Helper node for HashTable/HashMap implementation
 */
public class HashNode<K,V> {

	public K key;
	public V value;
	public HashNode<K,V> next;

	//Constructor
	public HashNode(K key, V value){
		this.value = value;
		this.key = key;
		this .next = null;
	}
}
