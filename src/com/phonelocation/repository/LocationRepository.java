package com.phonelocation.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.phonelocation.model.IPhone;

@Repository
public class LocationRepository {

	private static final AtomicLong currentId = new AtomicLong(0L);

	private Set<IPhone> locationSet = new HashSet<IPhone>();

	public LocationRepository() {
		this.add(new IPhone("Sumy", 117.121039, 36.199293, 73.61545, System
				.currentTimeMillis()));
	}

	public boolean add(IPhone location) {
//		location.setId(currentId.getAndIncrement());
		return locationSet.add(location);
	}

	public Collection<IPhone> findall() {
		return locationSet;
	}

	public IPhone findPhoneByName(String phonename) {
		for (IPhone iPhone : locationSet) {
			if (iPhone.getName().equals(phonename)) {
				return iPhone;
			}
		}
		return null;
	}
}
