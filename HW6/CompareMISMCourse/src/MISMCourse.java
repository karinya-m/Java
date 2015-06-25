
public class MISMCourse implements Comparable{
	int levelOfDifficulty;
	int usefulness;
	int levelOfFun;
	
	MISMCourse(int difficult, int useful, int fun){
		levelOfDifficulty = difficult;
		usefulness = useful;
		levelOfFun = fun;
	}
	
	//default, set all levels to 0
	MISMCourse(){
		levelOfDifficulty = 0;
		usefulness = 0;
		levelOfFun = 0;
	}
	
	public int compareTo(Object o){
		if(((MISMCourse)o).levelOfDifficulty < levelOfDifficulty){
			return 1;
		}
		else if(((MISMCourse)o).levelOfDifficulty > levelOfDifficulty){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	public String toString(){
		return "Difficulty = " + levelOfDifficulty + "    Usefulness = " + usefulness +"    Fun = " + levelOfFun;
	}
	
	

	
}
