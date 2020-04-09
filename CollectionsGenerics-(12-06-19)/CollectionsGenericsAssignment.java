import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CollectionsGenericsAssignment {
	public static void main(String args[]) {
		System.out.println("Exercise-1");
		runExercise1();
		System.out.println("Exercise-2");
		runExercise2();
		System.out.println("Exercise-3");
		runExercise3();
	}
	public static void runExercise1() {
		System.out.print("Enter String");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = input.toUpperCase();
		HashMap<Character, Integer>  charMap = new HashMap<>();
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch>='A' && ch<='Z') {
				charMap.put(ch, charMap.containsKey(ch)?charMap.get(ch)+1:1);
			}
		}
		for(Map.Entry<Character, Integer> entry: charMap.entrySet()) {
			System.out.print("\n" + entry.getKey() + "\t\t");
			int frequency = entry.getValue();
			for(int i=0;i<frequency;i++)
				System.out.print("#");
		}
		System.out.println();
	}
	public static void runExercise2() {
		String[] input = {"ab", "bc", "ab" ,"ab" ,"cd", "cd"};
		System.out.println("Input: {ab,bc,ab,ab,cd,cd}" );
		List<String> list= new ArrayList<>();
		HashMap<String, Integer>  stringMap = new HashMap<>();
		for(int i=0;i<input.length;i++) {
			String ch = input[i];
			if(!stringMap.containsKey(ch))
				list.add(ch);
			stringMap.put(ch, stringMap.containsKey(ch)?stringMap.get(ch)+1:1);
		}
		MyComparator comp = new MyComparator(stringMap);
		Collections.sort(list, comp);
		System.out.println("Sorted Order [");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();
	}
	public static void runExercise3() {
		class MyGenericClass<T> implements Comparable<MyGenericClass> {
			int id;
			T obj;
			String name;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public T getObj() {
				return obj;
			}
			public void setObj(T obj) {
				this.obj = obj;
			}
			public int compareTo(MyGenericClass  mg) {
				return this.name.compareTo(mg.name);
			}
			public boolean equals(Object o) {
				if(o instanceof MyGenericClass)  {
					MyGenericClass ob = (MyGenericClass)o;
					if(this.id==ob.id && this.name.equals(ob.name)) {
						return this.obj.equals(ob.obj);
					} else return false;
					
				} else {
					return false;
				}
			} 
		}
		//With String Object(T)
		MyGenericClass<String> mg1=new MyGenericClass<>();
		mg1.setId(1);
		mg1.setName("Name");
		mg1.setObj("NewObject");
		MyGenericClass<String> mg2=new MyGenericClass<>();
		mg2.setId(1);
		mg2.setName("Name");
		mg2.setObj("NewObject");
		//Using Equals 
		System.out.println("mg1==mg2 " + mg1.equals(mg2));
		
		//With Integer Object(T)
		MyGenericClass<Integer> mg3=new MyGenericClass<>();
		mg3.setId(1);
		mg3.setName("Name");
		mg3.setObj(101);
		MyGenericClass<Integer> mg4=new MyGenericClass<>();
		mg4.setId(1);
		mg4.setName("Name");
		mg4.setObj(101);
		//Using Equals 
		System.out.println("mg3==mg4 " + mg3.equals(mg4));
	}
}
//used in runExercise2 method of main Class
class MyComparator implements Comparator<String> {
	Map<String, Integer> myMap;
	public MyComparator(Map<String, Integer> myMap) {
		this.myMap = myMap;
	}
	public int compare(String s1, String s2) {
		int n1 = myMap.get(s1);
		int n2 = myMap.get(s2);
		return n1<n2?1:-1;
	}
	
}
