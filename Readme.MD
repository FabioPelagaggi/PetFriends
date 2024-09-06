# Pet Friends - Event Sourcing and CQRS Project

Pet Friends is a sample project that demonstrates the use of **Event Sourcing** and **CQRS** (Command Query Responsibility Segregation) patterns in a Java application. It manages pet adoptions, where actions such as adopting a pet are handled as commands, and domain events are stored in an event store. The project uses **Axon Framework** for command handling, event sourcing, and aggregates.

## Table of Contents

- [Technologies](#technologies)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
  - [Commands](#commands)
  - [Queries](#queries)
- [Event Sourcing](#event-sourcing)
- [CQRS](#cqrs)
- [Contributing](#contributing)
- [License](#license)

## Technologies

- Java 11+
- Spring Boot
- Axon Framework
- JPA / Hibernate
- H2 Database (in-memory for demo purposes)
- Maven (build tool)

## Architecture Overview

This project uses **Domain-Driven Design (DDD)** principles, along with **CQRS** and **Event Sourcing** patterns:

- **Command Side**: Handles state changes triggered by user actions, such as pet adoption. It uses `CommandHandlers` to process the commands and persist domain events in an event store.
- **Query Side**: Retrieves data from the event store and/or materialized views. This side provides various query handlers to fetch current or historical data.

Key Concepts:
- **Aggregate**: Represents a collection of domain objects that are treated as a single unit for state changes.
- **Command**: Represents an action that triggers a change in the system.
- **Event**: Captures important state changes triggered by commands.
- **Event Sourcing**: Instead of storing the current state, the system stores a series of events and reconstructs the state by replaying these events.
  
## Project Structure

The project is organized into packages to separate concerns and adhere to clean architecture principles:

```
src/
 └── main/
     └── java/
         └── com/
             └── petfriends/
                 ├── aggregate/          # Contains aggregate classes
                 ├── command/            # Command classes and handlers
                 ├── controller/         # REST controllers
                 ├── event/              # Domain events
                 ├── query/              # Query services for fetching data
                 ├── repository/         # JPA repositories for entity persistence
                 └── service/            # Command services for business logic
```

- `aggregate/`: Defines the domain logic using Axon aggregates and handlers.
- `command/`: Defines commands that trigger changes in the system.
- `controller/`: REST endpoints for sending commands and querying the system.
- `event/`: Contains domain events that capture changes in state.
- `query/`: Provides services to retrieve data and query domain events.
- `repository/`: JPA repository to persist entity states.
- `service/`: Contains business services that interact with the aggregates and handle commands.

## Installation

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- (Optional) Docker (if you want to use an external database)

### Steps

1. Clone the repository:

    ```bash
    git clone https://github.com/FabioPelagaggi/PetFriends.git
    ```

2. Navigate to the project directory:

    ```bash
    cd pet-friends
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

The application will start on [http://localhost:8080](http://localhost:8080).

## Usage

### Commands

Commands represent user actions that modify the system's state. The Pet Friends system supports the following command:

#### Adopt a Pet
Endpoint: `/adopt`

**POST** `/adopt`

```json
{
  "petId": "pet123",
  "newOwnerId": "owner456"
}
```

This command triggers the adoption of a pet and stores an event indicating that the pet was adopted by the new owner.

### Queries

You can query the system for current or past events:

#### Get all events for a Pet
Endpoint: `/pets/events/{petId}`

**GET** `/pets/events/{petId}`

Example response:

```json
[
  {
    "petId": "pet123",
    "newOwnerId": "owner456",
    "timestamp": "2024-01-01T12:00:00Z"
  }
]
```

#### Get Pet by ID
Endpoint: `/pets/{petId}`

**GET** `/pets/{petId}`

Example response:

```json
{
  "petId": "pet123",
  "ownerId": "owner456"
}
```

## Event Sourcing

The system leverages **Event Sourcing** to persist domain events instead of the current state. Each command triggers an event that is stored and replayed when needed to recreate the state of an aggregate.

Example event: `PetAdoptedEvent`

```java
public class PetAdoptedEvent extends BaseEvent {
    private final String petId;
    private final String newOwnerId;

    public PetAdoptedEvent(String petId, String newOwnerId) {
        super(petId);
        this.petId = petId;
    }

}
```

## CQRS

The system is divided into two main components:

- **Command Side**: Handles all actions that modify state (such as pet adoption).
- **Query Side**: Handles fetching and reading the current state or historical data.

This separation allows for scaling each side independently and ensures that read and write operations can be optimized individually.