import java.lang.reflect.Method;


public class LevelOfFunSearch {
	static int binarySearch(MISMCourse[] m, MISMCourse key, Method f){
		int a = 0;
		try{
			a = (Integer) f.invoke(null, m, key);
		}
		catch(Exception e){
			//???
		}
		
		return a;
	}
	
	public static int bSearch(MISMCourse[] m, MISMCourse key){
		int first = 0;
		int last = m.length-1;
		boolean found = false;

		int index = 0;
		while(first <= last && !found){
			index = (int) Math.floor((first+last)/2);
			if(key.levelOfFun == m[index].levelOfFun ){
				found = true;
			}
			else if(key.levelOfFun < m[index].levelOfFun){
				last = index - 1;
			}
			else{
				first = index + 1;
			}
		}
		if(!found){
			index = -1;
		}
		return index;
	}
	
	static void SortLvlOfFun(MISMCourse[] courseArray){
		int j;
		for(int index = 1; index < courseArray.length; index++){
			int key = courseArray[index].levelOfFun;
	           for(j = index - 1; (j >= 0) && (courseArray[j].levelOfFun > key); j--)   // Smaller values are moving up
	          {
	                 courseArray[j+1].levelOfFun = courseArray[j].levelOfFun;
	          }
	         courseArray[j+1].levelOfFun = key;    // Put in its proper location
		}
		
	}
}
