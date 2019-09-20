package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.Donation;
import com.ajs.apppush.input.donation.SaveDonation;

public interface DonationService {

	public List<Donation> getAllDonation();
	
	public Donation getDonation(int idx);
	public Donation saveDonation(SaveDonation donationInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
