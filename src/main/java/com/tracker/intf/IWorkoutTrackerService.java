package com.tracker.intf;

import com.tracker.Exception.BusinessException;
import com.tracker.model.WorkoutTrackerModel;

public interface IWorkoutTrackerService {
	
	public WorkoutTrackerModel getWorkoutTrackerData() throws BusinessException;

}
