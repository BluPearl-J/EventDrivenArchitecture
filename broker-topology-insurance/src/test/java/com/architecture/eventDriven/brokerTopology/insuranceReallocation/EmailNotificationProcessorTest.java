package com.architecture.eventDriven.brokerTopology.insuranceReallocation;

import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.AddressChangedFollowupEvent;
import com.architecture.eventDriven.brokerTopology.insuranceReallocation.observers_eventProcessors.EmailNotificationProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class EmailNotificationProcessorTest {

    @Autowired
    private EmailNotificationProcessor emailProcessor;

    @Test
    void test_Email_Logic_Execution() {
        // ARRANGE
        // The input  "Follow-up" signal from the previous processor
        AddressChangedFollowupEvent addressChangedMessageSignal = new AddressChangedFollowupEvent("USER-123");

        // ACT & ASSERT
        assertDoesNotThrow(() -> {
            emailProcessor.sendEmailIfAddressChangedMessageSignalTriggered(addressChangedMessageSignal);
        }, "The email processor handled the message signal without errors.");
    }
}