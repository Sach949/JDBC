package com.xworkz.bookmyshow.service;

import com.xworkz.bookmyshow.entity.RegistrationEntity;
import com.xworkz.bookmyshow.repo.RegistrationRepo;
import com.xworkz.bookmyshow.repo.RegistrationRepoImpl;

public class RegistrationServiceImpl implements RegistrationService{

    private RegistrationRepo repo = new RegistrationRepoImpl();

    @Override
    public boolean saveUser(RegistrationEntity entity) {
        return repo.saveUser(entity);
    }
}