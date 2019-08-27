package com.ibm.stock.controller;

import com.ibm.stock.model.Product;
import com.ibm.stock.service.ProductApi;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@javax.annotation.Generated(value = "com.ibm.mobile.sdkgen.platform.JavaSpringBootCodegenConfig", date = "2017-10-21T21:39:11.308Z")

@RestController
public class ProductApiController implements ProductApi {
    private final ObjectMapper objectMapper;

    public ProductApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<Product> delete(@ApiParam(value = "Product ID",required=true ) @PathVariable("id") Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Product>(objectMapper.readValue("", Product.class), HttpStatus.OK);
        }

        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    public ResponseEntity<Product> get(@ApiParam(value = "Product ID",required=true ) @PathVariable("id") Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Product>(objectMapper.readValue("", Product.class), HttpStatus.OK);
        }

        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    public ResponseEntity<Product> update(@ApiParam(value = "Product ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "Product name" ,required=true )  @Valid @RequestBody String productName,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Product>(objectMapper.readValue("", Product.class), HttpStatus.OK);
        }

        return new ResponseEntity<Product>(HttpStatus.OK);
    }

}
