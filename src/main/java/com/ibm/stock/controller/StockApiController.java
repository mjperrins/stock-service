package com.ibm.stock.controller;

import java.util.List;

import com.ibm.stock.model.Stock;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
@javax.annotation.Generated(value = "com.ibm.mobile.sdkgen.platform.JavaSpringBootCodegenConfig", date = "2017-10-21T21:39:11.308Z")

@Controller
public class StockApiController implements StockApi {
    private final ObjectMapper objectMapper;

    public StockApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<Stock> delete(@ApiParam(value = "Product ID",required=true ) @PathVariable("id") Long id,
                                        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Stock>(objectMapper.readValue("", Stock.class), HttpStatus.OK);
        }

        return new ResponseEntity<Stock>(HttpStatus.OK);
    }

    public ResponseEntity<Stock> get(@ApiParam(value = "Product ID",required=true ) @PathVariable("id") Long id,
                                     @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Stock>(objectMapper.readValue("", Stock.class), HttpStatus.OK);
        }

        return new ResponseEntity<Stock>(HttpStatus.OK);
    }

    public ResponseEntity<Stock> update(@ApiParam(value = "Product ID",required=true ) @PathVariable("id") Long id,
                                        @ApiParam(value = "Product name" ,required=true )  @Valid @RequestBody String productName,
                                        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Stock>(objectMapper.readValue("", Stock.class), HttpStatus.OK);
        }

        return new ResponseEntity<Stock>(HttpStatus.OK);
    }

    @Api(value = "stock", description = "The stock API")
    public static interface StockItemsApi {

        @ApiOperation(value = "", notes = "Add new stock item", response = Stock.class, tags={ "stock", })
        @ApiResponses(value = {
            @ApiResponse(code = 200, message = "One stock item", response = Stock.class) })
        @RequestMapping(value = "/stock",
            produces = { "application/json" },
            consumes = { "text/plain" },
            method = RequestMethod.POST)
        ResponseEntity<Stock> add(@ApiParam(value = "Product name", required = true) @Valid @RequestBody String productName, @RequestHeader(value = "Accept", required = false) String accept) throws Exception;


        @ApiOperation(value = "", notes = "Get all Stock Items", response = Stock.class, responseContainer = "List", tags={ "stock", })
        @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all stock items", response = Stock.class, responseContainer = "array") })
        @RequestMapping(value = "/stock/items",
            produces = { "application/json" },
            method = RequestMethod.GET)
        ResponseEntity<List<Stock>> getAll(@RequestHeader(value = "Accept", required = false) String accept) throws Exception;

    }
}
