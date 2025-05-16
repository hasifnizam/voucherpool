package org.example.service;

import org.example.common.request.RecipientRequest;
import org.example.entity.RecipientEntity;

import java.util.List;

public interface RecipientService {

    List<RecipientEntity> getAllRecipient();
    RecipientEntity registerNewUser(RecipientRequest request);
}
