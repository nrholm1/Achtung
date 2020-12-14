# TODO

## CommonRuntime

### Description of functionality: 
#####1. interface with StateRenderer
#####2. listen for new connections with clients
#####3. create and manage socket connections with clients

### High level implementation:
1. implement by storing a reference to the StateRenderer instance and having methods to do specific operations
2. create socket listeners with new ports (increment) until a timeout condition is reached, after which the game can start
3. the ClientHandlers that are created as a result of the socket listeners are added to a HashMap indexed by their port no.'s

