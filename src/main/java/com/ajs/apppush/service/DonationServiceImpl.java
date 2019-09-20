package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Donation;
import com.ajs.apppush.input.donation.SaveDonation;
import com.ajs.apppush.repository.DonationRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllDonation")
	public List<Donation> getAllDonation() {
		return donationRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getDonation")
	public Donation getDonation(int idx) {
		Optional<Donation> opDonation = donationRepository.findById(idx);
		
		if(opDonation.isPresent()) {
			return opDonation.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveDonation")
	public Donation saveDonation(SaveDonation donationInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Donation donation = donationRepository.findById(donationInput.getIdx())
				.orElseGet(() -> new Donation());
		
		Donation newDonation = (Donation) reflectionUtil.overWriteProperties(donation, donationInput);
		
		return donationRepository.save(newDonation);
		
	}

}
