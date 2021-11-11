package mapProgramming;

import java.util.HashMap;
import java.util.Map;

public class ObjectsCourseMapProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Course> map = new HashMap<Integer, Course>(); 
		
		Course c1 = new Course("swd1tf001", "Orientation to Software Engineering", 5);
		Course c2 = new Course("swd4tf033", "Programming 2", 5);
		Course c3 = new Course("swd4tf032", "Programming 1", 5);
		
		map.put(1, c1); 
		map.put(2, c2); 
		map.put(3, c3); 
		
		for(Course course : map.values() ) {
			
			System.out.println(course.toString());
		}
		
		System.out.println("---");
		System.out.println(map.get(2).toString());
	}

}
