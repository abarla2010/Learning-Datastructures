package maps;

import common.HashNode;

import java.util.ArrayList;

/**
 * Created by abhishekbarla on 11/20/16.
 * HashMap implementation
 * In this implementation, when collision occurs, chaining is performed. To avoid the worst case of all nodes in one chain,
 * a load factor is calculated. Load factor is the ratio of number of nodes in a chain and size of buckets. A bucket is
 * an element in the List which is used to implement a HashMap. Each of these elements are Linked Lists of HashNode<K,V>
 * to be able to perform chaining in case of a collision
 */
public class HashMapImpl<K,V> {

	//List of HashNode in a certain bucket (in case of changing for collision)
	ArrayList<HashNode<K,V>> bucketList;

	//Number of such buckets
	int numberOfBuckets;

	//Size of ArrayList (Total number of elements)
	int numberOfElements;

	//Constructor
	public HashMapImpl(){
		this.bucketList = new ArrayList<HashNode<K,V>>();
		numberOfElements = 0;
		//Initializing the number of buckets
		numberOfBuckets = 10;

		//Creating empty bucket chains
		for(int i=0; i<numberOfBuckets; i++){
			bucketList.add(null);
		}
	}

	/**
	 * Method that returns the corresponding value for a given key
	 * @param key
	 * @return
	 */
	public V get(K key){

		int hashCode = 0;
		int index = 0;
		HashNode<K,V> head = null;
		HashNode<K,V> current = null;

		//Hash the key
		hashCode = getIndex(key);

		//Get the value to which the key corresponds, from the bucket
		head = bucketList.get(index);
		current = head;

		//Traverse through the linked list and find the key
		while(current != null){
			if(current.key == key){
				return (V) current.value;
			}
			current = current.next;
		}

		//Return the value
		return null;
	}

	/**
	 * Method that removes a key from the HashMap
	 * @param key
	 * @return
	 */
	public V remove(K key){

		int index = 0;
		HashNode<K,V> head = null;
		HashNode<K,V> temp = null;
		HashNode<K,V> current = null;
		HashNode<K,V> previous = null;
		V tempValue = null;

		//Hash the Key
		index = getIndex(key);

		//Find out the corresponding bucket in which the key lies
		head = bucketList.get(index);
		current = head;

		//Remove the key from the chain of that bucket
		while(current!=null){
			if(head.key == key){
				tempValue = head.value;
				head = head.next;
				numberOfElements--;
				return tempValue;
			}
			else if(current.key == key){
				tempValue = current.value;
				previous.next = current.next;
				numberOfElements--;
				return tempValue;
			}
			previous = current;
			current = current.next;
		}

		//Return the value for that key
		return null;
	}

	/**
	 * Method to add a key and its corresponding value to the HashMap/HashTable
	 * @param key
	 * @param value
	 */
	public void add(K key, V value){

		int index = 0;
		HashNode<K,V> head = null;
		HashNode<K,V> current = null;
		HashNode<K,V> newNode = new HashNode<K, V>(key, value);

		//Find the hashcode of the key
		index = getIndex(key);

		//Find the head of the Linkedlist in that index
		head = bucketList.get(index);
		current = head;

		//Adding the first element
		if(head==null){
			head = newNode;
		}
		else{
			//Find the last element of the Linkedlist
			while(current!=null){
				if(current!=null) {
					current = current.next;
				}
			}

			//Add the key-value pair to the
			current = newNode;
		}


		bucketList.set(index, newNode);
		numberOfElements++;
	}

	/**
	 * Method to hash the key and return the corresponding index in the ArrayList, where the key will be added
	 * @param key
	 * @return
	 */
	public int getIndex(K key){

		int hashCode = key.hashCode();
		return (hashCode % numberOfBuckets);
	}

	/**
	 * Method to find out the size of the HashMap/HashTable
	 * @return
	 */
	public int size(){
		return numberOfElements;
	}

	/**
	 * Method to check if the HashMap/HashTable is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		return numberOfElements == 0;
	}


}
