package com.ecommerce.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ecommerce.dao.DAOAddress;
import com.ecommerce.entity.Address;
import com.ecommerce.service.AddressService;

public class AddressServiceImpl implements AddressService {
    private final DAOAddress addressDAO;

    public AddressServiceImpl(SessionFactory factory) {
        this.addressDAO = new DAOAddress(factory);
    }

    @Override
    public Address createAddress(Address address) {
        addressDAO.saveAddress(address);
        return address;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressDAO.getAddressById(id);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressDAO.getAllAddresses();
    }

    @Override
    public Address updateAddress(Address address) {
        addressDAO.updateAddress(address);
        return address;
    }

    @Override
    public boolean deleteAddress(Long id) {
        Address address = addressDAO.getAddressById(id);
        if (address != null) {
            addressDAO.deleteAddress(address);
            return true;
        }
        return false;
    }
}
