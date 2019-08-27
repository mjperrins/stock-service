package com.ibm.stock.controller;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import com.ibm.stock.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class StockItemsApiController implements StockItemsApi {
    private final ObjectMapper objectMapper;

    @Autowired
    private CloudantClient client;
    private Database db = null;

    public StockItemsApiController(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        System.out.println("Constructing beans");
        db = client.database("stock", true);
    }

    public ResponseEntity<Stock> add(@ApiParam(value = "Stock name" ,required=true )  @Valid @RequestBody String productName,
                                     @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Stock>(objectMapper.readValue("", Stock.class), HttpStatus.OK);
        }

        return new ResponseEntity<Stock>(HttpStatus.OK);
    }

    public ResponseEntity<List<Stock>> getAll(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {


        // Initialise Array of Products
        List<Stock> products = null;
        try {

            // Read the Cloudant Database
            products  = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Stock.class);

        } catch (IOException e) {
            throw new Exception("", e);
        }

        return new ResponseEntity<List<Stock>>(products, HttpStatus.OK);

    }

}
