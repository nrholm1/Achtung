# ACHTUNG

The classic game Achtung Die Kurwe/Curve Fever written in JavaFx 
with a small server environment built with standard Java networking libraries for connecting and playing multiplayer via LAN.

Overview of the project structure:
```bash
├── Game
│   ├── PlayerObjects
│   │   ├── Coord
│   │   ├── Kurwe
│   │   └── Vec2D
│   ├── GameConstants
│   └── GameLogic
├── Networking
│   ├── TestDriver
│   ├── Client
│   │   ├── ServerSocket (?)
│   │   └── Client
│   ├── Server
│   │   ├── ClientHandler
│   │   ├── CommonRuntime
│   │   ├── SocketListener
│   │   └── StateRenderer
│   └── Utils
│       ├── Payload
│       └── PayloadBuilder
└── GUI
    ├── Main
    ├── MenuController
    ├── GameWindowController
    ├── Render
    └── RenderTestDriver
```

## Interactions between components in networking platform
![Client diagram](./ClientDiagram2.png?raw=true)
![Server diagram](./ServerDiagram2.png?raw=true)

## Demo
Side by side view of two clients connecting to the same runtime:
<em><b> note </b></em> lag is caused by recording software on preview 2

PC 1 (HOST and CLIENT):

![Gif 1](./AchtungGif1.gif?raw=true)

PC 2 (CLIENT):

![Gif 2](./AchtungGif2.gif?raw=true)


## TODO
- Custom serialization for even quicker transaction speeds
- Add nicer logic for handling connection loss and thread interruptions
- Improve collision detection