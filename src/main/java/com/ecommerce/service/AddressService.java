package com.ecommerce.service;


import java.util.List;

import com.ecommerce.entity.Address;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(int id);
    List<Address> getAllAddresses();
    Address updateAddress(Address address);
    boolean deleteAddress(int id);
}

