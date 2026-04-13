package com.architecture.eventDriven.brokerTopology.insuranceReallocation.eventsDTOS_brokrMessageInputs_theObserverUpdateSIgnal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
/**
 * EVENT-DRIVEN PATTERN — Base Event (Initial Event)

 * Events are immutable value objects DTOS: they carry data but have no behaviour.Analogy request.
 * 'final' ensures immutability - once a fact/command (analogy (request)) happens, it cannot be changed
 *  fundamental rule Event-Driven Architecture: Events must be Immutable.
 *Unlike standard models with @Setter incase to Change the user's name later. An Event is different.no @setter.immmutable
 * 1. Events are "Facts"/commands (The No-Setter Rule). An event represents something that already happened in the past.
 * If a customer moved, that is a fact.

 * 2. The Code: Get, but No Set
 * events are Get-Only.  private final String-the only way to put data into it is via Constructor when the object is first created.

 * To Write:  use the Constructor (new RelocationEvent("123")).
 * To Read: use the Getter (event.getCustomerId()).

 * To Change: You can't. need to create a whole new event.

 * (The Follow-up Event)
 * This is what a Processor publishes after it finishes its job. analogy response.
 * It signals that the system state has officially updated.
 * RelocationInitialEvent "I want to move!" (A Request) Who is listening?:  The DatabaseUpdater db AddressChanged
 * FollowupEvent "I have moved!" (A Fact) consumer listening?: Emailer / Tax Dept
 */

public class RelocationInitialEvent {

    private final String customerId;
}

