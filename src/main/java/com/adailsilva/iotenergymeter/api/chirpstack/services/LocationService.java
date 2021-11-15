package com.adailsilva.iotenergymeter.api.chirpstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.Location;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.LocationRepository;

@Service
public class LocationService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private LocationRepository locationRepository;

	private Location getLocationByID(Long id) {

		Location locationSave = locationRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return locationSave;
	}

	public Location update(Location location, Long id) {

		Location locationSave = getLocationByID(id);

//		BeanUtils.copyProperties(location, locationSave, "id");
		locationSave.setId(id);
		locationSave.setLatitude(location.getLatitude());
		locationSave.setLongitude(location.getLongitude());
		locationSave.setAltitude(location.getAltitude());
		locationSave.setSource(location.getSource());
		locationSave.setAccuracy(location.getAccuracy());
		locationSave.setRxInfo(locationSave.getRxInfo());

		return locationRepository.save(locationSave);
	}

}
