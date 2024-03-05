package preznyak.udemy.msscbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import preznyak.udemy.msscbreweryclient.web.model.BeerDto;
import preznyak.udemy.msscbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById(){
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();

        //when
        URI uri = breweryClient.saveNewBeer(beerDto);

        //then
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdate() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Customer")
                .build();
        URI uri = breweryClient.saveNewCustomer(customerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Customer")
                .build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}