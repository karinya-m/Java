
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestMISMCourse {
	public static void main(String[] args) throws Exception {
	
		MISMCourse[] testData = {new MISMCourse(5,6,7), new MISMCourse(7,5,4), new MISMCourse(1,8,9)};
		for(int i = 0; i < testData.length; i++){
			System.out.println(testData[i]);
		}
		
		//get input number from user
		System.out.println("Enter number of criteria you want to search for courses");
		System.out.println("1. Level of Difficulty");
		System.out.println("2. Level of Usefulness");
		System.out.println("3. Level of Fun");
		Scanner keyboard = new Scanner(System.in);
		
		int criteria = keyboard.nextInt();
		
		System.out.println("Enter level you want to search");
		int level = keyboard.nextInt();
		
		switch(criteria){
		case 1:
			MISMCourse key1 = new MISMCourse(level, 0, 0);
			Arrays.sort(testData);
			System.out.println(Arrays.binarySearch(testData, key1));
			break;
			
		case 2:
			MISMCourse key2 = new MISMCourse(0, level, 0);
			CompareMISMCourseUsefulness comparatorObj = new CompareMISMCourseUsefulness();
			Arrays.sort(testData, comparatorObj);
			System.out.println(Arrays.binarySearch(testData, key2, comparatorObj));
			break;
			
		case 3:
			MISMCourse key3 = new MISMCourse(0, 0, level);
			LevelOfFunSearch.SortLvlOfFun(testData);
			Method binarySearchForLvlFun = LevelOfFunSearch.class.getMethod("bSearch", new Class[]{MISMCourse[].class, MISMCourse.class});
			System.out.println(LevelOfFunSearch.binarySearch(testData, key3, binarySearchForLvlFun));
			break;
		}
		for(int i = 0; i < testData.length; i++){
			System.out.println(testData[i]);
		}
	}
}
