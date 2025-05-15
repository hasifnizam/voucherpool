package org.example.service;

import org.example.common.request.OfferRequest;
import org.example.entity.OfferEntity;

import java.util.List;

public interface OfferService {

    List<OfferEntity> getAllOffer();
    OfferEntity createNewOffer(OfferRequest request);

}
