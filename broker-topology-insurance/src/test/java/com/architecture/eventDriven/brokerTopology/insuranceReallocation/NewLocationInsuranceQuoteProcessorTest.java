
package com.architecture.eventDriven.brokerTopology.insuranceReallocation;

import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.AddressChangedFollowupEvent;
import com.architecture.eventDriven.brokerTopology.insuranceReallocation.observers_eventProcessors.NewLocationInsuranceQuoteProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class NewLocationInsuranceQuoteProcessorTest {

    @Autowired
    private NewLocationInsuranceQuoteProcessor quoteProcessor;

    @Test
    void test_CalculatingNewLocationPricing_ExecutesPriceUpdateLogic() {
        // 1. ARRANGE

        AddressChangedFollowupEvent addressChangedSignal = new AddressChangedFollowupEvent("USER-123");

        // 2. ACT & 3. ASSERT

        assertDoesNotThrow(() -> {
            quoteProcessor.calculatingNewLocationPricing(addressChangedSignal);
        }, "The Quote Processor calculates new pricing  without throwing exceptions");
    }
}