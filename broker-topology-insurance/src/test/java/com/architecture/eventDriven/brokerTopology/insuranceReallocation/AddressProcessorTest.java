package com.architecture.eventDriven.brokerTopology.insuranceReallocation;

import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.AddressChangedFollowupEvent;
import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.RelocationInitialEvent;
import com.architecture.eventDriven.brokerTopology.insuranceReallocation.observers_eventProcessors.AddressProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RecordApplicationEvents
class AddressProcessorTest {

    @Autowired
    private AddressProcessor addressProcessor;

    @Autowired
    private ApplicationEvents recordedEvents;

    @Test
    void test_UpdateDB_Logic_Chain() {
        // ARRANGE
        RelocationInitialEvent customerRelocatedMessageSignal = new RelocationInitialEvent("USER-123");

        // ACT
        addressProcessor.updateDBifRelocationEventTriggered(customerRelocatedMessageSignal);

        // ASSERT
        long eventCount = recordedEvents.stream(AddressChangedFollowupEvent.class).count();

        assertEquals(1, eventCount, "The DB update has triggered 1 AddressChangedEvent");
    }
}