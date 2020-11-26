package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    public void listAllBusinesses();
    public void selectBusinesses();

    public void saveBusiness();
    public void removeBusiness();


    public Business login();

    abstract void updatePassword(Integer businessId);

    void getBusinessById(Integer businessId);

    void updateBusiness(Integer businessId);
}


