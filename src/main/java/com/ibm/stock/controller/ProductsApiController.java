package com.ibm.stock.controller;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import com.ibm.stock.model.Product;
import com.ibm.stock.service.ProductsApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "com.ibm.mobile.sdkgen.platform.JavaSpringBootCodegenConfig", date = "2017-10-11T01:54:57.548Z")

@RestController
public class ProductsApiController implements ProductsApi {
    private final ObjectMapper objectMapper;


    @Autowired
    private CloudantClient client;
    private Database db = null;

    public ProductsApiController(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        System.out.println("Constructing beans");
        db = client.database("products", true);
    }

    public ResponseEntity<Product> add(@ApiParam(value = "Product name" ,required=true )  @Valid @RequestBody String productName,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Product>(objectMapper.readValue("", Product.class), HttpStatus.OK);
        }

        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getAll(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {


        // Initialise Array of Products
        List<Product> products = null;

        try {

            // Read the Cloudant Database
            products  = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Product.class);

        } catch (IOException e) {
            throw new Exception("", e);
        }

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

    }

}
