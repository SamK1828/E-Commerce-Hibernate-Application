package com.ecommerce.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ecommerce.dao.DAOAddress;
import com.ecommerce.entity.Address;
import com.ecommerce.service.AddressService;
import com.mysql.cj.Session;

public class AddressServiceImpl implements AddressService {
       private final DAOAddress addressDao;

    public AddressServiceImpl(SessionFactory factory) {
        this.addressDao = new DAOAddress(factory);
    }

    @Override
    public Address createAddress(Address address) {
        addressDao.saveAddress(address);
        return address;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressDao.getAddressById(id.intValue());
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressDao.getAllAddresses();
    }

    @Override
    public Address updateAddress(Address address) {
        addressDao.updateAddress(address);
        return address;
    }

    @Override
    public boolean deleteAddress(Long id) {
        Address address = addressDao.getAddressById(id.intValue());
        if (address != null) {
            addressDao.deleteAddress(address);
            return true;
        }
        return false;
    }
}
