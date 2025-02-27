# Emergency Dispatch Center Simulation

## Overview
An emergency dispatch centre is responsible for answering emergency calls, planning responses, and dispatching appropriate emergency vehicles. This simulation represents the working process of an emergency dispatch center, including handling fire stations, fire trucks, and ambulances.

## User Stories

### 1. Registering Emergency Calls
- When a new emergency call is made, it must be recorded in the waiting list.

### 2. Dispatching Vehicles
- Once an emergency call is registered, the required emergency vehicles are planned and dispatched based on the type of emergency.
- The emergency will be handled, requiring a specified amount of time for resolution.

### 3. Emergency Priority Handling
- Large emergencies have the highest priority.
- Medical emergencies are classified as middle-sized emergencies.
- Small emergencies are handled with the lowest priority.

## Components

### Fire Stations
- Each fire station stores fire trucks and ambulances until they are needed.

### Vehicles
- **Fire Trucks**: Used for fire-related emergencies.
- **Ambulances**: Can transport patients, with or without a doctor present.
  - **Ambulance with Doctor**: Can handle critical medical emergencies.
  - **Ambulance without Doctor**: Can handle non-critical patient transport.

## Simulation Process
1. **Emergency Call Received** → Call is registered.
2. **Resource Allocation** → Fire trucks and/or ambulances are assigned based on emergency type and priority.
3. **Dispatch & Handling** → Vehicles are sent, and the emergency is addressed within a specified time.
4. **Completion** → Emergency is resolved, and vehicles return to the station.

This simulation aims to represent the efficiency and prioritization strategies of an emergency dispatch center.
