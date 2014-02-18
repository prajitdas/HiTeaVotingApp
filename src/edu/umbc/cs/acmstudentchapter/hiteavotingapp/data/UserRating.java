/**
 * 
 */
package edu.umbc.cs.acmstudentchapter.hiteavotingapp.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Prajit
 *
 */
public class UserRating {
	
	private int databaseReference;
	private String date;
	private double foodPresentationRating;

	private double foodQualityRating;
	private double rating;
	private double valueForMoneyRating;
	private double votes;
	
	public UserRating(double aFoodPresentationRating, double aFoodQualityRatingBar, double aValueForMoneyRating) {
		setDate();
		setFoodPresentationRating(aFoodPresentationRating);
		setFoodQualityRating(aFoodQualityRatingBar);
		setValueForMoneyRating(aValueForMoneyRating);
		//compute the rating and store in the database
		setRating();
		setVotes(1.0);
	}

	public UserRating(int id, String date, double rating, double votes) {
		setDate(date);
		setRating(rating);
		setVotes(votes);
		setDatabaseReference(id);
	}

	public int getDatabaseReference() {
		return databaseReference;
	}

	public String getDate() {
		return date;
	}

	private double getFoodPresentationRating() {
		return foodPresentationRating;
	}

	private double getFoodQualityRating() {
		return foodQualityRating;
	}

	public double getRating() {
		return rating;
	}

	private double getValueForMoneyRating() {
		return valueForMoneyRating;
	}

	public double getVotes() {
		return votes;
	}

	public void setDatabaseReference(int databaseReference) {
		this.databaseReference = databaseReference;
	}

	public void setDate() {
		long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");

        Date aDate = new Date(yourmilliseconds);
        date = sdf.format(aDate);
	}
	
	private void setDate(String date) {
		this.date = date;
	}

	private void setFoodPresentationRating(double foodPresentationRating) {
		this.foodPresentationRating = foodPresentationRating;
	}

	private void setFoodQualityRating(double foodQualityRating) {
		this.foodQualityRating = foodQualityRating;
	}

	public void setRating() {
		rating = (getFoodPresentationRating()+getFoodQualityRating()+getValueForMoneyRating())/3.0;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	private void setValueForMoneyRating(double valueForMoneyRating) {
		this.valueForMoneyRating = valueForMoneyRating;
	}

	public void setVotes(double votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return Double.toString(getRating());
	}
}