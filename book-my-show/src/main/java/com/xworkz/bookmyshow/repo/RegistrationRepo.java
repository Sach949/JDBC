package com.xworkz.bookmyshow.repo;

import com.xworkz.bookmyshow.entity.RegistrationEntity;

public interface RegistrationRepo {

    boolean saveUser(RegistrationEntity entity);
}
