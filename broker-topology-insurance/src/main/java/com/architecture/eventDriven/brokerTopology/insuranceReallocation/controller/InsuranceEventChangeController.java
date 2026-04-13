package com.architecture.eventDriven.brokerTopology.insuranceReallocation.controller;
import com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal.RelocationInitialEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

    @RestController
    @RequestMapping("/insurance")
    @RequiredArgsConstructor
    public class InsuranceEventChangeController {

        private final ApplicationEventPublisher broker;

        @PostMapping("/move/{id}")


        public String announceAddressChange(@PathVariable String id) {

            broker.publishEvent(new RelocationInitialEvent(id));
            return "Address change announced for " + id;
        }
    }





