package com.ibm.stock.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * A product object
 */
@ApiModel(description = "A product object")
@Validated
@javax.annotation.Generated(value = "com.ibm.mobile.sdkgen.platform.JavaSpringBootCodegenConfig", date = "2017-10-21T21:39:11.308Z")

public class Stock {
  @JsonProperty("_id")
  private String id = null;

  @JsonProperty("product")
  private String product = null;

  @JsonProperty("stock")
  private int stock = 0;

  @JsonProperty("price")
  private String price = null;

  @JsonProperty("guid")
  private String guide = "";

  @JsonProperty("delivered")
  private boolean delivered = false;

  @JsonProperty("ordered")
  private int ordered = 0;

  @JsonProperty("company")
  private String company = "";

  @JsonProperty("address")
  private String address = "";

  @JsonProperty("description")
  private String description = "";

  @JsonProperty("buyer")
  private String buyer = "";

  public Stock id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Stock name(String name) {
    this.product = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getProduct() {
    return product;
  }

  public void setProduct(String name) {
    this.product = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stock product = (Stock) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.product, product.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(product)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

