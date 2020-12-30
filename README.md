# ACHTUNG

The classic game Achtung Die Kurwe/Curve Fever written in JavaFx 
with standard Java networking libraries for connecting and playing multiplayer via LAN.

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

![Gif 1](./AchtungGif1.gif?raw=true)
![Gif 2](./AchtungGif2.gif?raw=true)