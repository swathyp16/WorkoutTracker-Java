package com.tracker.intf;

import com.tracker.Exception.BusinessException;
import com.tracker.model.WorkoutTrackerModel;

/**
 * The Interface IWorkoutTrackerService.
 */
public interface IWorkoutTrackerService {
	
	/**
	 * Gets the workout tracker data.
	 *
	 * @return the workout tracker data
	 * @throws BusinessException the business exception
	 */
	public WorkoutTrackerModel getWorkoutTrackerData() throws BusinessException;

}
