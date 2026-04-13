package com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

    @Getter
    @RequiredArgsConstructor
    @ToString
    public class AddressChangedFollowupEvent {
        private final String customerId;
    }


