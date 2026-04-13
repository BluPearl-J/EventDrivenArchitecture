package com.architecture.eventDriven.brokerTopology.insuranceReallocation.observers_eventProcessors;

import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.AddressChangedFollowupEvent;
import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.RelocationInitialEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressProcessor {

    private final ApplicationEventPublisher broker;

    @EventListener
    public void updateDBifRelocationEventTriggered(RelocationInitialEvent startSignal) {

        System.out.println("-> AddressProcessor: Updating DB for customer " + startSignal.getCustomerId());
        // In a real app, call a repository here: repository.save(...)
        System.out.println("DB update successful;publishing/creating new follow-up event object");

        broker.publishEvent(new AddressChangedFollowupEvent(startSignal.getCustomerId()));
    }
}
