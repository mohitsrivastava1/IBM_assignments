//Create a method which accepts a hash map and
// return the values of the map in sorted order as a List.

import java.util.Map;

import java.util.HashMap;

import java.util.List;

import java.util.ArrayList;

import java.util.Set;

import java.util.Map.Entry;

import java.util.Collections;

import java.util.Iterator;



class SortHashMap	{

	public static void main(String[] args) {

		HashMap hMap = new HashMap();



		hMap.put("Abc", 1234);

		hMap.put("Def", 12344);

		hMap.put("Ghi", 31234);

		hMap.put("Jkl", 14234);

		hMap.put("Mno", 12364);

		hMap.put("Pqr", 132364);



		List aList = SortHashMap.getValues(hMap);

		Iterator iter = aList.iterator();

		while (iter.hasNext())	System.out.println("value: " + iter.next());

	}



	public static List getValues(HashMap hMap)	{

		Set set = hMap.entrySet();

		ArrayList list = new ArrayList();



		for(Object obj: set)	{

			Map.Entry mapEntry = (Map.Entry)obj;

			list.add(mapEntry.getValue());

		}



		Collections.sort(list);

		return list;

	}

}