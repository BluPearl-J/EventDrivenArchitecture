package com.architecture.eventDriven.brokerTopology.insuranceReallocation.observers_eventProcessors;

import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.AddressChangedFollowupEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;



@Component
@RequiredArgsConstructor
public class EmailNotificationProcessor {

    @EventListener
    public void sendEmailIfAddressChangedMessageSignalTriggered(AddressChangedFollowupEvent addressChangedFollowUpEvent) {

        System.out.println("-> EmailProcessor listening for followupEvent successful: Preparing notification for customer " + addressChangedFollowUpEvent.getCustomerId());

        // production app call an EmailService.send(...)here.
        System.out.println("-> SUCCESS: Email sent to customer " + addressChangedFollowUpEvent.getCustomerId() + " confirming their relocation.");
    }
}
