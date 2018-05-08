package com.tracker.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@Component("workoutTrackerDao")
public class WorkoutTrackerDao {
	
	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	@Autowired
	private WorkoutCollectionRepository workoutCollectionRepository;
	
	public List<WorkoutActiveEntity> fetchWorkoutTrackerData(String currentDate) {
		List<WorkoutActiveEntity> completedWorkoutsList = workoutActiveRepository.findCurrentDayWorkoutTime(currentDate,CommonConstants.WORKOUT_COMPLETED_STATUS);
		System.out.println("completedWorkoutsList: " + completedWorkoutsList);
		return completedWorkoutsList;
	}
	
	
	public List<WorkoutCollectionEntity> fetchCurrentWeekWorkouts() {
		LocalDate today = LocalDate.now();
		LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }
	    Date mondayDate = covertLocaleDateToDate(monday);
	    System.out.println("mondayDate : "+ mondayDate);
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }
	    Date sundayDate = covertLocaleDateToDate(sunday);
	    System.out.println("sundayDate : "+ sundayDate);
		//List<WorkoutActiveEntity> currentWeekWorkouts = workoutActiveRepository.fetchCurrentWeekWorkouts(monday,sunday);
		/*for(WorkoutActiveEntity workoutActiveEntity :currentWeekWorkouts) {
			System.out.println("**************************");
			System.out.println(workoutActiveEntity.toString());
			System.out.println("**************************");
		}*/
	   List<WorkoutCollectionEntity> currentWeekWorkouts = workoutCollectionRepository.fetchCurrentWeekWorkouts(mondayDate,sundayDate);
	   for(WorkoutCollectionEntity workoutCollectionEntity :currentWeekWorkouts) {
			System.out.println("**************************");
			System.out.println(workoutCollectionEntity.toString());
			System.out.println("**************************");
		}
	   return currentWeekWorkouts;
	}
	
	public List<WorkoutCollectionEntity> fetchCurrentMonthWorkouts() throws BusinessException{
		Date firstDayOfMonth = getFirstDateOfMonth(new Date());		
		Date lastDayOfMonth = getLastDateOfMonth(new Date());
		System.out.println("First day : "+ firstDayOfMonth + "lastDayOfMonth : " + lastDayOfMonth);
		List<WorkoutCollectionEntity> currentMonthWorkouts = workoutCollectionRepository.fetchCurrentMonthWorkouts(firstDayOfMonth,lastDayOfMonth);
		return currentMonthWorkouts;
	}
	
	
	public List<WorkoutCollectionEntity> fetchCurrentYearWorkouts(){
		List<WorkoutCollectionEntity> currentYearWorkouts = workoutCollectionRepository.fetchCurrentYearWorkouts(CommonConstants.CURRENT_YEAR);
		return currentYearWorkouts;
	}
	
	private Date getFirstDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
	
	private Date getLastDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
	
	private Date covertLocaleDateToDate(LocalDate localDate) {
		Date newDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return newDate;
	}
	
	
	
	/*public static void main(String[] args) {
	    LocalDate today = LocalDate.now();

	    // Go backward to get Monday
	    LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }

	    // Go forward to get Sunday
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }

	   
	  }*/
	

}
