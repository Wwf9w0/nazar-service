package com.nazar.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nazar.service.model.request.NazarRequest;
import com.nazar.service.model.response.AttachNazarResponse;
import com.nazar.service.model.response.NazarCountResponse;
import com.nazar.service.model.service.NazarPersistenceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NazarService {

    private final NazarPersistenceService nazarPersistenceService;

    public void addNazar(NazarRequest nazarRequest) {
        nazarPersistenceService.addNazar(nazarRequest);
    }

    public List<NazarCountResponse> getNazarCountOfUser(Long userId) {
        return nazarPersistenceService.getNazarsOfUser(userId);
    }

    public AttachNazarResponse getNazarSentToMe(Long userId) {
        return nazarPersistenceService.getNazarUsersForUser(userId);
    }

    public AttachNazarResponse mySentNazar(Long userId) {
        return nazarPersistenceService.getNazarUser(userId);
    }

    public void removeNazarByNazarPoint(Long userId, Long nazarId) {
        nazarPersistenceService.removeNazarByNazarPoint(userId, nazarId);
    }
}
