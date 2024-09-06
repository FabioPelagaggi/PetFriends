package com.infnet.petfriend.query;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;
import com.infnet.petfriend.event.PetAdoptedEvent;

import java.util.List;

@Service
public class PetQueryService {

    private final EventStore eventStore;

    public PetQueryService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public List<PetAdoptedEvent> getAllEventsForPet(String petId) {
        return eventStore.readEvents(petId).asStream()
            .map(event -> (PetAdoptedEvent) event.getPayload())
            .toList();
    }

}
