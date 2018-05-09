package com.tracker.dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.Exception.BusinessException;
import com.tracker.constants.CommonConstants;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.repository.WorkoutActiveRepository;
import com.tracker.repository.WorkoutCollectionRepository;

/**
 * The Class WorkoutTrackerDao.
 */
@Component("workoutTrackerDao")
public class WorkoutTrackerDao {
	
	/** The workout active repository. */
	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	/** The workout collection repository. */
	@Autowired
	private WorkoutCollectionRepository workoutCollectionRepository;
	
	/**
	 * Fetch workout tracker data.
	 *
	 * @param currentDate the current date
	 * @return the list
	 */
	public List<WorkoutActiveEntity> fetchWorkoutTrackerData(String currentDate) {
		List<WorkoutActiveEntity> completedWorkoutsList = workoutActiveRepository.findCurrentDayWorkoutTime(currentDate,CommonConstants.WORKOUT_COMPLETED_STATUS);
		return completedWorkoutsList;
	}
	
	
	/**
	 * Fetch current week workouts.
	 *
	 * @return the list
	 */
	public List<WorkoutCollectionEntity> fetchCurrentWeekWorkouts() {
		LocalDate today = LocalDate.now();
		LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }
	    Date mondayDate = covertLocaleDateToDate(monday);
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }
	    Date sundayDate = covertLocaleDateToDate(sunday);
	    List<WorkoutCollectionEntity> currentWeekWorkouts = workoutCollectionRepository.fetchCurrentWeekWorkouts(mondayDate,sundayDate);
	    return currentWeekWorkouts;
	}
	
	/**
	 * Fetch current month workouts.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	public List<WorkoutCollectionEntity> fetchCurrentMonthWorkouts() throws BusinessException{
		Date firstDayOfMonth = getFirstDateOfMonth(new Date());		
		Date lastDayOfMonth = getLastDateOfMonth(new Date());
		List<WorkoutCollectionEntity> currentMonthWorkouts = workoutCollectionRepository.fetchCurrentMonthWorkouts(firstDayOfMonth,lastDayOfMonth);
		return currentMonthWorkouts;
	}
	
	
	/**
	 * Fetch current year workouts.
	 *
	 * @return the list
	 */
	public List<WorkoutCollectionEntity> fetchCurrentYearWorkouts(){
		List<WorkoutCollectionEntity> currentYearWorkouts = workoutCollectionRepository.fetchCurrentYearWorkouts(CommonConstants.CURRENT_YEAR);
		return currentYearWorkouts;
	}
	
	/**
	 * Gets the first date of month.
	 *
	 * @param date the date
	 * @return the first date of month
	 */
	private Date getFirstDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
	
	/**
	 * Gets the last date of month.
	 *
	 * @param date the date
	 * @return the last date of month
	 */
	private Date getLastDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
	
	/**
	 * Covert locale date to date.
	 *
	 * @param localDate the local date
	 * @return the date
	 */
	private Date covertLocaleDateToDate(LocalDate localDate) {
		Date newDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return newDate;
	}
	
	

}
