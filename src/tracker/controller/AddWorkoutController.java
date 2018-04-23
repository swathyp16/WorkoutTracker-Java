package tracker.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tracker.model.AddWorkoutModel;

@RestController
@RequestMapping("/createWorkout")
public class AddWorkoutController {

	@RequestMapping(value="/all",method= RequestMethod.GET)
	public void createWorkout(AddWorkoutModel addWorkoutModel) {
		System.out.println("***********************************************");
		System.out.println(addWorkoutModel.toString());
		System.out.println("***********************************************");
	}
}
