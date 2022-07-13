package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.ProductPurchase;
import java.util.List;
import java.util.Optional;


public interface ProductPurchaseService {

    List<ProductPurchase> list();
    Optional<ProductPurchase> byId(Long id);
    ProductPurchase save(ProductPurchase productPurchase);
    void delete(Long id);


}
