
import java.util.*;

public class CompareMISMCourseUsefulness implements Comparator<MISMCourse>{
	public int compare(MISMCourse c1, MISMCourse c2){
		if(c1.usefulness > c2.usefulness){
			return 1;
		}
		else if(c1.usefulness < c2.usefulness){
			return -1;
		}
		else{
			return 0;
		}
	}

}
