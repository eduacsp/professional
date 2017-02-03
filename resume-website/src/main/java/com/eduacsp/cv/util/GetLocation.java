package com.eduacsp.cv.util;

import java.io.File;
import java.io.IOException;

import com.eduacsp.cv.helper.ServerLocation;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;

public class GetLocation {

	public ServerLocation getLocation(String ipAddress) {
		//ClassLoader classLoader = this.getClass().getClassLoader();  
		//File file= new File(classLoader.getResource("location/GeoLiteCity.dat").getFile());  
		return getLocation(ipAddress, null);
	}

	public ServerLocation getLocation(String ipAddress, File file) {

		ServerLocation serverLocation = new ServerLocation();

		if(file!=null){
			try {
				LookupService lookup = new LookupService(file,LookupService.GEOIP_MEMORY_CACHE);
				Location locationServices = lookup.getLocation(ipAddress);

				if(locationServices!=null){
					serverLocation.setCountryCode(locationServices.countryCode);
					serverLocation.setCountryName(locationServices.countryName);
					serverLocation.setRegion(locationServices.region);
					serverLocation.setRegionName(regionName.regionNameByCode(
							locationServices.countryCode, locationServices.region));
					serverLocation.setCity(locationServices.city);
					serverLocation.setPostalCode(locationServices.postalCode);
					serverLocation.setLatitude(String.valueOf(locationServices.latitude));
					serverLocation.setLongitude(String.valueOf(locationServices.longitude));
				}

			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return serverLocation;

	}

}
