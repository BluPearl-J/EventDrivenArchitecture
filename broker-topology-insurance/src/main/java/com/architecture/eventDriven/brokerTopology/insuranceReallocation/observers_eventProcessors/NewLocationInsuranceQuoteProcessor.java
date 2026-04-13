package com.architecture.eventDriven.brokerTopology.insuranceReallocation.observers_eventProcessors;


import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.AddressChangedFollowupEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class NewLocationInsuranceQuoteProcessor {

    @EventListener
    public void calculatingNewLocationPricing(AddressChangedFollowupEvent event) {

        System.out.println("ReCalculating new location rates for: " + event.getCustomerId());
    }
}