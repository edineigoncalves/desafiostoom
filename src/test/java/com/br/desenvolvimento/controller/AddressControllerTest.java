package com.br.desenvolvimento.controller;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.br.desenvolvimento.Builders;
import com.br.desenvolvimento.entity.Address;
import com.br.desenvolvimento.repository.AddressRepository;
import com.br.desenvolvimento.service.AddressService;
import com.br.desenvolvimento.service.impl.AddressServiceImpl;

public class AddressControllerTest {
	
	@Mock
	private AddressServiceImpl addressServiceImpl;
	
	@InjectMocks
	private AddressController addressController;
	
	@Mock
	private AddressRepository addressRepository;
	
	@Mock
	private AddressService addressService;
	
	@BeforeEach
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindAll() {
		Mockito.when(addressServiceImpl.findAll()).thenReturn(Builders.buildListAddress());
		addressController.findAll();
		Mockito.verify(addressServiceImpl).findAll();
		
	}
	
	@Test
	public void testFindById() {
		Mockito.when(addressServiceImpl.findById(1l)).thenReturn(Optional.of(Builders.buildAddress()));
		addressController.findById(1l);
		Mockito.verify(addressServiceImpl).findById(1l);
	}
	
	@Test
	public void testSaveAddress() {
		Address address = Builders.buildAddress();
		Mockito.when(addressServiceImpl.saveAddress(address)).thenReturn(address);
		addressController.saveAddress(address);
		Mockito.verify(addressServiceImpl).saveAddress(address);
	}
	
	@Test
	public void testFindByStreetNameANdNumber() {
		Mockito.when(addressServiceImpl.findByStreetNameAndNumber("Rua 7",207)).thenReturn(Builders.buildAddressWithNumber());
		addressController.findByStreetNameAndNumber("Rua 7",207);
		Mockito.verify(addressServiceImpl).findByStreetNameAndNumber("Rua 7",207);
	}
	
	@Test
	public void testFindByZipCode() {
		Mockito.when(addressServiceImpl.findByZipCode("13050812")).thenReturn(Builders.buildListAddress());
		addressController.findByZipCode("13050812");
		Mockito.verify(addressServiceImpl).findByZipCode("13050812");
	}
	
	@Test
	public void testDelete() {
		Address address = Builders.buildAddressWithId();
		Mockito.when(addressServiceImpl.deleteByAddressId(address.getId())).thenReturn(address);
		addressController.delete(address.getId());
		Mockito.verify(addressServiceImpl).deleteByAddressId(address.getId());
	}
	
	@Test
	public void testUpdateAddress() {
		Address address = Builders.buildAddress();
		Mockito.when(addressServiceImpl.saveAddress(address)).thenReturn(address);
		addressController.updateAddress(address);
		Mockito.verify(addressServiceImpl).saveAddress(address);
	}
	

}
